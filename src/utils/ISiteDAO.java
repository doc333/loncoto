package utils;

import java.util.List;

import beans.Site;

public interface ISiteDAO {
	public List<Site> findAll();
	public Site findById(int id);
	public Site save(Site site);
}
