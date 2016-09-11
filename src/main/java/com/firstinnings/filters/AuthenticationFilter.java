package com.firstinnings.filters;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstinnings.RequestContext;

/**
 * Authentication filter that runs on every request and depending on whether the user is valid or
 * not, redirect to home or login page. Created by poplig on 9/3/16.
 */
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // this is the check to make sure that we do not apply this filter in login page case.
        if (((HttpServletRequest) servletRequest).getRequestURI().contains("login")) {
            return;
        }

        // Retrieve the user id from the session.
        HttpSession httpSession = httpServletRequest.getSession();

        Object userId = httpSession.getAttribute("userId");
        if (userId != null) {
            RequestContext requestContext = new RequestContext();
            requestContext.setUserId(userId.toString());
            httpServletRequest.setAttribute("requestContext", requestContext);

        } else {
            httpServletResponse.sendRedirect("/firstinnings/login");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
