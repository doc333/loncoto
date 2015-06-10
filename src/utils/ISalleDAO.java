package utils;

import java.util.List;

import beans.Salle;

public interface ISalleDAO {
	public List<Salle> findAll();
	public Salle findById(int id);
	public Salle save(Salle salle);
	public List<Salle> findByEtageId(int id);
}
