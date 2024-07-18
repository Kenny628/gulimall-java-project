package com._yzhheng.inteceptor;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import com._yzhheng.vo.UmsMemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginUserInteceptor implements HandlerInterceptor {
    public static ThreadLocal<UmsMemberDTO> threadLocalUser = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
        String uri = request.getRequestURI();
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        // 排除掉根据订单号查询订单数据，原因feign需要过滤器登录
        boolean match = antPathMatcher.match("/api/v1/OmsOrder/orderNumber/**", uri);
        boolean match1 = antPathMatcher.match("/payment", uri);
        boolean match2 = antPathMatcher.match("/charge", uri);
        if (match || match1 || match2) {
            return true;
        }
        UmsMemberDTO member = (UmsMemberDTO) request.getSession().getAttribute("loginUser");
        if (member != null) {
            threadLocalUser.set(member);
            return true;
        } else {
            request.getSession().setAttribute("msg", "请先进行登录");
            response.sendRedirect("http://auth.gulimall.com:8600/login.html");
            return false;
        }
    }

}
