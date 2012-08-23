/**
 * 
 */
package org.icm.dao;

import java.util.Map;

/**
 * @author nageswararao.vejja
 *
 */
public interface IHomeDao {
	Map<String, String> getTodoApprovedList();
	Map<String, String> getTodoProcessedList(); 

}
