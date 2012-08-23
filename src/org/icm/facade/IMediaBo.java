/**
 * 
 */
package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.CategoryMaster;
import org.icm.model.MediaMaster;
import org.icm.model.LanguageMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public interface IMediaBo {

	Collection<MediaMaster> getMedia(HashMap<String, String> map,int iPageNo, int iPageSize);

	Collection<MediaMaster> getMedia(int iPageNo, int iPageSize);

	int deleteMedia(int id);

	MediaMaster getMedia(int id);

	Collection<Object> getLanguages();

	void deleteMedia(String mediaCheckBox);

	LanguageMaster getLanguageMaster(int id);

	int addMedia(MediaMaster mediaMaster);

	int updateMedia(MediaMaster mediaMaster);

	Collection<Object> getCategories();

	CategoryMaster getCategoryMaster(int parseInt);

	Collection<Object> getGenresList();

	Collection<Object> getModifiedDateList();

}
