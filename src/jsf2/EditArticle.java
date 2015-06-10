package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import beans.Article;
import utils.IArticleDAO;

@Component
@ManagedBean
public class EditArticle {
	private IArticleDAO articleDAO;
	public IArticleDAO getArticleDAO() {return articleDAO;}
	public void setArticleDAO(IArticleDAO articleDAO) {this.articleDAO = articleDAO;}
	
	private String type;
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	private Article article;
	public Article getArticle() {return article;}
	public void setArticle(Article article) {this.article = article;}
	
	private List<Article> sFamilles;
	public List<Article> getSFamilles() {return sFamilles;}
	public void setSFamilles(List<Article> sFamilles) {this.sFamilles = sFamilles;}
	
	private List<Article> familles;
	public List<Article> getFamilles() {return familles;}
	public void setFamilles(List<Article> familles) {this.familles = familles;}
	
	public String createArticle() {
		setFamilles(getArticleDAO().findAllFamille());
		setArticle(new Article());
		
		setType("Article");
		
		return "editArticle";
	}
	
	public String createSFamille() {
		setFamilles(getArticleDAO().findAllFamille());
		setArticle(new Article());
		
		setType("SFamille");
		
		return "editArticle";
	}
	
	public String createFamille(){
		setArticle(new Article());
		
		setType("Famille");
		
		return "editArticle";
	}
}
