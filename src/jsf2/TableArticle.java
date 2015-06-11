package jsf2;

import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import utils.IArticleDAO;
import beans.Article;

@Component
@ManagedBean
public class TableArticle {
	private IArticleDAO articleDAO;
	public IArticleDAO getArticleDAO() {return articleDAO;}
	public void setArticleDAO(IArticleDAO articleDAO) {this.articleDAO = articleDAO;}
	
	private String type;
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}

	private List<Article> articles;
	public void setArticles(List<Article> articles) {this.articles = articles;}
	public List<Article> getArticles() {
		
		switch (getType()) {
		case "Article":
			articles = getArticleDAO().findAll();
			break;
		case "SFamille":
			articles = getArticleDAO().findAllSFamille();
			break;
		case "Famille":
			articles = getArticleDAO().findAllFamille();
			break;
		default:
			setType("Article");
			articles = getArticleDAO().findAll();
			break;
		}
		
		return articles;
	}
	
	public String tableArticle() {
		String type = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("type");
		
		setType(type);
		
		getArticles();
		return "listArticle";
	}
}
