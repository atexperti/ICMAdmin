package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.icm.dao.ILanguageDAO;
import org.icm.dao.ILyricsDao;
import org.icm.model.LanguageMaster;
import org.icm.model.LyricsMaster;

public class LyricsBoImpl implements ILyricsBo {

	private ILyricsDao lyricsDao;
	private ILanguageDAO languageDAO;

	public ILanguageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(ILanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}

	public ILyricsDao getLyricsDao() {
		return lyricsDao;
	}

	public void setLyricsDao(ILyricsDao lyricsDao) {
		this.lyricsDao = lyricsDao;
	}

	@Override
	public Collection<LyricsMaster> getLyrics(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return lyricsDao.getLyrics(map);
	}

	@Override
	public Collection<LyricsMaster> getLyrics() {
		// TODO Auto-generated method stub
		return lyricsDao.getLyrics();
	}

	@Override
	public LyricsMaster getLyrics(int id) {
		// TODO Auto-generated method stub
		return lyricsDao.getLyrics(id);
	}

	@Override
	public int deleteLyrics(int id) {
		int flag = 0;
		try {

			flag = lyricsDao.deleteLyrics(id);

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
	public void deleteLyrics(String lyricsCheckBox) {
		// TODO Auto-generated method stub

		try {

			lyricsDao.deleteLyrics(lyricsCheckBox);

		} catch (Throwable tr) {
			tr.printStackTrace();
			throw tr;
		}

	}

	@Override
	public int addLyrics(LyricsMaster lyricsMaster) {
		// TODO Auto-generated method stub
		int flag = lyricsDao.addLyrics( lyricsMaster);
		return flag;
	}
	
	@Override
	public int updateLyrics(LyricsMaster lyricsMaster) {
		// TODO Auto-generated method stub
		int flag = lyricsDao.updateLyrics(lyricsMaster);
		return flag;
	}

	@Override
	public Collection<Object> getAlbumsList() {
		// TODO Auto-generated method stub
		return lyricsDao.getAlbumsList();
	}

	@Override
	public Collection<Object> getArtistList() {
		// TODO Auto-generated method stub
		return lyricsDao.getArtistList();
	}

	@Override
	public Collection<Object> getDatesList() {
		// TODO Auto-generated method stub
		return lyricsDao.getDatesList();
	}

}
