package jsf2;

import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.stereotype.Component;

import utils.IArticleDAO;
import beans.Article;

@Component
@ManagedBean
public class TableArticle {
	private IArticleDAO articleDAO;
	public IArticleDAO getArticleDAO() {return articleDAO;}
	public void setArticleDAO(IArticleDAO articleDAO) {this.articleDAO = articleDAO;}
	
	private List<Article> articles;
	public void setArticles(List<Article> articles) {this.articles = articles;}
	public List<Article> getArticles() {
		articles = getArticleDAO().findAll();
		return articles;
	}
}
