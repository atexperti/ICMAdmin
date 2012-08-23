package org.icm.dao;

import java.util.Collection;

import org.icm.model.CategoryMaster;

public interface ICategoryDAO {
	int addCategory(CategoryMaster category);
	
	int updateCategory(CategoryMaster category);

	Collection<Object> getCategories();

	CategoryMaster getCategoryMaster(int id);
}
