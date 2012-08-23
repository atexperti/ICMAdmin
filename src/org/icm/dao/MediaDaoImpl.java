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
import org.icm.model.MediaMaster;
import org.icm.model.UserMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 * 
 */
public class MediaDaoImpl extends BaseDAOImpl implements IMediaDao {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	@Transactional
	public int addMedia(MediaMaster articles) {

		try {
			articles.setLastModifiedDate(new Date(System.currentTimeMillis()));
			getEntityManager().persist(articles);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IMediaDao#updateMedia(int)
	 */
	@Override
	@Transactional
	public int updateMedia(MediaMaster Media) {
		try {
			getEntityManager().merge(Media);
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
	 * @see org.icm.dao.IMediaDao#getMedia(int)
	 */
	@Override
	@Transactional
	public MediaMaster getMedia(int id) {
		// TODO Auto-generated method stub
		MediaMaster Media = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			criteriaQuery.select(from);
			Predicate pred = from.get("id").in(id);
			criteriaQuery.where(pred);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Media = (MediaMaster) q1.getResultList().get(0);

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return Media;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IMediaDao#getMedia(java.util.HashMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<MediaMaster> getMedia(HashMap<String, String> map,
			int iPageNo, int iPageSize) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<MediaMaster> media = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			criteriaQuery.select(from);
			List<Predicate> predicates = new ArrayList<Predicate>();
			Set<String> keys = map.keySet();
			for (String key : keys) {
				if ("categoryName".equalsIgnoreCase(key)) {
					Predicate predicate = from.get("categoryMaster")
							.get("categoryId").in(map.get(key));
					predicates.add(predicate);
				} else if ("languageId".equalsIgnoreCase(key)) {
					Predicate predicate = from.get("languageMaster").get(key)
							.in(map.get(key));
					predicates.add(predicate);
				} else if ("lastModifiedDate".equalsIgnoreCase(key)) {

					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date uDate = df.parse(map.get(key));
					Date sDate = new java.sql.Date(uDate.getTime());

					java.util.Date d2 = new java.util.Date();

					d2.setTime(uDate.getTime() + 1 * 24 * 60 * 60 * 1000);

					Date s2Date = new java.sql.Date(d2.getTime());

					Predicate predicate = criteriaBuilder.between(
							from.<Date> get("lastModifiedDate"), sDate, s2Date);

					predicates.add(predicate);
				} else if ("genre".equalsIgnoreCase(key)) {
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
			q1.setFirstResult(iPageNo);
			q1.setMaxResults(iPageSize + 1);
			media = (ArrayList<MediaMaster>) q1.getResultList();
			System.out.println("media : " + media.size());
		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return media;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<MediaMaster> getMedia(String keyword) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<MediaMaster> Media = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);

			Predicate name, caption, genre, keywords, artist, type;

			name = criteriaBuilder.like(from.<String> get("title"), "%"
					+ keyword + "%");
			caption = criteriaBuilder.like(from.<String> get("articles"), "%"
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
			Media = (ArrayList<MediaMaster>) q1.getResultList();

		} catch (Exception e) {
			System.out.println("error in seacrh database id and keyword: " + e);
			e.printStackTrace();

		}
		return Media;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IMediaDao#deleteMedia(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int deleteMedia(int id) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("id").in(id));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<MediaMaster> articles = (ArrayList<MediaMaster>) q
					.getResultList();
			System.out.println("Size of Media in DAO: " + articles.size());
			if (articles != null && articles.size() > 0) {
				for (MediaMaster lyric : articles) {
					if (lyric != null)
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
	public Collection<MediaMaster> getMedia(int iPageNo, int iPageSize) {
		// TODO Auto-generated method stub
		ArrayList<MediaMaster> media = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from
					.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			q.setFirstResult(iPageNo);
			q.setMaxResults(iPageSize + 1);
			media = (ArrayList<MediaMaster>) q.getResultList();
			System.out.println("media : " + media.size());
		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return media;
	}

	@Override
	@Transactional
	public int deleteMedia(String articlesCheckBox) {
		// TODO Auto-generated method stub
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("id").in(articlesCheckBox));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<MediaMaster> articles = (ArrayList<MediaMaster>) q
					.getResultList();
			System.out.println("Size of Media in DAO" + articles.size());
			if (articles != null && articles.size() > 0) {
				for (MediaMaster lyric : articles) {
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

	@Override
	@Transactional
	public Collection<Object> getGenresList() {
		// TODO Auto-generated method stub
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			criteriaQuery.select(from.get("genre")).distinct(true);
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
	public Collection<Object> getModifiedDateList() {
		// TODO Auto-generated method stub
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			criteriaQuery.select(from.get("lastModifiedDate")).distinct(true);

			Query q1 = getEntityManager().createQuery(criteriaQuery);
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
}
