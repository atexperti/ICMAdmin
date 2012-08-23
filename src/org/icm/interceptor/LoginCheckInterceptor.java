package org.icm.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginCheckInterceptor implements Interceptor {
	private static Logger logger = Logger.getLogger(LoginCheckInterceptor.class);
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;

	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "login";
		session = ActionContext.getContext().getSession();
		logger.info("LoginCheckInterceptor:Login value form session " + session.get("icm_loggedIn"));
		if ("true".equalsIgnoreCase((String) session.get("icm_loggedIn")))
			result = invocation.invoke();
		logger.info("LoginCheckInterceptor:Invocation determined as " + result);
		return result;
	}

	public void destroy() {
		logger.info("Destroying MyLoggingInterceptor...");
	}

	public void init() {
		logger.info("Initializing MyLoggingInterceptor...");
	}

}
