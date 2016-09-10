package com.firstinnings.filters;

import com.firstinnings.RequestContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by poplig on 9/3/16.
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
        HttpSession httpSession = httpServletRequest.getSession();

        Object userId = httpSession.getAttribute("userId");
        System.out.println("gaurav " + userId);
        if (userId != null) {
            RequestContext requestContext = new RequestContext();
            requestContext.setUserId(userId.toString());
            httpServletRequest.setAttribute("requestContext", requestContext);

        } else if (!((HttpServletRequest) servletRequest).getRequestURI().contains("login")) {
            httpServletResponse.sendRedirect("/firstinnings/login");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
