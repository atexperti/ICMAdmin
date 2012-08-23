package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.LanguageMaster;
import org.icm.model.LyricsMaster;

public interface ILyricsBo {
	Collection<LyricsMaster> getLyrics(HashMap<String, String> map);

	Collection<LyricsMaster> getLyrics();

	int deleteLyrics(int id);

	LyricsMaster getLyrics(int id);

	Collection<Object> getLanguages();

	void deleteLyrics(String lyricsCheckBox);

	LanguageMaster getLanguageMaster(int id);
	
	int addLyrics(LyricsMaster lyricsMaster);

	int updateLyrics(LyricsMaster lyricsMaster);

	Collection<Object> getAlbumsList();

	Collection<Object> getArtistList();

	Collection<Object> getDatesList();
	
	
}
