package com.srtech.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReqResLogFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReqResLogFilter.class)  ; 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOGGER.debug("Request : {}",request);
		chain.doFilter(request, response);
		LOGGER.debug("Response : {}",response);

	}

}
