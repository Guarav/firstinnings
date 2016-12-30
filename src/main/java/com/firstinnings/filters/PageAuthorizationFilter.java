package com.firstinnings.filters;

import com.firstinnings.Constants;
import com.firstinnings.RequestContext;
import com.firstinnings.dto.Role;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by poplig on 12/31/16.
 * This filter is responsible for authorization the user page request.
 */
public class PageAuthorizationFilter extends AbstractFilter  {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        RequestContext requestContext = (RequestContext) httpServletRequest.getAttribute("requestContext");
        if(requestContext != null && !Constants.Pages.HOME.equals(requestContext.getPageType())) {
            List<Role> userRoles = requestContext.getRoles();
            Optional<Role> roleOptional = userRoles.stream().filter(userRole ->
                    userRole.getName().name().equals(requestContext.getPageType())).findFirst();

            if(!roleOptional.isPresent()) {
                // Invalid request. Redirect.
                httpServletResponse.sendRedirect(Constants.Pages.HOME);
            }
        }



        filterChain.doFilter(servletRequest, servletResponse);

    }
}
