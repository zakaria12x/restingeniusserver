package ma.ingenius.daointerfaces;

import java.math.BigDecimal;

import ma.ingenius.model.Activite;

public interface ActiviteDao {
	
	   Activite getActByDate(Long code, Long util, Long projet);
	   void modifier(Activite act);
	   public void insert(Long date, String commentaire, Long quantite ,Long util, Long projet);   
}
