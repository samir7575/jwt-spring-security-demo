package com.softdesign.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by malek on 19/02/17.
 */
@Component
public class JwtSecurityFilter implements Filter{

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtSecurityFilter.class);

    public static final String X_AUTH_TOKEN = "Authorization";
    public static final String TOKEN = "token";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.debug("Invoking doFilter JwtSecurityFilter ");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String actualUri = httpRequest.getRequestURI();
        LOGGER.debug("Actual URI is : " + actualUri);
        String authToken = extractAuthTokenFromRequest(httpRequest);

        // verify token


    }

    @Override
    public void destroy() {

    }

    /**
     * Extract token from httpRequest.
     * @param httpRequest
     * @return value of token.
     */
    public static String extractAuthTokenFromRequest(HttpServletRequest httpRequest)
    {
		/* Get token from header */
        String authToken = httpRequest.getHeader(X_AUTH_TOKEN);

		/* If token not found get it from request parameter */
        if (authToken == null)
        {
            authToken = httpRequest.getParameter(TOKEN);
        }
        return authToken;
    }
}
