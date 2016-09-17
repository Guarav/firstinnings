package com.firstinnings.filters;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Contain common methods to be used in all filters.
 */
public abstract class AbstractFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    /**
     * Checks whether the request is for static resources or not.
     * @param request
     * @return
     */
    public boolean validateStaticRequest(HttpServletRequest request) {

        String path = ((HttpServletRequest) request).getRequestURI();
        if(path.startsWith("/static")) {
            return false;
        }
        return true;
    }
}
