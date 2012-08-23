package org.icm.facade;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.icm.dao.IHomeDao;

public class HomeBoImpl implements IHomeBo{

	private static Logger logger = Logger.getLogger(HomeBoImpl.class);
	
	private IHomeDao homeDao;
	

	public IHomeDao getHomeDao() {
		return homeDao;
	}


	public void setHomeDao(IHomeDao homeDao) {
		this.homeDao = homeDao;
	}


	@Override
	public Map<String, Map<String, String>> getTodoList() {
		// TODO Auto-generated method stub
		 Map<String, String> approvedMap= homeDao.getTodoApprovedList();
		 Map<String, String> processedMap= homeDao.getTodoProcessedList();
		 Map<String, Map<String, String>> todoList = new HashMap<String, Map<String,String>>();
		 todoList.put("No.Of Items to be Approved", approvedMap);
		 todoList.put("No.Of Orders to be Processed", processedMap);
		 
		 return todoList;
		 
	}
	
	
}