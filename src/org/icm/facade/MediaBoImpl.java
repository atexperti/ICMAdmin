/**
 * 
 */
package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.icm.dao.ICategoryDAO;
import org.icm.dao.ILanguageDAO;
import org.icm.dao.IMediaDao;
import org.icm.model.CategoryMaster;
import org.icm.model.LanguageMaster;
import org.icm.model.MediaMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public class MediaBoImpl implements IMediaBo {
	private Logger logger = Logger.getLogger(this.getClass());
	private IMediaDao mediaDao;
	private ILanguageDAO languageDAO;
	private ICategoryDAO categoryDao;

	public ILanguageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(ILanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}

	public IMediaDao getMediaDao() {
		return mediaDao;
	}

	public void setMediaDao(IMediaDao mediaDao) {
		this.mediaDao = mediaDao;
	}

	@Override
	public Collection<MediaMaster> getMedia(HashMap<String, String> map,
			int iPageNo, int iPageSize) {
		// TODO Auto-generated method stub
		if (iPageNo - 1 == 0) {
			return mediaDao.getMedia(map, 0, iPageSize);
		} else {
			return mediaDao.getMedia(map, iPageNo, iPageSize);
		}
	}

	@Override
	public Collection<MediaMaster> getMedia(int iPageNo, int iPageSize) {
		// TODO Auto-generated method stub

		if (iPageNo - 1 == 0) {
			return mediaDao.getMedia(0, iPageSize);
		} else {
			return mediaDao.getMedia(iPageNo, iPageSize);
		}
	}

	@Override
	public MediaMaster getMedia(int id) {
		// TODO Auto-generated method stub
		return mediaDao.getMedia(id);
	}

	@Override
	public int deleteMedia(int id) {
		int flag = 0;
		try {

			flag = mediaDao.deleteMedia(id);

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
	public void deleteMedia(String lyricsCheckBox) {
		// TODO Auto-generated method stub

		try {

			mediaDao.deleteMedia(lyricsCheckBox);

		} catch (Throwable tr) {
			tr.printStackTrace();
			throw tr;
		}

	}

	@Override
	public int addMedia(MediaMaster mediaMaster) {
		// TODO Auto-generated method stub
		int flag = mediaDao.addMedia(mediaMaster);
		return flag;
	}

	@Override
	public int updateMedia(MediaMaster lyricsMaster) {
		// TODO Auto-generated method stub
		int flag = mediaDao.updateMedia(lyricsMaster);
		return flag;
	}

	public ICategoryDAO getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(ICategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public Collection<Object> getCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getCategories();
	}

	@Override
	public CategoryMaster getCategoryMaster(int id) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryMaster(id);
	}

	@Override
	public Collection<Object> getGenresList() {
		// TODO Auto-generated method stub
		return mediaDao.getGenresList();
	}

	@Override
	public Collection<Object> getModifiedDateList() {
		// TODO Auto-generated method stub
		return mediaDao.getModifiedDateList();
	}

}