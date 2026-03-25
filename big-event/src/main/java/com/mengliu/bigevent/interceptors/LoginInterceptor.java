package com.mengliu.bigevent.interceptors;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mengliu.bigevent.utils.JwtUtil;
import com.mengliu.bigevent.utils.ThreadLocalUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String token = request.getHeader("Authorization");

            if (token == null) {
                // 如果token为空，返回401
                throw new RuntimeException("Token is required");
            }
            Map<String, Object> claims = JwtUtil.parseToken(token);

            // 将claims存储到ThreadLocal中
            ThreadLocalUtil.set(claims);

            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在请求完成后，清除ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }

}
