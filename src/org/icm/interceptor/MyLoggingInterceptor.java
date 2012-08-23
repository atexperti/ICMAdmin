package org.icm.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyLoggingInterceptor implements Interceptor {
	private static Logger logger = Logger.getLogger(MyLoggingInterceptor.class);
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		logger.info("In MyLoggingInterceptor.intercept");
		String className = invocation.getAction().getClass().getName();
		long startTime = System.currentTimeMillis();
		logger.info("Before calling action: " + className);
		String result = invocation.invoke();
		long endTime = System.currentTimeMillis();
		logger.info("After calling action: " + className + " Time taken: " + (endTime - startTime) + " ms");
		return result;
	}

	public void destroy() {
		logger.info("Destroying MyLoggingInterceptor...");
	}

	public void init() {
		logger.info("Initializing MyLoggingInterceptor...");
	}

}
