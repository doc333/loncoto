package utils;

import java.util.List;

import beans.Statut;

import com.sun.org.apache.xerces.internal.util.Status;

public interface IStatutDAO {
	public List<Statut> findAll();
	public Statut findById(int id);
	public Statut save(Statut statut);
}
