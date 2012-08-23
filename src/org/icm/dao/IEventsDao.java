/**
 * 
 */
package org.icm.dao;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.EventMaster;
import org.icm.model.LanguageMaster;

/**
 * @author nageswararao.vejja
 *
 */
public interface IEventsDao {
	
	Collection<EventMaster> getEvents(HashMap<String, String> map);

	Collection<EventMaster> getEvents();

	int deleteEvents(int id);

	EventMaster getEvents(int id);

	void deleteEvents(String eventCheckBox);

	int addEvents(EventMaster eventMaster);

	int updateEvents(EventMaster eventMaster);

	Collection<EventMaster> getEvents(String keyword);
	
	Collection<Object> getAuthorList();

	Collection<Object> getDateList();

	Collection<Object> getRegionsList();
}
