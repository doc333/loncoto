package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Article;

public class ArticleDAO implements IArticleDAO {

	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Transactional
	public List<Article> findAll() {
		return em.createQuery("select distinct(a) from Article as a"
				+ "right join a.articleEnfant as ae"
				+ "where ae.articleEnfant IS NOT NULL",
				Article.class).getResultList();
	}

	@Transactional
	public List<Article> findAllSFamille() {
		return em.createQuery("select distinct(a) from Article as a"
				+ "right join a.articleEnfant as ae"
				+ "where ae.articleEnfant IS NULL",
				Article.class).getResultList();
	}

	@Transactional
	public List<Article> findAllFamille() {
		return em.createQuery("select a from Article as a"
				+ "where a.articleEnfant IS NULL",
				Article.class).getResultList();
	}

	@Transactional
	public Article findById(int id) {
		return em.find(Article.class, id);
	}

	@Transactional
	public Article findSFamilleByArticleId(int id) {
		return em.createQuery("select a from Article as a"
				+ "where a.articleEnfant IS NULL",
				Article.class).getSingleResult();
	}

	@Transactional
	public Article findFamilleByArticleId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Article save(Article article) {
		// TODO Auto-generated method stub
		return null;
	}

}
