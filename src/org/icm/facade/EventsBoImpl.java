/**
 * 
 */
package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.icm.dao.IEventsDao;
import org.icm.dao.ILanguageDAO;
import org.icm.dao.IUserDao;
import org.icm.model.EventMaster;
import org.icm.model.LanguageMaster;
import org.icm.model.UserMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public class EventsBoImpl implements IEventsBo {

	private Logger logger = Logger.getLogger(this.getClass());
	
	private IEventsDao eventsDao;
	private ILanguageDAO languageDAO;
	private IUserDao userDao;

	public ILanguageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(ILanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}

	public IEventsDao getEventsDao() {
		return eventsDao;
	}

	public void setEventsDao(IEventsDao eventsDao) {
		this.eventsDao = eventsDao;
	}

	@Override
	public Collection<EventMaster> getEvents(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return eventsDao.getEvents(map);
	}

	@Override
	public Collection<EventMaster> getEvents() {
		// TODO Auto-generated method stub
		return eventsDao.getEvents();
	}

	@Override
	public EventMaster getEvents(int id) {
		// TODO Auto-generated method stub
		return eventsDao.getEvents(id);
	}

	@Override
	public int deleteEvents(int id) {
		int flag = 0;
		try {

			flag = eventsDao.deleteEvents(id);

		} catch (Throwable tr) {
			tr.printStackTrace();
			throw tr;
		}
		return flag;
	}

	@Override
	public Collection<Object> getLanguages() {
		return languageDAO.getLanguages();
	}

	@Override
	public LanguageMaster getLanguageMaster(int id) {
		return languageDAO.getLanguageMaster(id);
	}

	@Override
	public void deleteEvents(String eventsCheckBox) {
		// TODO Auto-generated method stub

		try {

			eventsDao.deleteEvents(eventsCheckBox);

		} catch (Throwable tr) {
			tr.printStackTrace();
			throw tr;
		}

	}

	@Override
	public int addEvents(EventMaster eventsMaster) {
		// TODO Auto-generated method stub
		int flag = eventsDao.addEvents(eventsMaster);
		return flag;
	}

	@Override
	public int updateEvents(EventMaster eventsMaster) {
		// TODO Auto-generated method stub
		int flag = eventsDao.updateEvents(eventsMaster);
		return flag;
	}

	@Override
	public UserMaster getUserMaster(String author) {
		// TODO Auto-generated method stub
		return userDao.getUser(author);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Collection<Object> getAuthorList() {
		// TODO Auto-generated method stub
		return eventsDao.getAuthorList();
	}

	@Override
	public Collection<Object> getDateList() {
		// TODO Auto-generated method stub
		return eventsDao.getDateList();
	}

	@Override
	public Collection<Object> getRegionsList() {
		// TODO Auto-generated method stub
		return eventsDao.getRegionsList();
	}
}

