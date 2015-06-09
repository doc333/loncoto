package utils;

import java.util.List;

import beans.Batiment;

public interface IBatimentDAO {
	public List<Batiment> findAll();
	public Batiment findById(int id);
	public Batiment save(Batiment batiment);
}
