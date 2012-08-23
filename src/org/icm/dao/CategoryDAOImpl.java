package org.icm.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.icm.model.CategoryMaster;
import org.springframework.transaction.annotation.Transactional;

public class CategoryDAOImpl extends BaseDAOImpl implements ICategoryDAO{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	@Transactional
	public int addCategory(CategoryMaster category) {
		// TODO Auto-generated method stub
		try{
			getEntityManager().persist(category);
		}catch(Exception e){
			logger.error("error occured while inserting Category Master" + e);
			return 0;
		}
		return 1;
	}

	@Override
	@Transactional
	public int updateCategory(CategoryMaster category) {
		// TODO Auto-generated method stub
		try{
			getEntityManager().merge(category);
		}catch(Exception e){
			logger.error("error occured while updating Category Master" + e);
			return 0;
		}
		return 1;

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getCategories() {
		// TODO Auto-generated method stub
		ArrayList<Object> categorys = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<CategoryMaster> from = criteriaQuery.from(CategoryMaster.class);
			criteriaQuery.select(from);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			categorys = (ArrayList<Object>)q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return categorys;
	}

	@Override
	@Transactional
	public CategoryMaster getCategoryMaster(int id) {
		CategoryMaster category = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<CategoryMaster> from = criteriaQuery.from(CategoryMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("categoryId").in(id));
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			category = (CategoryMaster) q1.getResultList().get(0);

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return category;
	}

}
