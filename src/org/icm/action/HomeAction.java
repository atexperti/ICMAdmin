package org.icm.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.icm.facade.IHomeBo;

public class HomeAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(HomeAction.class);

	private IHomeBo homeBo;
	private Map<String, Map<String, String>> todoList;// = new HashMap<String,
														// Map<String,String>>();

	public IHomeBo getHomeBo() {
		return homeBo;
	}

	public void setHomeBo(IHomeBo homeBo) {
		this.homeBo = homeBo;
	}

	public Map<String, Map<String, String>> getTodoList() {
		return todoList;
	}

	public void setTodoList(Map<String, Map<String, String>> todoList) {
		this.todoList = todoList;
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
			System.out.println("calling todo list");
			todoList = homeBo.getTodoList();

			return SUCCESS;
		} catch (Exception e) {
			logger.error(e);
			return ERROR;
		}
	}

}
