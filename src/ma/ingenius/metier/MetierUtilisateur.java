package ma.ingenius.metier;

import java.util.List;

import ma.ingenius.daoimplementation.UtilisateurDaoImpl;
import ma.ingenius.model.Utilisateur;

public class MetierUtilisateur {
	
	UtilisateurDaoImpl dao = new UtilisateurDaoImpl();

	public void setDaoUser(UtilisateurDaoImpl dao) {
		this.dao = dao;
	}
	
	public String getUser(int id){
		Utilisateur user = dao.getByIdUtilisateur(id);
		if(user != null)
			return user.getLogin();
		return "user n'existe pas";
		
	}
	
	public Utilisateur findByLoginAndPass(String login,String pass){
		 List<Utilisateur> lcom = dao.getAllUtilisateur();
		 Utilisateur user=null;
		 for(Utilisateur auth: lcom){
			 if((auth.getLogin().equals(login))&&(auth.getPassword().equals(pass)))
			 user=auth;
		 }
		return user;
		 
	 }
	

}
