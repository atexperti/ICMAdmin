package org.icm.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.icm.facade.IUserBo;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginAction.class);
	private String userName;
	private String password;

	private Map<String, Object> session = ActionContext.getContext()
			.getSession();
	@Autowired
	private IUserBo userBo;

	/**
	 * Populate all categories related to device model on index page
	 */
	public String input() {

		return SUCCESS;
	}

	/**
	 * Used to login the user and creates new session
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doLogin() throws Exception {

		logger.info("userName: " + userName + ": password: " + password);
		boolean flag = userBo.validateUser(userName, password);

		if (flag == true) {
			session.put("icm_loggedIn", "true");
			session.put("userName", userName);
			return SUCCESS;
		} else {

			addActionError("Invalid User Name or Password");
			return INPUT;
		}
	}

	public String doLogout() throws Exception {
		logger.info("calling do logout");
		session.clear();
		return SUCCESS;
	}

	public void validate() {
		input();
		clearErrorsAndMessages();
		if (getUserName() == null || getUserName().trim().length() == 0)
			addFieldError("userName", "Please enter user name");
		else if (getPassword() == null || getPassword().trim().length() == 0)
			addFieldError("password", "Please enter Password");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
