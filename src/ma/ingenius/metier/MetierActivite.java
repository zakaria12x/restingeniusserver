package ma.ingenius.metier;
import java.math.BigDecimal;
import java.util.Date;

import ma.ingenius.daoimplementation.ActiviteDaoImpl;
import ma.ingenius.model.Activite;
import ma.ingenius.model.Projet;
import ma.ingenius.model.Utilisateur;

public class MetierActivite {
	
	ActiviteDaoImpl actd = new ActiviteDaoImpl();
	
	public boolean modifier(Long date, String commentaire, Long quantite ,Long util, Long projet){
		boolean ok = false;
		try{
		Activite oldAct =  actd.getActByDate(date, util, projet);
		if (oldAct!= null){
			ok = true;
				oldAct.setCommentaire(commentaire);
				oldAct.setQuantite(quantite);
				actd.modifier(oldAct);}
				else{
					actd.insert(date, commentaire, quantite, util, projet);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
	return ok;
	}
}