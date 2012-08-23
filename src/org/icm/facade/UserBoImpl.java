package org.icm.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.icm.dao.IUserDao;
import org.icm.model.UserMaster;

public class UserBoImpl implements IUserBo{

	private static Logger logger = Logger.getLogger(UserBoImpl.class);
	
	
	private IUserDao userDao;
	private UserMaster UserMaster;

	@Override
	public int addUser(UserMaster UserMaster) {
		int id = 0;
		try{
			logger.info("UserMaster obj" + UserMaster);
			
				id = userDao.addUser(UserMaster);
			
		}
		catch(Throwable tr){
			logger.error(tr);
		}
		return id;
	}

	@Override
	public int deleteUser(int id) {
		
		return 0;
	}

	@Override
	public UserMaster getUser(int id) {
		return userDao.getUser(id);
	}
	@Override
	public UserMaster getUser(String uname, String pwd) {
		try{
			// Retrieving UserMaster info from the DB
			logger.info(uname +"  "+pwd);
			List<UserMaster> custList = (List<UserMaster>) userDao.getUser(uname, pwd);
			System.out.println("user size: "+custList.size());
			if(!custList.isEmpty()){
				UserMaster = custList.get(0);
				// Check if the UserMaster is existed and has valid msisdn
				if(UserMaster.getUserId() != 0){
					return UserMaster;
				}
			}
		}catch(Throwable tr){
			logger.error(tr);
			System.out.println(tr);
		}
		return null;
	}
	
	@Override
	public int updateUser(UserMaster um) {
		
		// TODO Auto-generated method stub
		return userDao.updateUser(um);
	}
	
	public boolean isValidUser(int msisdn){
		return true;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * Getting UserMaster data by passing UserMaster name 
	 */
	@Override
	public UserMaster checkUser(String uname, String email) {
		try{
			List<UserMaster> custList = (List<UserMaster>) userDao.checkUser(uname, email);
			System.out.println(custList.size());
			if(custList != null && !custList.isEmpty())		
			return custList.get(0);
		}catch(Throwable e){
			logger.error(e);
		}
		return null;
		
	}

	@Override
	public boolean validateUser(String uname, String pwd) {
		// TODO Auto-generated method stub
		return userDao.validateUser(uname, pwd);
	}


	@Override
	public Collection<Object> getModifiedDateList() {
		// TODO Auto-generated method stub
		return userDao.getModifiedDateList();
	}

	@Override
	public Collection<org.icm.model.UserMaster> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	@Override
	public Collection<Object> getChurchNamesList() {
		// TODO Auto-generated method stub
		return userDao.getChurchNamesList();
	}

	@Override
	public Collection<org.icm.model.UserMaster> getUsers(
			HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return userDao.getUsers(map);
	}

	@Override
	public Collection<Object> getStatusList() {
		// TODO Auto-generated method stub
		Collection<Object> statusList = new ArrayList<Object> ();
		statusList.add("approved");
		statusList.add("pending");
		return statusList;
	}
	

}
