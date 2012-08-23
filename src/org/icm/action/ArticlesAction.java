package org.icm.action;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.icm.facade.IArticlesBo;
import org.icm.model.ArticleMaster;

import com.opensymphony.xwork2.ActionContext;

public class ArticlesAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ArticlesAction.class);
	private IArticlesBo articlesBo;
	
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	private Collection<ArticleMaster> articles;
	private ArticleMaster articleMaster;
	private String articleId;
	private String type;
	private Collection<Object> languageMaster;
	private Collection<Object> authorsList;
	private Collection<Object> dateCreateList;
	private Collection<Object> dateModifiedList;
	

	private String title;
	private String languageName;
	private String author;

	private String articleDesc;
	private String lastModifiedDate;
	private String dateadded;
	
	

	private String articleCheckBox;

	public void init() {
		try {
			super.init();
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public String execute() {
		try {
			languageMaster = articlesBo.getLanguages();
			authorsList = articlesBo.getAuthorList();
			dateCreateList = articlesBo.getCreatedDateList();
			dateModifiedList = articlesBo.getModifiedDateList();
			articles = articlesBo.getArticles();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String searchArticles() {
		try {
			languageMaster = articlesBo.getLanguages();
			authorsList = articlesBo.getAuthorList();
			dateCreateList = articlesBo.getCreatedDateList();
			dateModifiedList = articlesBo.getModifiedDateList();
			
			HashMap<String, String> map = new HashMap<String, String>();
			if (author != null && !author.equalsIgnoreCase("-1")) {
				map.put("author", author);
			}

			if (languageName != null && !languageName.equalsIgnoreCase("-1")) {
				map.put("languageId", languageName);
			}
			if (dateadded != null
					&& !dateadded.equalsIgnoreCase("-1")) {
				map.put("dateadded", dateadded);
			}
			
			if (lastModifiedDate != null
					&& !lastModifiedDate.equalsIgnoreCase("-1")) {
				map.put("lastModifiedDate", lastModifiedDate);
			}

			articles = articlesBo.getArticles(map);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String addArticles() {
		try {
			// articles = articlesBo.getArticles();
			languageMaster = articlesBo.getLanguages();
			return INPUT;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String submitArticles() {
		try {
			ArticleMaster articlesMaster = new ArticleMaster();
			articlesMaster.setTitle(title);
			articlesMaster.setArticle(articleDesc);
			System.out.println(session.get("userName")+"");
			articlesMaster.setUserMaster(articlesBo.getUserMaster((String)session.get("userName")));
			articlesMaster.setStatus(1);
			articlesMaster.setLanguageMaster(articlesBo
					.getLanguageMaster(Integer.parseInt(languageName)));
			String flag = vaarticleIdate(articlesMaster);

			if ("vaarticleId".equalsIgnoreCase(flag)) {
				int val = articlesBo.addArticles(articlesMaster);
				if (val == 0) {
					addActionError("Unable to process request, Please try again");
					return INPUT;
				}
				articles = articlesBo.getArticles();
				languageMaster = articlesBo.getLanguages();
				return SUCCESS;
			} else {

				addActionError(flag);
				return INPUT;
			}
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String editArticles() {
		try {

			ArticleMaster articlesMaster = articlesBo.getArticles(Integer
					.parseInt(articleId));

			articlesMaster.setTitle(title);
			articlesMaster.setArticle(articleDesc);
			articlesMaster.setLastModifiedDate(new Date(System.currentTimeMillis()));

			String flag = vaarticleIdate(articlesMaster);

			if ("vaarticleId".equalsIgnoreCase(flag)) {
				int val = articlesBo.updateArticles(articlesMaster);
				if (val == 0) {
					addActionError("Unable to process request, Please try again");
					return INPUT;
				}
				languageMaster = articlesBo.getLanguages();
				articles = articlesBo.getArticles();
				return SUCCESS;
			} else {

				addActionError(flag);
				return INPUT;
			}
		} catch (Exception e) {
			return ERROR;
		}
	}

	private String vaarticleIdate(ArticleMaster articlesMaster) {
		StringBuffer sb = new StringBuffer();
		// TODO Auto-generated method stub

		if (articlesMaster.getArticle() == null
				|| articlesMaster.getArticle().length() < 1)
			sb.append("Please enter VaarticleId Article");
		if (articlesMaster.getTitle() == null
				|| articlesMaster.getTitle().length() < 1)
			sb.append("Please enter VaarticleId Title");
		if (articlesMaster.getLanguageMaster() == null)
			sb.append("Please select Language");

		if (sb.length() > 1) {

			return sb.toString();
		}

		return "vaarticleId";
	}

	public String modifyArticles() {
		System.out.println("articleId :" + articleId);
		System.out.println("type: " + type);
		if ("del".equalsIgnoreCase(type)) {
			articlesBo.deleteArticles(Integer.parseInt(articleId));
			languageMaster = articlesBo.getLanguages();
			articles = articlesBo.getArticles();
			return SUCCESS;

		} else if ("delAll".equalsIgnoreCase(type)) {
			
			if (articleCheckBox != null) {
				System.out.println("articlesCheckbox: " + articleCheckBox);
				String articlesToBeDeleted[] = articleCheckBox.split(",");
				for (String string : articlesToBeDeleted) {
					articlesBo.deleteArticles(Integer.parseInt(string.trim()));
				}

			}
			
			articles = articlesBo.getArticles();
			languageMaster = articlesBo.getLanguages();
			return SUCCESS;

		}else if ("approve".equalsIgnoreCase(type)) {


			ArticleMaster articlesMaster = articlesBo.getArticles(Integer
					.parseInt(articleId));

			articlesMaster.setStatus(1);
			articlesMaster.setLastModifiedDate(new Date(System.currentTimeMillis()));
			
			int val = articlesBo.updateArticles(articlesMaster);
			if (val == 0) {
				addActionError("Unable to process request, Please try again");
				return INPUT;
			}
			languageMaster = articlesBo.getLanguages();
			articles = articlesBo.getArticles();
			return SUCCESS;

		}else if ("approveall".equalsIgnoreCase(type)) {
			if (articleCheckBox != null) {
				System.out.println("articlesCheckbox: " + articleCheckBox);
				String articlesToBeDeleted[] = articleCheckBox.split(",");
				for (String string : articlesToBeDeleted) {
					//articlesBo.deleteArticles(Integer.parseInt(string.trim()));
				}

			}
			languageMaster = articlesBo.getLanguages();
			articles = articlesBo.getArticles();
			return SUCCESS;

		}
		else if ("edit".equalsIgnoreCase(type)) {
			languageMaster = articlesBo.getLanguages();
			articleMaster = articlesBo.getArticles(Integer.parseInt(articleId));
			System.out.println("edit articleId" + articleId);
			return INPUT;
		}

		return ERROR;
	}

	public Collection<Object> getLanguageMaster() {
		return languageMaster;
	}

	public void setLanguageMaster(Collection<Object> languageMaster) {
		this.languageMaster = languageMaster;
	}

	public IArticlesBo getArticlesBo() {
		return articlesBo;
	}

	public void setArticlesBo(IArticlesBo articlesBo) {
		this.articlesBo = articlesBo;
	}

	public Collection<ArticleMaster> getArticles() {
		return articles;
	}

	public void setArticles(Collection<ArticleMaster> articles) {
		this.articles = articles;
	}

	public ArticleMaster getArticleMaster() {
		return articleMaster;
	}

	public void setArticleMaster(ArticleMaster articleMaster) {
		this.articleMaster = articleMaster;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getArticleDesc() {
		return articleDesc;
	}

	public void setArticleDesc(String articleDesc) {
		this.articleDesc = articleDesc;
	}

	public String getArticleCheckBox() {
		return articleCheckBox;
	}

	public void setArticleCheckBox(String articleCheckBox) {
		this.articleCheckBox = articleCheckBox;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDateadded() {
		return dateadded;
	}

	public void setDateadded(String dateadded) {
		this.dateadded = dateadded;
	}

	public Collection<Object> getAuthorsList() {
		return authorsList;
	}

	public void setAuthorsList(Collection<Object> authorsList) {
		this.authorsList = authorsList;
	}

	public Collection<Object> getDateCreateList() {
		return dateCreateList;
	}

	public void setDateCreateList(Collection<Object> dateCreateList) {
		this.dateCreateList = dateCreateList;
	}

	public Collection<Object> getDateModifiedList() {
		return dateModifiedList;
	}

	public void setDateModifiedList(Collection<Object> dateModifiedList) {
		this.dateModifiedList = dateModifiedList;
	}

}
