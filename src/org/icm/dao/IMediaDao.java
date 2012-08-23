/**
 * 
 */
package org.icm.dao;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.MediaMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public interface IMediaDao {
	int addMedia(MediaMaster media);

	int updateMedia(MediaMaster media);

	MediaMaster getMedia(int id);

	Collection<MediaMaster> getMedia(HashMap<String, String> map,int iPageNo, int iPageSize);

	Collection<MediaMaster> getMedia(int iPageNo, int iPageSize);

	int deleteMedia(int id);

	Collection<MediaMaster> getMedia(String Keyword);

	int deleteMedia(String mediaCheckBox);

	Collection<Object> getGenresList();

	Collection<Object> getModifiedDateList();
}
