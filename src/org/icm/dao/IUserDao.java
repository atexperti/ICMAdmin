package org.icm.dao;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.UserMaster;

public interface IUserDao {

	int addUser(UserMaster cust);

	int updateUser(UserMaster usersMaster);

	UserMaster getUser(int id);
	
	Collection<UserMaster> checkUser(String uname, String email);

	Collection<UserMaster> getUser(String uname, String pwd);

	boolean validateUser(String uname, String pwd);

	int deleteUser(int id);

	Collection<Object> getModifiedDateList();

	Collection<org.icm.model.UserMaster> getUsers();

	Collection<Object> getChurchNamesList();

	Collection<org.icm.model.UserMaster> getUsers(HashMap<String, String> map);

	UserMaster getUser(String author);

}
