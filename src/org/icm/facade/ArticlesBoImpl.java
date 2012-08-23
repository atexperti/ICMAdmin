package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.icm.dao.IArticlesDao;
import org.icm.dao.ILanguageDAO;
import org.icm.dao.IUserDao;
import org.icm.model.ArticleMaster;
import org.icm.model.LanguageMaster;
import org.icm.model.UserMaster;

public class ArticlesBoImpl implements IArticlesBo {

	private IArticlesDao lyricsDao;
	private ILanguageDAO languageDAO;
	private IUserDao userDao;

	public ILanguageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(ILanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}

	public IArticlesDao getArticlesDao() {
		return lyricsDao;
	}

	public void setArticlesDao(IArticlesDao lyricsDao) {
		this.lyricsDao = lyricsDao;
	}

	@Override
	public Collection<ArticleMaster> getArticles(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return lyricsDao.getArticles(map);
	}

	@Override
	public Collection<ArticleMaster> getArticles() {
		// TODO Auto-generated method stub
		return lyricsDao.getArticles();
	}

	@Override
	public ArticleMaster getArticles(int id) {
		// TODO Auto-generated method stub
		return lyricsDao.getArticles(id);
	}

	@Override
	public int deleteArticles(int id) {
		int flag = 0;
		try {

			flag = lyricsDao.deleteArticles(id);

		} catch (Throwable tr) {
			tr.printStackTrace();
			throw tr;
		}
		return flag;
	}

	@Override
	public Collection<Object> getLanguages() {
		return languageDAO.getLanguages();
	}

	@Override
	public LanguageMaster getLanguageMaster(int id) {
		return languageDAO.getLanguageMaster(id);
	}

	@Override
	public void deleteArticles(String lyricsCheckBox) {
		// TODO Auto-generated method stub

		try {

			lyricsDao.deleteArticles(lyricsCheckBox);

		} catch (Throwable tr) {
			tr.printStackTrace();
			throw tr;
		}

	}

	@Override
	public int addArticles(ArticleMaster lyricsMaster) {
		// TODO Auto-generated method stub
		int flag = lyricsDao.addArticles(lyricsMaster);
		return flag;
	}

	@Override
	public int updateArticles(ArticleMaster lyricsMaster) {
		// TODO Auto-generated method stub
		int flag = lyricsDao.updateArticles(lyricsMaster);
		return flag;
	}

	@Override
	public UserMaster getUserMaster(String author) {
		// TODO Auto-generated method stub
		return userDao.getUser(author);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Collection<Object> getAuthorList() {
		// TODO Auto-generated method stub
		return lyricsDao.getAuthorList();
	}

	@Override
	public Collection<Object> getCreatedDateList() {
		// TODO Auto-generated method stub
		return lyricsDao.getCreatedDateList();
	}

	@Override
	public Collection<Object> getModifiedDateList() {
		// TODO Auto-generated method stub
		return lyricsDao.getModifiedDateList();
	}

}
