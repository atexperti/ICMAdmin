package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.ArticleMaster;
import org.icm.model.LanguageMaster;
import org.icm.model.UserMaster;

public interface IArticlesBo {
	
	Collection<ArticleMaster> getArticles(HashMap<String, String> map);

	Collection<ArticleMaster> getArticles();

	int deleteArticles(int id);

	ArticleMaster getArticles(int id);

	Collection<Object> getLanguages();

	void deleteArticles(String lyricsCheckBox);

	LanguageMaster getLanguageMaster(int id);
	
	int addArticles(ArticleMaster lyricsMaster);

	int updateArticles(ArticleMaster lyricsMaster);

	UserMaster getUserMaster(String author);
	
	Collection<Object> getAuthorList();

	Collection<Object> getCreatedDateList();

	Collection<Object> getModifiedDateList();
	
}
