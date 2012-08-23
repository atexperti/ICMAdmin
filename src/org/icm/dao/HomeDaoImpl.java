/**
 * 
 */
package org.icm.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.icm.model.ArticleMaster;
import org.icm.model.EventMaster;
import org.icm.model.UserMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 * 
 */
public class HomeDaoImpl extends BaseDAOImpl implements IHomeDao {

	@Override
	@Transactional
	public Map<String, String> getTodoApprovedList() {
		// TODO Auto-generated method stub
		Map<String, String> approvedList = new HashMap<String, String>();
		try {

			
			try {
				CriteriaBuilder criteriaBuilder = getEntityManager()
						.getCriteriaBuilder();

				CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
				Root<UserMaster> from = criteriaQuery.from(UserMaster.class);
				Predicate userNameCondition = null;

				userNameCondition = from.get("status").in(0);

				criteriaQuery.select(from);
				criteriaQuery.where(userNameCondition);

				javax.persistence.Query q = getEntityManager().createQuery(
						criteriaQuery);
				Collection<UserMaster> cmsusers = (Collection<UserMaster>) q
						.getResultList();

				if (cmsusers != null && cmsusers.size() > 0) {
					approvedList.put("Users", cmsusers.size() + "");
				} else {
					approvedList.put("Users", "0");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				CriteriaBuilder criteriaBuilder = getEntityManager()
						.getCriteriaBuilder();

				CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
				Root<ArticleMaster> afrom = criteriaQuery
						.from(ArticleMaster.class);
				Predicate aStatus = null;

				aStatus = afrom.get("status").in(0);

				criteriaQuery.select(afrom);
				criteriaQuery.where(aStatus);

				javax.persistence.Query aq = getEntityManager().createQuery(
						criteriaQuery);
				Collection<ArticleMaster> articles = (Collection<ArticleMaster>) aq
						.getResultList();

				if (articles != null && articles.size() > 0) {
					approvedList.put("Articles", articles.size() + "");
				} else {
					approvedList.put("Articles", "0");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				CriteriaBuilder criteriaBuilder = getEntityManager()
						.getCriteriaBuilder();

				CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
				Root<EventMaster> eventFrom = criteriaQuery
						.from(EventMaster.class);
				Predicate eventStatus = null;

				eventStatus = eventFrom.get("eventStatus").in(0);

				criteriaQuery.select(eventFrom);
				criteriaQuery.where(eventStatus);

				javax.persistence.Query eq = getEntityManager().createQuery(
						criteriaQuery);
				Collection<EventMaster> events = (Collection<EventMaster>) eq
						.getResultList();

				if (events != null && events.size() > 0) {
					approvedList.put("Events", events.size() + "");
				} else {
					approvedList.put("Events", "0");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return approvedList;

	}

	@Override
	@Transactional
	public Map<String, String> getTodoProcessedList() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IHomeDao#getTodoList()
	 */

}
