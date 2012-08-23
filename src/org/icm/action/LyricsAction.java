package org.icm.action;

import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.icm.facade.ILyricsBo;
import org.icm.model.LyricsMaster;

public class LyricsAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LyricsAction.class);

	private Collection<LyricsMaster> lyrics;
	private LyricsMaster lyric;
	private ILyricsBo lyricsBo;
	private String lid;
	private String type;
	private Collection<Object> languageMaster;
	private Collection<Object> albumsList;
	private Collection<Object> datesList;
	private Collection<Object> artistList;

	private String title;
	private String keywords;
	private String languageName;
	private String album;
	private String genre;
	private String artists;
	private String lyricsDesc;
	private String lastModifiedDate;

	private String lyricsCheckBox;

	public Collection<Object> getLanguageMaster() {
		return languageMaster;
	}

	public void setLanguageMaster(Collection<Object> languageMaster) {
		this.languageMaster = languageMaster;
	}

	public void init() {
		try {
			super.init();
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public String execute() {
		try {
			languageMaster = lyricsBo.getLanguages();
			albumsList = lyricsBo.getAlbumsList();
			artistList = lyricsBo.getArtistList();
			datesList = lyricsBo.getDatesList();
			lyrics = lyricsBo.getLyrics();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String searchLyrics() {
		try {
			languageMaster = lyricsBo.getLanguages();
			albumsList = lyricsBo.getAlbumsList();
			artistList = lyricsBo.getArtistList();
			datesList = lyricsBo.getDatesList();
			
			HashMap<String, String> map = new HashMap<String, String>();
			if(artists!=null && !artists.equalsIgnoreCase("-1")){
				map.put("artists", artists);
			}
			if(album!=null && !album.equalsIgnoreCase("-1")){
				map.put("albumName", album);
			}
			if(languageName!=null && !languageName.equalsIgnoreCase("-1")){
				map.put("languageId", languageName);
			}
			if(lastModifiedDate!=null && !lastModifiedDate.equalsIgnoreCase("-1")){
				map.put("lastModifiedDate", lastModifiedDate);
			}
			
			lyrics = lyricsBo.getLyrics(map);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String addLyrics() {
		try {
			// lyrics = lyricsBo.getLyrics();
			languageMaster = lyricsBo.getLanguages();
			return INPUT;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String submitLyrics() {
		try {
			LyricsMaster lyricsMaster  = new LyricsMaster();
			lyricsMaster.setTitle(title);
			lyricsMaster.setAlbumName(album);
			lyricsMaster.setArtists(artists);
			lyricsMaster.setGenre(genre);
			lyricsMaster.setKeywords(keywords);
			lyricsMaster.setLyrics(lyricsDesc);
			lyricsMaster.setLanguageMaster(lyricsBo.getLanguageMaster(Integer.parseInt(languageName)));
			String flag = validate(lyricsMaster);
			
			if("valid".equalsIgnoreCase(flag)){
				int val = lyricsBo.addLyrics(lyricsMaster);
				if(val==0)
				{
					addActionError("Unable to process request, Please try again");
					return INPUT;
				}
				lyrics = lyricsBo.getLyrics();
				return SUCCESS;
			}
			else{
				
				addActionError(flag);
				return INPUT;
			}
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String editLyrics() {
		try {
			
			LyricsMaster lyricsMaster  = lyricsBo.getLyrics(Integer.parseInt(lid));
			
			lyricsMaster.setTitle(title);
			lyricsMaster.setAlbumName(album);
			lyricsMaster.setArtists(artists);
			lyricsMaster.setGenre(genre);
			lyricsMaster.setKeywords(keywords);
			lyricsMaster.setLyrics(lyricsDesc);
			String flag = validate(lyricsMaster);
			
			if("valid".equalsIgnoreCase(flag)){
				int val = lyricsBo.updateLyrics(lyricsMaster);
				if(val==0)
				{
					addActionError("Unable to process request, Please try again");
					return INPUT;
				}
				lyrics = lyricsBo.getLyrics();
				return SUCCESS;
			}
			else{
				
				addActionError(flag);
				return INPUT;
			}
		} catch (Exception e) {
			return ERROR;
		}
	}
	private String validate(LyricsMaster lyricsMaster) {
		StringBuffer sb =  new StringBuffer();
		// TODO Auto-generated method stub
		
		
		if(lyricsMaster.getAlbumName()==null || lyricsMaster.getAlbumName().length()<1)
			sb.append("Please enter Valid Album Name");
		if(lyricsMaster.getArtists()==null || lyricsMaster.getArtists().length()<1)
			sb.append("Please enter Valid Artists Name");
		
		if(lyricsMaster.getGenre()==null || lyricsMaster.getGenre().length()<1)
			sb.append("Please enter Valid Genre Name");
		if(lyricsMaster.getKeywords()==null || lyricsMaster.getKeywords().length()<1)
			sb.append("Please enter Valid Keywords Name");
		
		if(lyricsMaster.getLanguageMaster()==null)
			sb.append("Please select Language");
		if(lyricsMaster.getTitle()==null || lyricsMaster.getTitle().length()<1)
			sb.append("Please enter Valid Title Name");
		if(lyricsMaster.getLyrics()==null || lyricsMaster.getLyrics().length()<1)
			sb.append("Please enter Valid Lyrics Name");
		
		if(sb.length()>1){
		
			return sb.toString();
		}
	
		return "valid";
	}

	public String modifyLyrics() {
		System.out.println("lid :" + lid);
		System.out.println("type: " + type);
		if ("del".equalsIgnoreCase(type)) {
			lyricsBo.deleteLyrics(Integer.parseInt(lid));
			lyrics = lyricsBo.getLyrics();
			return SUCCESS;

		} else if ("delAll".equalsIgnoreCase(type)) {
			if (lyricsCheckBox != null) {
				System.out.println("lyricsCheckbox: " + lyricsCheckBox);
				String lyricsToBeDeleted[] = lyricsCheckBox.split(",");
				for (String string : lyricsToBeDeleted) {
					lyricsBo.deleteLyrics(Integer.parseInt(string.trim()));
				}

			}

			lyrics = lyricsBo.getLyrics();
			return SUCCESS;

		} else if ("edit".equalsIgnoreCase(type)) {
			languageMaster = lyricsBo.getLanguages();
			lyric = lyricsBo.getLyrics(Integer.parseInt(lid));
			System.out.println("edit lid" + lid);
			return INPUT;
		}

		return ERROR;
	}

	public ILyricsBo getLyricsBo() {
		return lyricsBo;
	}

	public void setLyricsBo(ILyricsBo lyricsBo) {
		this.lyricsBo = lyricsBo;
	}

	public Collection<LyricsMaster> getLyrics() {
		return lyrics;
	}

	public void setLyrics(Collection<LyricsMaster> lyrics) {
		this.lyrics = lyrics;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LyricsMaster getLyric() {
		return lyric;
	}

	public void setLyric(LyricsMaster lyric) {
		this.lyric = lyric;
	}

	public String getLyricsCheckBox() {
		return lyricsCheckBox;
	}

	public void setLyricsCheckBox(String lyricsCheckBox) {
		this.lyricsCheckBox = lyricsCheckBox;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtists() {
		return artists;
	}

	public void setArtists(String artists) {
		this.artists = artists;
	}

	public String getLyricsDesc() {
		return lyricsDesc;
	}

	public void setLyricsDesc(String lyricsDesc) {
		this.lyricsDesc = lyricsDesc;
	}

	public Collection<Object> getAlbumsList() {
		return albumsList;
	}

	public void setAlbumsList(Collection<Object> albumsList) {
		this.albumsList = albumsList;
	}

	public Collection<Object> getDatesList() {
		return datesList;
	}

	public void setDatesList(Collection<Object> datesList) {
		this.datesList = datesList;
	}

	public Collection<Object> getArtistList() {
		return artistList;
	}

	public void setArtistList(Collection<Object> artistList) {
		this.artistList = artistList;
	}
	
}
