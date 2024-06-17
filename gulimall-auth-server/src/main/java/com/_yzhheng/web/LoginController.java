package com._yzhheng.web;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com._yzhheng.feign.MemberFeign;
import com._yzhheng.vo.UmsMemberDTO;
import com._yzhheng.vo.UserLoginVo;
import com._yzhheng.vo.UserRegisVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @Autowired
    MemberFeign memberFeign;
    // @GetMapping({ "/", "/login.html" })
    // public String login() {
    // return "login";
    // }

    // @GetMapping("/reg.html")
    // public String reg() {
    // return "reg";
    // }
    @GetMapping("/regist")
    public String regist() {
        return "redirect:/login.html";
    }

    /**
     * 用户注册
     * 
     * @param userRegisterVo
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/regist")
    public String regist(@Valid UserRegisVo userRegisterVo, BindingResult result, Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // 将错误消息返回给前端
            Map<String, String> errors = result.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            // model.addAttribute("errors",errors);
            redirectAttributes.addFlashAttribute("errors", errors);

            /**
             * 错误：Request method 'POST' not supported
             * 分析：用户注册 -> regist[post] -> 转发/reg.html（路径映射默认都是get方式访问的）
             * return "forward:/reg.html";
             * 解决直接渲染注册页
             * return "reg";
             *
             * 问题：刷新页面相当于表单重复提交
             * 解决：使用重定向到注册页面【要写完成路径】，但是转发 model里面的数据是在请求域中，重定向获取不到数据。
             * 使用RedirectAttributes 模拟重定向携带数据。
             * 分析：重定向携带数据，利用session原理。将数据放在session中，只要跳到下一个页面取出这个数据以后，session里面的数据就会删掉。
             * TODO 分布式下的session问题。
             */

            // 校验出错，重定向到注册页
            return "redirect:http://auth.gulimall.com:8600/reg.html";
        }

        ResponseEntity<String> response = memberFeign.registerUser(userRegisterVo);
        if (response.getBody() == null) {

            return "redirect:http://auth.gulimall.com:8600/login.html";
            // 成功
        } else {
            Map<String, String> errors = new HashMap<>();
            errors.put("msg", response.getBody().toString());
            System.out.println(response.getBody().toString());
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://auth.gulimall.com:8600/reg.html";
        }
        // return "redirect:/login.html";
    }

    @PostMapping("/login")
    public String login(UserLoginVo userLoginvo, RedirectAttributes redirectAttributes, HttpSession session) {
        Object response = memberFeign.loginUser(userLoginvo).getBody();
        if (response.toString().equals("Login error")) {
            Map<String, String> errors = new HashMap<>();
            // String temp = response.getBody().toString();
            errors.put("msg", response.toString());
            redirectAttributes.addFlashAttribute("errors", errors);
            // System.out.println(response.getBody().toString());
            return "redirect:http://auth.gulimall.com:8600/login.html";
            // return "redirect:http://gulimall.com:8600";
            // 成功
        } else {
            // System.out.println("successful111" + response.toString());
            // UmsMemberDTO loginMember = JSON.parseObject(response.toString(),
            // UmsMemberDTO.class);
            // session.setAttribute("loginUser", loginMember);
            JSONObject jj = JSON.parseObject(response.toString());
            session.setAttribute("loginUser", jj.getString("username").toString());
            return "redirect:http://gulimall.com:8600";
        }
    }
}
