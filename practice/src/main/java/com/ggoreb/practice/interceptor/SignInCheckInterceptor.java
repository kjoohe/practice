package com.ggoreb.practice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ggoreb.practice.model.User;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SignInCheckInterceptor implements HandlerInterceptor {
@Override
public boolean preHandle(
HttpServletRequest request, HttpServletResponse response,
Object handler) throws Exception {
log.debug("preHandle");
HttpSession session = request.getSession();
User user = (User) session.getAttribute("user");
if (user == null) {
response.sendRedirect("/signin");//게시글 버튼 누르면  로그인창으로 넘어감
return false;
}
return true;
}
//로그인(signin)한 사람만 게시글 올릴 수 있도록

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("postHandle");
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        log.debug("afterCompletion");
    }
}
