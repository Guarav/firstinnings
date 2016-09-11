package com.firstinnings.filters;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import com.firstinnings.RequestContext;

/**
 * This filter is responsible for populating the request context of the user logged in. This filter
 * will run after the authentication filter. Created by poplig on 9/11/16.
 */
public class RequestContextInitializationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        // Get the request context from the http request.
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        RequestContext requestContext = (RequestContext) httpServletRequest.getAttribute("requestContext");

        // Ideally this should not be null.
        if(requestContext != null) {

            // Get user details on the basis of user Id.
            String userId = requestContext.getUserId();
            requestContext.setFullName("Gaurav Popli");
            requestContext.setRoles(Arrays.asList("all"));
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
