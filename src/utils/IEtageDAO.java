package utils;

import java.util.List;

import beans.Etage;

public interface IEtageDAO {
	public List<Etage> findAll();
	public Etage findById(int id);
	public Etage save(Etage etage);
	public List<Etage> findByBatimentId(int id);
}
