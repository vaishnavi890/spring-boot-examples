package com.vaishnavi.filter.spring.boot.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ArtDrawingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ArtDrawingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Initializing ArtDrawing filter...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        logger.info("[ArtDrawing Filter] Remote Host: {}", request.getRemoteHost());
        logger.info("[ArtDrawing Filter] Remote Address: {}", request.getRemoteAddr());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("Destroying ArtDrawing filter...");
    }
}


