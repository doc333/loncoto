package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import beans.Article;
import utils.IArticleDAO;

@Component
@ManagedBean
public class EditArticle {
	private int articleParentID;
	
	
	public int getArticleParentID() {
		return articleParentID;
	}
	public void setArticleParentID(int articleParentID) {
		this.articleParentID = articleParentID;
	}

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
	public List<Article> getsFamilles() {
		int id = Integer.parseInt(getFamilleId());
		sFamilles = getArticleDAO().findArticleByFamilleId(id);
		return sFamilles;
	}
	public void setsFamilles(List<Article> sFamilles) {this.sFamilles = sFamilles;}
	
	private List<Article> familles;
	public List<Article> getFamilles() {
		familles = getArticleDAO().findAllFamille();
		return familles;
	}
	public void setFamilles(List<Article> familles) {this.familles = familles;}
	
	private String familleId;
	public String getFamilleId() {
		if (familleId == null) {
			familleId = String.valueOf(getFamilles().get(0).getId());
		}
		return familleId;
	}
	public void setFamilleId(String familleId) {this.familleId = familleId;}
	
	public String createArticle() {

		setArticle(new Article());
		
		setType("Article");
		
		return "editArticle";
	}
	
	public String createSFamille() {

		setArticle(new Article());
		
		setType("SFamille");
		
		return "editArticle";
	}
	
	public String createFamille(){
		setArticle(new Article());
		
		setType("Famille");
		
		return "editArticle";
	}
	
	public String saveArticle() {
		if(getType() == "Famille") {
			setArticleParentID(0);
		}
		if(getArticleParentID() != 0){
			article.setArticleParent(articleDAO.findById(getArticleParentID()));
		}
		getArticleDAO().save(article);
		return "listArticle";
	}
	
	public String editArticle() {
		int iid = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("aid"));
		
		setArticle(getArticleDAO().findById(iid));
				
		setType(findTypeArticle(getArticle()));
		
		if (getType() != "Famille") {
			
		}
		
		return "editArticle";
	}
	
	public String findTypeArticle(Article article) {
		if (article.getArticleParent() == null) {
			return "Famille";
		}
		else if (article.getArticleParent() != null && article.getArticleParent().getArticleParent() == null) {
			return "SFamille";
		}
		else {
			return "Article";
		}
	}
}
