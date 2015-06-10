package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		return em.createQuery("select distinct(a) from Article as a "
				+ " right join a.articleParent ap "
				+ " right join ap.articleParent app "
				+ " where app is not null",
				Article.class).getResultList();
	}

	@Transactional
	public List<Article> findAllSFamille() {
		return em.createQuery("select distinct(a) from Article as a"
				+ " right join a.articleParent ap "
				+ " left join ap.articleParent app "
				+ " where app is null "
				+ " and ap is not null ",
				Article.class).getResultList();
	}

	@Transactional
	public List<Article> findAllFamille() {
		return em.createQuery("select a from Article as a"
				+ " left join ap.articleParent ap "
				+ " where ap is null ",
				Article.class).getResultList();
	}

	@Transactional
	public Article findById(int id) {
		return em.find(Article.class, id);
	}
	
	@Transactional
	public List<Article> findArticleByFamilleId(int id) {
		TypedQuery<Article> q = em.createQuery("select ae from Article as a"
				+ " left join a.articleEnfant as ae"
				+ " where a.id = :id", Article.class);
		q.setParameter(id, ":id");
		return q.getResultList();
	}

	@Transactional
	public Article save(Article article) {
		if (article.getId() > 0) {
			article = em.merge(article);
		}
		else {
			em.persist(article);
		}
		return article;
	}
	

}
