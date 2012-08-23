/**
 * 
 */
package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.EventMaster;
import org.icm.model.LanguageMaster;
import org.icm.model.UserMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public interface IEventsBo {

	Collection<EventMaster> getEvents(HashMap<String, String> map);

	Collection<EventMaster> getEvents();

	int deleteEvents(int id);

	EventMaster getEvents(int id);

	Collection<Object> getLanguages();

	void deleteEvents(String eventCheckBox);

	LanguageMaster getLanguageMaster(int id);

	int addEvents(EventMaster eventMaster);

	int updateEvents(EventMaster eventMaster);

	UserMaster getUserMaster(String author);

	Collection<Object> getAuthorList();

	Collection<Object> getDateList();

	Collection<Object> getRegionsList();

}
