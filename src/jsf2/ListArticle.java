package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import utils.IArticleDAO;
import beans.Article;

@Component
@ManagedBean
public class ListArticle {

	private IArticleDAO articleDAO;
	public IArticleDAO getArticleDAO() {return articleDAO;}
	public void setArticleDAO(IArticleDAO articleDAO) {this.articleDAO = articleDAO;}
	
	private List<Article> articles;
	public List<Article> getArticles() {
		articles = getArticleDAO().findAll();
		return articles;
	}
	
}
