package com._yzhheng.inteceptor;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import com._yzhheng.vo.UserInfoTo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * 在执行目标方法前，判断用户的登录状态，并封装封装给controller目标请求
 */
// TODO: Compare @Component and @Bean   
public class CartInteceptor implements HandlerInterceptor {

    public static ThreadLocal<UserInfoTo> threadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        UserInfoTo userInfoTo = new UserInfoTo();

        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("loginUser");

        if (username == null || username.equals("")) {
            userInfoTo.setUsername(username);
        }

        Cookie[] cookies = request.getCookies();

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("user-key")) {
                    userInfoTo.setUserkey(cookie.getAttribute(name));
                    userInfoTo.setTempUser(true);
                }
            }
        }

        if (StringUtils.isEmpty(userInfoTo.getUserkey())) {
            String uuid = UUID.randomUUID().toString();
            userInfoTo.setUserkey(uuid);
        }

        threadLocal.set(userInfoTo);

        return true;
    }

    /**
     * 业务执行之后
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        UserInfoTo userInfoTo = threadLocal.get();
        if (!userInfoTo.isTempUser()) {
            Cookie cookie = new Cookie("user-key", userInfoTo.getUserkey());
            cookie.setDomain("gulimall.com");
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        }
    }
}
