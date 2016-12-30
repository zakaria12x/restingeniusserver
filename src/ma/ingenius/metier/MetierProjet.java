package ma.ingenius.metier;

import java.util.List;

import ma.ingenius.daoimplementation.ProjetDaoImpl;
import ma.ingenius.model.Projet;

public class MetierProjet {
	
	ProjetDaoImpl dao = new ProjetDaoImpl();
	
	public List<Projet> getAllProjetByidutil(int id ){
		List<Projet> listepro = null;
		try{
		listepro = dao.getAllProjetByUtil(id);
;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listepro;
	}
}
