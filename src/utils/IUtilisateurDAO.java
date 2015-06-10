package utils;

import beans.Utilisateur;

public interface IUtilisateurDAO {
	public Utilisateur findByEmailAndPassword(String email, String password);
	public Utilisateur save(Utilisateur utilisateur);
}
