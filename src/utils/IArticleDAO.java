package utils;

import java.util.List;

import beans.Article;

public interface IArticleDAO {
	public List<Article> findAll();
	public List<Article> findAllSFamille();
	public List<Article> findAllFamille();
	
	public Article findById(int id);
	public Article findSFamilleByArticleId(int id);
	public Article findFamilleByArticleId(int id);
	
	public Article save(Article article);
}
