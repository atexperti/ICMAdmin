package org.icm.dao;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.icm.model.AdminMaster;
import org.icm.model.UserMaster;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl extends BaseDAOImpl implements IUserDao {
	@Override
	@Transactional
	public int addUser(UserMaster cust) {
		Serializable id = getSession().save(cust);
		return Integer.parseInt(id.toString());
	}

	@Override
	@Transactional
	public int deleteUser(int id) {

		return 0;
	}

	@Override
	@Transactional
	public UserMaster getUser(int id) {
		return (UserMaster) getSession().get(UserMaster.class, id);
	}

	@Override
	@Transactional
	public int updateUser(UserMaster um) {

		try {
			getEntityManager().merge(um);
		} catch (Exception e) {
			System.out.println("Exception occured while adding device to device master"
					+ e);
			return 0;
		}
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<UserMaster> getUser(String uname, String pwd) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();

			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<UserMaster> from = criteriaQuery.from(UserMaster.class);
			Predicate userNameCondition = null;
			Predicate passwordCondition = null;
			userNameCondition = from.get("userName").in(uname);
			passwordCondition = from.get("password").in(pwd);
			criteriaQuery.select(from);
			criteriaQuery.where(passwordCondition, userNameCondition);

			javax.persistence.Query q = getEntityManager().createQuery(
					criteriaQuery);
			Collection<UserMaster> cmsusers = (Collection<UserMaster>) q
					.getResultList();
			return cmsusers;
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public UserMaster getUser(String uname) {
		/*
		 * Query query = getSession().createQuery(
		 * "from UserMaster where userName=:userName and password=:password");
		 * System.out.println(uname+":" +pwd); query.setParameter("userName",
		 * uname); query.setParameter("password", pwd); return query.list();
		 */

		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();

			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<UserMaster> from = criteriaQuery.from(UserMaster.class);
			Predicate userNameCondition = null;
			userNameCondition = from.get("userName").in(uname);
			criteriaQuery.select(from);
			criteriaQuery.where(userNameCondition);

			javax.persistence.Query q = getEntityManager().createQuery(
					criteriaQuery);
			UserMaster cmsusers = (UserMaster) q.getResultList().get(0);
			return cmsusers;
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<UserMaster> checkUser(String uname, String email) {
		try {
			if (uname != null) {
				Query query = getSession()
						.createQuery(
								"from UserMaster where userName= :userName or email= :email");
				query.setParameter("userName", uname);
				query.setParameter("email", email);
				return query.list();
			} else {
				Query query = getSession().createQuery(
						"from UserMaster where email= :email");
				query.setParameter("email", email);
				return query.list();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	@Transactional
	public boolean validateUser(String uname, String pwd) {
		// TODO Auto-generated method stub

		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();

			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<AdminMaster> from = criteriaQuery.from(AdminMaster.class);
			Predicate userNameCondition = null;
			Predicate passwordCondition = null;
			userNameCondition = from.get("adminUserName").in(uname);
			passwordCondition = from.get("adminPassword").in(pwd);
			criteriaQuery.select(from);
			criteriaQuery.where(passwordCondition, userNameCondition);

			javax.persistence.Query q = getEntityManager().createQuery(
					criteriaQuery);
			Collection<UserMaster> cmsusers = (Collection<UserMaster>) q
					.getResultList();
			if (cmsusers != null && cmsusers.size() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	@Transactional
	public Collection<Object> getModifiedDateList() {
		// TODO Auto-generated method stub
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<UserMaster> from = criteriaQuery.from(UserMaster.class);
			criteriaQuery.select(from.get("lastModifiedDate")).distinct(true);

			javax.persistence.Query q1 = getEntityManager().createQuery(
					criteriaQuery);
			Collection<Object> albumList = (Collection<Object>) q1
					.getResultList();

			Collection<Object> albumsList = new ArrayList<Object>();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Collection<Object> datesSet = new TreeSet<Object>();
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
	public Collection<UserMaster> getUsers() {
		// TODO Auto-generated method stub
		ArrayList<UserMaster> users = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<UserMaster> from = criteriaQuery.from(UserMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from
					.get("lastModifiedDate")));
			javax.persistence.Query q = getEntityManager().createQuery(
					criteriaQuery);
			users = (ArrayList<UserMaster>) q.getResultList();

		} catch (Exception e) {
			System.out
					.println("Exception occured while getting promotionalContent "
							+ e);
			e.printStackTrace();
		}
		return users;
	}

	@Override
	@Transactional
	public Collection<Object> getChurchNamesList() {
		// TODO Auto-generated method stub
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<UserMaster> from = criteriaQuery.from(UserMaster.class);
			criteriaQuery.select(from.get("chruchName")).distinct(true);
			javax.persistence.Query q1 = getEntityManager().createQuery(
					criteriaQuery);
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
	public Collection<UserMaster> getUsers(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		ArrayList<UserMaster> users = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<UserMaster> from = criteriaQuery.from(UserMaster.class);
			criteriaQuery.select(from);
			List<Predicate> predicates = new ArrayList<Predicate>();
			Set<String> keys = map.keySet();
			for (String key : keys) {

				if ("lastModifiedDate".equalsIgnoreCase(key)) {

					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date uDate = df.parse(map.get(key));
					Date sDate = new java.sql.Date(uDate.getTime());

					java.util.Date d2 = new java.util.Date();

					d2.setTime(uDate.getTime() + 1 * 24 * 60 * 60 * 1000);

					Date s2Date = new java.sql.Date(d2.getTime());

					Predicate predicate = criteriaBuilder.between(
							from.<Date> get("lastModifiedDate"), sDate, s2Date);

					predicates.add(predicate);
				} else if ("status".equalsIgnoreCase(key)) {
					int status = 0;
					if ("approved".equalsIgnoreCase(map.get(key))) {
						status = 1;
					} else if ("-1".equalsIgnoreCase(map.get(key))) {
						status = -1;

					} else {
						status = 0;
					}
					Predicate predicate = from.get(key).in(status);
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
			javax.persistence.Query q1 = getEntityManager().createQuery(
					criteriaQuery);
			users = (ArrayList<UserMaster>) q1.getResultList();

		} catch (Exception e) {
			System.out
					.println("Exception occured while getting promotionalContent "
							+ e);
			e.printStackTrace();
		}
		return users;
	}

}
