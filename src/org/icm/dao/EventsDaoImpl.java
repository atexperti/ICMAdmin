/**
 * 
 */
package org.icm.dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.icm.model.ArticleMaster;
import org.icm.model.EventMaster;
import org.icm.model.UserMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 * 
 */
public class EventsDaoImpl extends BaseDAOImpl implements IEventsDao {

	private Logger logger = Logger.getLogger(this.getClass());
	@Override
	@Transactional
	public int addEvents(EventMaster events) {

		try {
			events.setLastModifiedDate(new Date(System.currentTimeMillis()));
			getEntityManager().persist(events);
		} catch (Exception e) {
			logger.error("Exception occured while adding device to device master"
					+ e);
			return 0;
		}
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#updateEvents(int)
	 */
	@Override
	@Transactional
	public int updateEvents(EventMaster Events) {
		try {
			getEntityManager().merge(Events);
		} catch (Exception e) {
			logger.error("Exception occured while adding device to device master"
					+ e);
			return 0;
		}
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#getEvents(int)
	 */
	@Override
	@Transactional
	public EventMaster getEvents(int id) {
		// TODO Auto-generated method stub
		EventMaster Events = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
			criteriaQuery.select(from);
			Predicate pred = from.get("eventId").in(id);
			criteriaQuery.where(pred);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Events = (EventMaster) q1.getResultList().get(0);

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return Events;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#getEvents(java.util.HashMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<EventMaster> getEvents(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<EventMaster> Events = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
			criteriaQuery.select(from);
			List<Predicate> predicates = new ArrayList<Predicate>();
			Set<String> keys = map.keySet();
			for (String key : keys) {
				if ("author".equalsIgnoreCase(key)) {
					Predicate predicate = from.get("userMaster").get("userName")
							.in(map.get(key));
					predicates.add(predicate);
				}else if ("languageId".equalsIgnoreCase(key)) {
					Predicate predicate = from.get("languageMaster").get(key)
							.in(map.get(key));
					predicates.add(predicate);
				}else if ("datetime".equalsIgnoreCase(key)) {

					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date uDate = df.parse(map.get(key));
					Date sDate = new java.sql.Date(uDate.getTime());
					
					java.util.Date d2 = new java.util.Date();

					d2.setTime(uDate.getTime() + 1 * 24 * 60 * 60 * 1000);
					
					Date s2Date = new java.sql.Date(d2.getTime());
					
					Predicate predicate = criteriaBuilder.between(from.<Date>get("datetime"), sDate, s2Date);

					predicates.add(predicate);
				} else {
					Predicate predicate = from.get(key).in(map.get(key));
					predicates.add(predicate);
				}
			}
			if (predicates.size() == 1)
				criteriaQuery.where(predicates.get(0));
			else
				criteriaQuery.where(criteriaBuilder.and(predicates
						.toArray(new Predicate[0])));
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Events = (ArrayList<EventMaster>) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return Events;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<EventMaster> getEvents(String keyword) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<EventMaster> Events = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);

			Predicate name, caption, genre, keywords, artist, type;

			name = criteriaBuilder.like(from.<String> get("title"), "%"
					+ keyword + "%");
			caption = criteriaBuilder.like(from.<String> get("events"), "%"
					+ keyword + "%");
			genre = criteriaBuilder.like((from.<String> get("albumName")), "%"
					+ keyword + "%");
			keywords = criteriaBuilder.like(from.<String> get("keywords"), "%"
					+ keyword + "%");
			artist = criteriaBuilder.like(from.<String> get("artists"), "%"
					+ keyword + "%");
			type = criteriaBuilder.like(from.get("languageMaster")
					.<String> get("languageName"), "%" + keyword + "%");
			criteriaQuery.select(from).where(
					criteriaBuilder.or(name, caption, genre, keywords, artist,
							type));
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Events = (ArrayList<EventMaster>) q1.getResultList();

		} catch (Exception e) {
			System.out.println("error in seacrh database id and keyword: " + e);
			e.printStackTrace();

		}
		return Events;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#deleteEvents(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int deleteEvents(int id) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("eventId").in(id));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<EventMaster> events = (ArrayList<EventMaster>) q
					.getResultList();
			System.out.println("Size of Events in DAO" + events.size());
			if (events != null && events.size() > 0) {
				for (EventMaster lyric : events) {
					getEntityManager().remove(lyric);
				}
			}
		} catch (Exception e) {
			logger.error("Exception occured while deleting device form device master "
					+ e);
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<EventMaster> getEvents() {
		// TODO Auto-generated method stub
		ArrayList<EventMaster> ppts = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from
					.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ppts = (ArrayList<EventMaster>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return ppts;
	}

	@Override
	@Transactional
	public void deleteEvents(String eventsCheckBox) {
		// TODO Auto-generated method stub
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("eventId").in(eventsCheckBox));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<EventMaster> events = (ArrayList<EventMaster>) q
					.getResultList();
			System.out.println("Size of Events in DAO" + events.size());
			if (events != null && events.size() > 0) {
				for (EventMaster lyric : events) {
					getEntityManager().remove(lyric);
				}
			}
		} catch (Exception e) {
			logger.error("Exception occured while deleting device form device master "
					+ e);
			e.printStackTrace();
			
		}
	}

	@Override
	@Transactional
	public Collection<Object> getAuthorList() {
		// TODO Auto-generated method stub
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<UserMaster> from = criteriaQuery.from(UserMaster.class);
			criteriaQuery.select(from.get("userName")).distinct(true);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Collection<Object> albumList = (Collection<Object>) q1
					.getResultList();
			return albumList;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	@Transactional
	public Collection<Object> getDateList() {
		// TODO Auto-generated method stub
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
			criteriaQuery.select(from.get("datetime")).distinct(true);
			
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Collection<Object> albumList = (Collection<Object>) q1
					.getResultList();
			
			Collection<Object> albumsList = new ArrayList<Object> ();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Collection<Object> datesSet=new TreeSet<Object>();
			for (Object object : albumList) {
				String newDate = df.format(object);
				datesSet.add(newDate);
			}
			
			return datesSet;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	@Transactional
	public Collection<Object> getRegionsList() {
		// TODO Auto-generated method stub
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
			criteriaQuery.select(from.get("region")).distinct(true);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Collection<Object> albumList = (Collection<Object>) q1
					.getResultList();
			return albumList;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}



	

}
