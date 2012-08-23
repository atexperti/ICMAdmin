package org.icm.action;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.formula.functions.Datestring;
import org.icm.facade.IEventsBo;
import org.icm.model.EventMaster;

import com.opensymphony.xwork2.ActionContext;

public class EventsAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(EventsAction.class);
	private IEventsBo eventsBo;
	
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	// Form fields start
	private String eventName;
	private String eventAddress;

	private String contactPerson;
	private String contactNumber;
	private String category;
	private String datetime;
	private String eventDescription;

	private String eventStatus;
	private String spectatorLanguage;
	private String place;
	private String subLanguages;
	private String region;

	private String languageName;

	private Collection<Object> languageMaster;
	private Collection<EventMaster> events;
	private Collection<Object> authorList;
	private Collection<Object> regionsList;
	private Collection<Object> dateList;
	private EventMaster event;
	private String eventId;
	private String type;
	private String eventCheckBox;

	private String author;

	public void init() {
		try {
			super.init();
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public String execute() {
		try {
			languageMaster = eventsBo.getLanguages();
			authorList = eventsBo.getAuthorList();
			regionsList = eventsBo.getRegionsList();
			dateList = eventsBo.getDateList();
			events = eventsBo.getEvents();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String searchEvents() {
		try {
			languageMaster = eventsBo.getLanguages();
			authorList = eventsBo.getAuthorList();
			regionsList = eventsBo.getRegionsList();
			dateList = eventsBo.getDateList();
			HashMap<String, String> map = new HashMap<String, String>();
			if (author != null && !author.equalsIgnoreCase("-1")) {
				map.put("author", author);
			}

			if (languageName != null && !languageName.equalsIgnoreCase("-1")) {
				map.put("languageId", languageName);
			}
			if (datetime != null && !datetime.equalsIgnoreCase("-1")) {
				map.put("datetime", datetime);
			}

			if (region != null && !region.equalsIgnoreCase("-1")) {
				map.put("region", region);
			}

			events = eventsBo.getEvents(map);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String addEvents() {
		try {
			// events = eventsBo.getEvents();
			languageMaster = eventsBo.getLanguages();
			return INPUT;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String submitEvents() {
		try {
			
			
			EventMaster eventsMaster = new EventMaster();
			eventsMaster.setEventName(eventName);
			eventsMaster.setEventDescription(eventDescription);
			eventsMaster.setContactPerson(contactPerson);
			eventsMaster.setCategory(category);
			
			DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
			java.util.Date parsedUtilDate = formater.parse(datetime);  
			java.sql.Date sqltDate= new java.sql.Date(parsedUtilDate.getTime());  

			eventsMaster.setDatetime(parsedUtilDate);
			eventsMaster.setEventAddress(eventAddress);
			eventsMaster.setContactNumber(contactNumber);
			eventsMaster.setPlace(place);
			eventsMaster.setRegion(region);
			eventsMaster.setSpectatorLanguage(spectatorLanguage);
			eventsMaster.setSubLanguages(subLanguages);
			
			System.out.println("languageName: "+languageName);
			System.out.println("userNAme: "+(String) session
					.get("userName"));
			
			eventsMaster.setUserMaster(eventsBo.getUserMaster((String) session
					.get("userName")));
			eventsMaster.setEventStatus(1);
			
			eventsMaster.setLastModifiedDate(new Date(System
					.currentTimeMillis()));
			String flag = vaeventIdate(eventsMaster);
			languageMaster = eventsBo.getLanguages();
			System.out.println(flag);
			if ("vaeventId".equalsIgnoreCase(flag)) {
				int val = eventsBo.addEvents(eventsMaster);
				System.out.println("val: "+val);
				System.out.println(session.get("userName") + "");
				if (val == 0) {
					addActionError("Unable to process request, Please try again");
					
					return INPUT;
				}
				events = eventsBo.getEvents();
				return SUCCESS;
			} else {
				
				addActionError(flag);
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String editEvents() {
		try {

			EventMaster eventsMaster = eventsBo.getEvents(Integer
					.parseInt(eventId));

			eventsMaster.setEventDescription(eventDescription);
			eventsMaster.setContactPerson(contactPerson);
			eventsMaster.setContactNumber(contactNumber);
			eventsMaster.setCategory(category);
			DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
			java.util.Date parsedUtilDate = formater.parse(datetime);  
			java.sql.Date sqltDate= new java.sql.Date(parsedUtilDate.getTime());  

			eventsMaster.setDatetime(sqltDate);
			eventsMaster.setEventAddress(eventAddress);
			eventsMaster.setPlace(place);
			eventsMaster.setRegion(region);
			eventsMaster.setSpectatorLanguage(spectatorLanguage);
			eventsMaster.setSubLanguages(subLanguages);
			eventsMaster.setLastModifiedDate(new Date(System
					.currentTimeMillis()));

			String flag = vaeventIdate(eventsMaster);
			System.out.println("flag: "+flag);
			languageMaster = eventsBo.getLanguages();
			if ("vaeventId".equalsIgnoreCase(flag)) {
				int val = eventsBo.updateEvents(eventsMaster);
				if (val == 0) {
					addActionError("Unable to process request, Please try again");
					event = eventsBo.getEvents(Integer.parseInt(eventId));
					return INPUT;
				}
				events = eventsBo.getEvents();
				return SUCCESS;
			} else {
				event = eventsBo.getEvents(Integer.parseInt(eventId));
				addActionError(flag);
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	private String vaeventIdate(EventMaster eventsMaster) {
		StringBuffer sb = new StringBuffer();
		// TODO Auto-generated method stub

		if (eventsMaster.getCategory() == null
				|| eventsMaster.getCategory().length() < 1)
			sb.append("Please enter valid Category");
		if (eventsMaster.getContactNumber() == null
				|| eventsMaster.getContactNumber().length() < 1)
			sb.append("Please enter valid Contact Number");
		if (eventsMaster.getLanguageMaster() == null)
			sb.append("Please select Language");
		
		if (eventsMaster.getDatetime() == null)
			sb.append("Please enter valid datetime");
		if (eventsMaster.getEventAddress() == null
				|| eventsMaster.getEventAddress().length() < 1)
			sb.append("Please enter valid Address");
		if (eventsMaster.getEventDescription() == null)
			sb.append("Please Enter Description");
		
		if (eventsMaster.getEventName() == null
				|| eventsMaster.getEventName().length() < 1)
			sb.append("Please enter valid Event Name");
		if (eventsMaster.getPlace() == null
				|| eventsMaster.getPlace().length() < 1)
			sb.append("Please enter valid place");
		if (eventsMaster.getRegion() == null || eventsMaster.getRegion().length()<1)
			sb.append("Please select Region");
		
		if (eventsMaster.getSpectatorLanguage() == null)
			sb.append("Please enter valid Spectator language");
		
		if (eventsMaster.getUserMaster() == null)
			sb.append("Please Enter User Name");
		

		if (sb.length() > 1) {

			return sb.toString();
		}

		return "vaeventId";
	}

	public String modifyEvents() {
		System.out.println("eventId :" + eventId);
		System.out.println("type: " + type);
		if ("del".equalsIgnoreCase(type)) {
			eventsBo.deleteEvents(Integer.parseInt(eventId));
			languageMaster = eventsBo.getLanguages();
			events = eventsBo.getEvents();
			return SUCCESS;

		} else if ("delAll".equalsIgnoreCase(type)) {

			if (eventCheckBox != null) {
				System.out.println("eventsCheckbox: " + eventCheckBox);
				String eventsToBeDeleted[] = eventCheckBox.split(",");
				for (String string : eventsToBeDeleted) {
					eventsBo.deleteEvents(Integer.parseInt(string.trim()));
				}

			}

			events = eventsBo.getEvents();
			languageMaster = eventsBo.getLanguages();
			return SUCCESS;

		} else if ("approve".equalsIgnoreCase(type)) {

			EventMaster eventsMaster = eventsBo.getEvents(Integer
					.parseInt(eventId));

			eventsMaster.setEventStatus(1);
			eventsMaster.setLastModifiedDate(new Date(System
					.currentTimeMillis()));

			int val = eventsBo.updateEvents(eventsMaster);
			if (val == 0) {
				addActionError("Unable to process request, Please try again");
				return INPUT;
			}
			languageMaster = eventsBo.getLanguages();
			events = eventsBo.getEvents();
			return SUCCESS;

		} else if ("approveall".equalsIgnoreCase(type)) {
			if (eventCheckBox != null) {
				System.out.println("eventsCheckbox: " + eventCheckBox);
				String eventsToBeDeleted[] = eventCheckBox.split(",");
				for (String string : eventsToBeDeleted) {
					// eventsBo.deleteEvents(Integer.parseInt(string.trim()));
				}

			}
			languageMaster = eventsBo.getLanguages();
			events = eventsBo.getEvents();
			return SUCCESS;

		} else if ("edit".equalsIgnoreCase(type)) {
			try{
			languageMaster = eventsBo.getLanguages();
			event = eventsBo.getEvents(Integer.parseInt(eventId));
			System.out.println("edit eventId" + eventId);
			}catch (Exception e) {
				// TODO: handle exception
				return ERROR;
			}
			return INPUT;
		}

		return ERROR;
	}

	public IEventsBo getEventsBo() {
		return eventsBo;
	}

	public void setEventsBo(IEventsBo eventsBo) {
		this.eventsBo = eventsBo;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getSpectatorLanguage() {
		return spectatorLanguage;
	}

	public void setSpectatorLanguage(String spectatorLanguage) {
		this.spectatorLanguage = spectatorLanguage;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSubLanguages() {
		return subLanguages;
	}

	public void setSubLanguages(String subLanguages) {
		this.subLanguages = subLanguages;
	}

	public String getRegion() {
		return region;
	}

	public Collection<Object> getLanguageMaster() {
		return languageMaster;
	}

	public void setLanguageMaster(Collection<Object> languageMaster) {
		this.languageMaster = languageMaster;
	}

	public Collection<EventMaster> getEvents() {
		return events;
	}

	public void setEvents(Collection<EventMaster> events) {
		this.events = events;
	}

	public EventMaster getEvent() {
		return event;
	}

	public void setEvent(EventMaster event) {
		this.event = event;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEventCheckBox() {
		return eventCheckBox;
	}

	public void setEventCheckBox(String eventCheckBox) {
		this.eventCheckBox = eventCheckBox;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Collection<Object> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(Collection<Object> authorList) {
		this.authorList = authorList;
	}

	public Collection<Object> getRegionsList() {
		return regionsList;
	}

	public void setRegionsList(Collection<Object> regionsList) {
		this.regionsList = regionsList;
	}

	public Collection<Object> getDateList() {
		return dateList;
	}

	public void setDateList(Collection<Object> dateList) {
		this.dateList = dateList;
	}
}

class PlaceComparator implements Comparator<EventMaster> {
	String type;

	PlaceComparator(String type) {
		this.type = type;
	}

	@Override
	public int compare(EventMaster em1, EventMaster em2) {
		// TODO Auto-generated method stub
		if ("Asc".equalsIgnoreCase(type))
			return em2.getPlace().compareTo(em1.getPlace());
		else
			return em1.getPlace().compareTo(em2.getPlace());
	}

}

class regionComparator implements Comparator<EventMaster> {
	String type;

	regionComparator(String type) {
		this.type = type;
	}

	@Override
	public int compare(EventMaster em1, EventMaster em2) {
		// TODO Auto-generated method stub
		if (em2.getRegion() != null && em1.getRegion() != null) {
			if ("Asc".equalsIgnoreCase(type)) {
				return em2.getRegion().compareTo(em1.getRegion());
			} else {
				return em1.getRegion().compareTo(em2.getRegion());
			}
		}
		return 0;
	}

}

class languageComparator implements Comparator<EventMaster> {
	String type;

	languageComparator(String type) {
		this.type = type;
	}

	@Override
	public int compare(EventMaster em1, EventMaster em2) {
		// TODO Auto-generated method stub
		if (em2.getSpectatorLanguage() != null
				&& em1.getSpectatorLanguage() != null) {
			if ("Asc".equalsIgnoreCase(type)) {
				return em2.getSpectatorLanguage().compareTo(
						em1.getSpectatorLanguage());
			} else {
				return em1.getSpectatorLanguage().compareTo(
						em2.getSpectatorLanguage());
			}
		}
		return 0;
	}

}
