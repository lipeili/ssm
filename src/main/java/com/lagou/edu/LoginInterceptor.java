package com.lagou.edu;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Created by videopls
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("1".equals(request.getSession().getAttribute("isAuth"))) {
            return true;
        }

        response.sendRedirect(request.getContextPath() + "/index.jsp");

        return false;
    }

}
