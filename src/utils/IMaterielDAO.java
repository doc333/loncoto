package utils;

import java.util.List;

import beans.Materiel;

public interface IMaterielDAO {
	public List<Materiel> findAll();
	public Materiel findById(int id);
	public Materiel save(Materiel materiel);
}
