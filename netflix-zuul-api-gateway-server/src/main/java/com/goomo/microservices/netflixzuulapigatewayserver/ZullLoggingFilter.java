package com.goomo.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZullLoggingFilter extends ZuulFilter {

	private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// log the details of the request
		HttpServletRequest request = com.netflix.zuul.context.RequestContext.getCurrentContext().getRequest();
		logger.info("request ->{} request uri->{}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
