/**
 * 
 */
package org.icm.dao;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.ArticleMaster;
import org.icm.model.UserMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public interface IArticlesDao {

	int addArticles(ArticleMaster lyrics);

	int updateArticles(ArticleMaster lyrics);

	ArticleMaster getArticles(int id);

	Collection<ArticleMaster> getArticles(HashMap<String, String> map);

	Collection<ArticleMaster> getArticles();

	int deleteArticles(int id);

	Collection<ArticleMaster> getArticles(String Keyword);

	int deleteArticles(String lyricsCheckBox);
	
	
	Collection<Object> getAuthorList();

	Collection<Object> getCreatedDateList();

	Collection<Object> getModifiedDateList();

}
