package com.firstinnings.filters;

import com.firstinnings.RequestContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Authentication filter that runs on every request and depending on whether the user is valid or
 * not, redirect to home or login page. Created by poplig on 9/3/16.
 */
public class AuthenticationFilter extends AbstractFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if (!validateStaticRequest(httpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // this is the check to make sure that we do not apply this filter in login page case.
        if (!((HttpServletRequest) servletRequest).getRequestURI().contains("login")) {

            // Retrieve the user id from the session.
            HttpSession httpSession = httpServletRequest.getSession();

            Object userId = httpSession.getAttribute("userId");
            if (userId != null) {
                RequestContext requestContext = new RequestContext();
                requestContext.setUserId(userId.toString());
                httpServletRequest.setAttribute("requestContext", requestContext);

            } else {
                httpServletResponse.sendRedirect("/login");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
