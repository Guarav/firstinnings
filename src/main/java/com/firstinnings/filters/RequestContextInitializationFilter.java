package com.firstinnings.filters;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.firstinnings.RequestContext;
import com.firstinnings.dto.Login;
import com.firstinnings.repositories.LoginRepository;

/**
 * This filter is responsible for populating the request context of the user logged in. This filter
 * will run after the authentication filter. Created by poplig on 9/11/16.
 */
public class RequestContextInitializationFilter extends AbstractFilter {

    @Autowired
    private LoginRepository loginRepository;

    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        // Get the request context from the http request.
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (!validateStaticRequest(httpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        RequestContext requestContext = (RequestContext) httpServletRequest.getAttribute("requestContext");

        // Ideally this should not be null.
        if (requestContext != null) {

            // Get user details on the basis of user Id.
            String userId = requestContext.getUserId();
            Login login = loginRepository.findOne(userId);

            requestContext.setRoles(login.getRoles());
            String servletPath = httpServletRequest.getServletPath();
            requestContext.setPageType(servletPath.substring(1, servletPath.length()));
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
