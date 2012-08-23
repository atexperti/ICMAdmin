package org.icm.action;

import java.io.File;
import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.icm.facade.IMediaBo;
import org.icm.model.MediaMaster;

import com.opensymphony.xwork2.ActionContext;

public class MediaAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MediaAction.class);
	private IMediaBo mediaBo;
	private File userMedia;
	private String userMediaContentType;
	private String userMediaFileName;

	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	// Form fields start
	private String title;
	private String providerName;
	private String description;
	private String album;
	private String thumbnail;
	private String preview;
	private String ocassion;
	private String keywords;
	private String genre;
	private String artist;

	private String categoryName;

	private String languageName;

	private Collection<Object> languageMaster;
	private Collection<Object> categoryMaster;
	private Collection<Object> genresList;
	private Collection<Object> dateModifiedList;

	private Collection<MediaMaster> medias;
	private MediaMaster media;
	private String id;
	private String type;
	private String mediaCheckBox;

	private String lastModifiedDate;
	
	private String pageNo;
	private String pageSize="1";
	private String pageType;

	public void init() {
		try {
			super.init();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	public String execute() {
		int iPageNo = 1;
		int iPageSize = 1;
		try {
			iPageNo = Integer.parseInt(getPageNo());
			if ("prev".equalsIgnoreCase(getPageType())) {
				iPageNo = iPageNo - 1;
				iPageNo = iPageNo > 0 ? iPageNo : 1;
			} else {
				iPageNo = iPageNo + 1;
			}

		} catch (Exception e) {
		}
		setPageNo(iPageNo + "");
		try {
			iPageSize = Integer.parseInt(getPageSize());
		} catch (Exception e) {
		}
		
		try {
			System.out.println("Hi this is media media action");
			languageMaster = mediaBo.getLanguages();
			categoryMaster = mediaBo.getCategories();
			dateModifiedList = mediaBo.getModifiedDateList();
			genresList = mediaBo.getGenresList();
			medias = mediaBo.getMedia(iPageNo, iPageSize);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String searchMedia() {
		int iPageNo = 1;
		int iPageSize = 8;
		try {
			iPageNo = Integer.parseInt(getPageNo());
			if ("prev".equalsIgnoreCase(getPageType())) {
				iPageNo = iPageNo - 1;
				iPageNo = iPageNo > 0 ? iPageNo : 1;
			} else {
				iPageNo = iPageNo + 1;
			}

		} catch (Exception e) {
		}
		setPageNo(iPageNo + "");
		try {
			iPageSize = Integer.parseInt(getPageSize());
		} catch (Exception e) {
		}
		try {
			languageMaster = mediaBo.getLanguages();
			categoryMaster = mediaBo.getCategories();
			dateModifiedList = mediaBo.getModifiedDateList();
			genresList = mediaBo.getGenresList();
			HashMap<String, String> map = new HashMap<String, String>();
			if (categoryName != null && !categoryName.equalsIgnoreCase("-1")) {
				map.put("categoryName", categoryName);
			}

			if (languageName != null && !languageName.equalsIgnoreCase("-1")) {
				map.put("languageId", languageName);
			}

			if (lastModifiedDate != null
					&& !lastModifiedDate.equalsIgnoreCase("-1")) {
				map.put("lastModifiedDate", lastModifiedDate);
			}

			if (genre != null && !genre.equalsIgnoreCase("-1")) {
				map.put("genre", genre);
			}

			medias = mediaBo.getMedia(map,iPageNo, iPageSize);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String addMedia() {
		try {
			// medias = mediaBo.getMedia();
			languageMaster = mediaBo.getLanguages();
			categoryMaster = mediaBo.getCategories();
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String submitMedia() {
		try {
			System.out.println("userMediaFileName: " + userMediaFileName);
			MediaMaster mediasMaster = new MediaMaster();

			System.out.println("userMedia: " + userMedia.getName());
			if (userMedia != null)

			{

				String extension = "";

				if (userMediaFileName != null && !userMediaFileName.equals("")) {
					extension = userMediaFileName.substring(
							userMediaFileName.lastIndexOf("."),
							userMediaFileName.length());
				}

				long longName = Calendar.getInstance().getTimeInMillis(); // date
																			// in
																			// miliseconds
				String newFileName = longName + extension;
				String uploadFolder = "userMedia";

				String filePath = "/usr/local/jakarta/apache-tomcat-5.5.35/webapps/ROOT/"+ uploadFolder;
				System.out.println("newFileName: " + newFileName);
				System.out.println("filePath: " + filePath);

				File fileToCreate = new File(filePath, newFileName);

				FileUtils.copyFile(userMedia, fileToCreate);

				mediasMaster.setPreview(fileToCreate.getPath());
			}

			mediasMaster.setTitle(title);
			mediasMaster.setDescription(description);
			mediasMaster.setLanguageMaster(mediaBo.getLanguageMaster(Integer
					.parseInt(languageName)));
			System.out.println("categoryName: " + categoryName);
			mediasMaster.setCategoryMaster(mediaBo.getCategoryMaster(Integer
					.parseInt(categoryName)));
			mediasMaster.setAlbum(album);
			mediasMaster.setArtist(artist);
			mediasMaster.setGenre(genre);
			mediasMaster.setKeywords(keywords);
			mediasMaster.setOcassion(ocassion);
			// mediasMaster.setPreview(preview);
			mediasMaster.setProviderName(providerName);
			mediasMaster.setThumbnail(thumbnail);
			mediasMaster.setLastModifiedDate(new Date(System
					.currentTimeMillis()));

			String flag = vaidate(mediasMaster);
			languageMaster = mediaBo.getLanguages();
			categoryMaster = mediaBo.getCategories();
			System.out.println(flag);
			if ("vaid".equalsIgnoreCase(flag)) {
				int val = mediaBo.addMedia(mediasMaster);
				System.out.println("val: " + val);
				System.out.println(session.get("userName") + "");
				if (val == 0) {
					addActionError("Unable to process request, Please try again");

					return INPUT;
				}
				medias = mediaBo.getMedia(1,8);
				return SUCCESS;
			} else {

				addActionError(flag);
				return INPUT;
			}
		} catch (Exception e) {
			System.out.println("Error in Submit Media: ");
			e.printStackTrace();
			return ERROR;
		}
	}

	public String editMedia() {
		try {

			MediaMaster mediasMaster = mediaBo.getMedia(Integer.parseInt(id));

			mediasMaster.setTitle(title);
			mediasMaster.setDescription(description);
			mediasMaster.setAlbum(album);
			mediasMaster.setArtist(artist);
			mediasMaster.setGenre(genre);
			mediasMaster.setKeywords(keywords);
			mediasMaster.setOcassion(ocassion);
			if (userMedia != null)

			{
				// String fileName = userMedia.getName();
				String extension = "";

				if (userMediaFileName != null && !userMediaFileName.equals("")) {
					extension = userMediaFileName.substring(
							userMediaFileName.lastIndexOf("."),
							userMediaFileName.length());
				}

				long longName = Calendar.getInstance().getTimeInMillis(); // date
																			// in
																			// miliseconds
				String newFileName = longName + extension;
				String uploadFolder = "userMedia";

				String filePath = getRequest().getSession().getServletContext()
						.getRealPath("/")
						+ uploadFolder;
				System.out.println("newFileName: " + newFileName);
				System.out.println("filePath: " + filePath);

				File fileToCreate = new File(filePath, newFileName);

				FileUtils.copyFile(userMedia, fileToCreate);

				mediasMaster.setPreview(fileToCreate.getPath());

			}
			mediasMaster.setProviderName(providerName);
			mediasMaster.setLastModifiedDate(new Date(System
					.currentTimeMillis()));

			String flag = vaidate(mediasMaster);
			System.out.println("flag: " + flag);
			languageMaster = mediaBo.getLanguages();
			categoryMaster = mediaBo.getCategories();
			if ("vaid".equalsIgnoreCase(flag)) {
				int val = mediaBo.updateMedia(mediasMaster);
				if (val == 0) {
					addActionError("Unable to process request, Please try again");
					media = mediaBo.getMedia(Integer.parseInt(id));
					return INPUT;
				}
				medias = mediaBo.getMedia(1,8);
				return SUCCESS;
			} else {
				media = mediaBo.getMedia(Integer.parseInt(id));
				addActionError(flag);
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	private String vaidate(MediaMaster mediasMaster) {
		StringBuffer sb = new StringBuffer();
		// TODO Auto-generated method stub

		if (mediasMaster.getAlbum() == null
				|| mediasMaster.getAlbum().length() < 1)
			sb.append("Please enter valid Album");
		if (mediasMaster.getArtist() == null
				|| mediasMaster.getArtist().length() < 1)
			sb.append("Please enter valid Artist");
		if (mediasMaster.getLanguageMaster() == null)
			sb.append("Please select Language");

		if (mediasMaster.getCategoryMaster() == null)
			sb.append("Please enter categoryName");

		if (mediasMaster.getGenre() == null
				|| mediasMaster.getGenre().length() < 1)
			sb.append("Please enter valid Genre");
		if (mediasMaster.getDescription() == null)
			sb.append("Please Enter Description");

		if (mediasMaster.getTitle() == null
				|| mediasMaster.getTitle().length() < 1)
			sb.append("Please enter valid Title");

		if (mediasMaster.getPreview() == null
				|| mediasMaster.getPreview().length() < 1)
			sb.append("Please enter valid Preview");

		if (sb.length() > 1) {

			return sb.toString();
		}

		return "vaid";
	}

	public String modifyMedia() {
		System.out.println("id :" + id);
		System.out.println("type: " + type);
		languageMaster = mediaBo.getLanguages();
		categoryMaster = mediaBo.getCategories();

		if ("del".equalsIgnoreCase(type)) {
			System.out.println("del id: " + id);
			mediaBo.deleteMedia(Integer.parseInt(id));

			medias = mediaBo.getMedia(1,8);
			return SUCCESS;

		} else if ("delAll".equalsIgnoreCase(type)) {

			if (mediaCheckBox != null) {
				System.out.println("mediasCheckbox: " + mediaCheckBox);
				String mediasToBeDeleted[] = mediaCheckBox.split(",");
				for (String string : mediasToBeDeleted) {
					mediaBo.deleteMedia(Integer.parseInt(string.trim()));
				}

			}

			medias = mediaBo.getMedia(1,8);
			return SUCCESS;

		} else if ("edit".equalsIgnoreCase(type)) {
			try {
				media = mediaBo.getMedia(Integer.parseInt(id));
				System.out.println("edit id: " + id);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return ERROR;
			}
			return INPUT;
		}

		return ERROR;
	}

	public IMediaBo getMediaBo() {
		return mediaBo;
	}

	public void setMediaBo(IMediaBo mediaBo) {
		this.mediaBo = mediaBo;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getOcassion() {
		return ocassion;
	}

	public void setOcassion(String ocassion) {
		this.ocassion = ocassion;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getCategory() {
		return categoryName;
	}

	public void setCategory(String category) {
		this.categoryName = category;
	}

	public Collection<Object> getLanguageMaster() {
		return languageMaster;
	}

	public void setLanguageMaster(Collection<Object> languageMaster) {
		this.languageMaster = languageMaster;
	}

	public Collection<Object> getCategoryMaster() {
		return categoryMaster;
	}

	public void setCategoryMaster(Collection<Object> categoryMaster) {
		this.categoryMaster = categoryMaster;
	}

	public Collection<MediaMaster> getMedias() {
		return medias;
	}

	public void setMedias(Collection<MediaMaster> medias) {
		this.medias = medias;
	}

	public MediaMaster getMedia() {
		return media;
	}

	public void setMedia(MediaMaster media) {
		this.media = media;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaCheckBox() {
		return mediaCheckBox;
	}

	public void setMediaCheckBox(String mediaCheckBox) {
		this.mediaCheckBox = mediaCheckBox;
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

	public File getUserMedia() {
		return userMedia;
	}

	public void setUserMedia(File userMedia) {
		this.userMedia = userMedia;
	}

	public String getUserMediaContentType() {
		return userMediaContentType;
	}

	public void setUserMediaContentType(String userMediaContentType) {
		this.userMediaContentType = userMediaContentType;
	}

	public String getUserMediaFileName() {
		return userMediaFileName;
	}

	public void setUserMediaFileName(String userMediaFileName) {
		this.userMediaFileName = userMediaFileName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Collection<Object> getGenresList() {
		return genresList;
	}

	public void setGenresList(Collection<Object> genresList) {
		this.genresList = genresList;
	}

	public Collection<Object> getDateModifiedList() {
		return dateModifiedList;
	}

	public void setDateModifiedList(Collection<Object> dateModifiedList) {
		this.dateModifiedList = dateModifiedList;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

}
