package utils;

import beans.Utilisateur;

public interface IUtilisateurDAO {
	public Utilisateur findByEmailAndPassword(String email, String password, boolean isIntervenant);
	public Utilisateur save(Utilisateur utilisateur);
	public Utilisateur findByToken(String token);
}
