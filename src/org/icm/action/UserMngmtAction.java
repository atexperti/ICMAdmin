package org.icm.action;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.icm.facade.IUserBo;
import org.icm.model.UserMaster;

import com.opensymphony.xwork2.ActionContext;

public class UserMngmtAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(UserMngmtAction.class);
	private IUserBo usersBo;

	private Collection<UserMaster> users;
	private UserMaster UserMaster;
	private String userId;
	private String type;

	private Collection<Object> languageMaster;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Collection<Object> dateModifiedList;
	private Collection<Object> churchNamesList;
	private Collection<Object> statusList;

	private String userName;
	private String churchName;
	private String status;
	private String author;
	private String lastModifiedDate;

	public void init() {
		try {
			super.init();
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public String execute() {
		try {
			dateModifiedList = usersBo.getModifiedDateList();
			churchNamesList = usersBo.getChurchNamesList();
			statusList = usersBo.getStatusList();
			users = usersBo.getUsers();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String searchUsers() {
		try {

			dateModifiedList = usersBo.getModifiedDateList();
			churchNamesList = usersBo.getChurchNamesList();
			statusList = usersBo.getStatusList();
			HashMap<String, String> map = new HashMap<String, String>();
			if (status != null && !status.equalsIgnoreCase("-1")) {
				map.put("status", status);
			}

			if (churchName != null && !churchName.equalsIgnoreCase("-1")) {
				map.put("chruchName", churchName);
			}

			if (lastModifiedDate != null
					&& !lastModifiedDate.equalsIgnoreCase("-1")) {
				map.put("lastModifiedDate", lastModifiedDate);
			}

			users = usersBo.getUsers(map);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String modifyUsers() {
		System.out.println("userId :" + userId);
		System.out.println("type: " + type);
		if ("del".equalsIgnoreCase(type)) {
			usersBo.deleteUser(Integer.parseInt(userId));
			dateModifiedList = usersBo.getModifiedDateList();
			churchNamesList = usersBo.getChurchNamesList();
			statusList = usersBo.getStatusList();
			users = usersBo.getUsers();
			return SUCCESS;

		} else if ("approve".equalsIgnoreCase(type)) {

			UserMaster usersMaster = usersBo.getUser(Integer.parseInt(userId));

			usersMaster.setStatus(1);
			usersMaster
					.setLastModifiedDate(new Date(System.currentTimeMillis()));

			int val = usersBo.updateUser(usersMaster);
			if (val == 0) {
				addActionError("Unable to process request, Please try again");
				dateModifiedList = usersBo.getModifiedDateList();
				churchNamesList = usersBo.getChurchNamesList();
				statusList = usersBo.getStatusList();
				users = usersBo.getUsers();
				return INPUT;
			}
			dateModifiedList = usersBo.getModifiedDateList();
			churchNamesList = usersBo.getChurchNamesList();
			statusList = usersBo.getStatusList();
			users = usersBo.getUsers();
			return SUCCESS;

		}
		return ERROR;
	}

	public IUserBo getUsersBo() {
		return usersBo;
	}

	public void setUsersBo(IUserBo usersBo) {
		this.usersBo = usersBo;
	}

	public Collection<UserMaster> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserMaster> users) {
		this.users = users;
	}

	public UserMaster getUserMaster() {
		return UserMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		UserMaster = userMaster;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<Object> getLanguageMaster() {
		return languageMaster;
	}

	public void setLanguageMaster(Collection<Object> languageMaster) {
		this.languageMaster = languageMaster;
	}

	public Collection<Object> getDateModifiedList() {
		return dateModifiedList;
	}

	public void setDateModifiedList(Collection<Object> dateModifiedList) {
		this.dateModifiedList = dateModifiedList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getChurchName() {
		return churchName;
	}

	public void setChurchName(String churchName) {
		this.churchName = churchName;
	}

	public Collection<Object> getChurchNamesList() {
		return churchNamesList;
	}

	public void setChurchNamesList(Collection<Object> churchNamesList) {
		this.churchNamesList = churchNamesList;
	}

	public Collection<Object> getStatusList() {
		return statusList;
	}

	public void setStatusList(Collection<Object> statusList) {
		this.statusList = statusList;
	}

}