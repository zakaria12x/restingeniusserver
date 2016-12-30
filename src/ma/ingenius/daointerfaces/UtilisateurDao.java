package ma.ingenius.daointerfaces;

import java.util.List;

import ma.ingenius.model.Utilisateur;

public interface UtilisateurDao {
	
	public Utilisateur getByIdUtilisateur(int id);
	public List<Utilisateur> getAllUtilisateur();


}
