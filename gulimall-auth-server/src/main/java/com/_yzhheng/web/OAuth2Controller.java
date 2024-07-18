package com._yzhheng.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.annotation.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com._yzhheng.feign.MemberFeign;
import com._yzhheng.vo.UmsMemberDTO;
import com._yzhheng.vo.SocialUserLogin;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import jakarta.servlet.http.HttpSession;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Controller
public class OAuth2Controller {

    @Autowired
    MemberFeign memberFeign;

    // can consider use okhttp or resttemplate
    @GetMapping("/oauth2/github/success")
    public String github(@RequestParam String code, HttpSession session) throws IOException {
        OkHttpClient client = new OkHttpClient();
        System.out.println("Triggered OK http");
        FormBody formBody = new FormBody.Builder()
                .add("client_id", "Ov23licGqxT9EL75DNb7")
                .add("client_secret", "4a42d579a6da96155b300fc1307e3385e3a3556f")
                .add("grant_type", "authorization_code")
                .add("redirect_uri", "http://auth.gulimall.com:8600/oauth2/github/success")
                .add("code", code)
                .build();
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(formBody)
                .build();
        // https://github.com/login/oauth/access_token"
        System.out.println(code);
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            // convert json to object
            // System.out.println(response.body().string());
            SocialUserLogin socialuser = parseResponse(response.body().string());
            Request requestt = new Request.Builder()
                    .url("https://api.github.com/user")
                    // This adds the token to the header.
                    .addHeader("Authorization", "Bearer " + socialuser.getAccess_token())
                    .build();
            Call userInfocall = client.newCall(requestt);
            Response userInfoResponse = userInfocall.execute();
            String userInfoString = userInfoResponse.body().string();
            System.out.println(userInfoString);
            JSONObject userInfoJson = JSON.parseObject(userInfoString);
            String retrievedUsername = userInfoJson.getString("login"); // username
            String retrievedUserId = userInfoJson.getString("id"); // id
            System.out.println(retrievedUsername + " - " + retrievedUserId);
            socialuser.setRetrievedUsername(retrievedUsername);
            socialuser.setRetrievedUserId(retrievedUserId);
            // https://api.github.com/user
            Object temp = memberFeign.loginUser(socialuser).getBody();
            UmsMemberDTO jj = JSON.parseObject(temp.toString(), UmsMemberDTO.class);
            session.setAttribute("loginUser", jj);
            System.out.println("Objectttttt: " + temp.toString());
        } else {
            return "redirect:http://auth.gulimalll.com/login.html";
        }
        return "redirect:http://gulimall.com:8600";
    }

    private static SocialUserLogin parseResponse(String response) {
        Map<String, String> params = new HashMap<>();
        String[] pairs = response.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length > 1) {
                params.put(keyValue[0], keyValue[1]);
            } else {
                params.put(keyValue[0], "");
            }
        }

        String jsonString = JSON.toJSONString(params);
        return JSON.parseObject(jsonString, SocialUserLogin.class);
    }
}
