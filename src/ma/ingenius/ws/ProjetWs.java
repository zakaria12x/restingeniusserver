package ma.ingenius.ws;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import ma.ingenius.metier.MetierProjet;
import ma.ingenius.model.Projet;
import ma.ingenius.model.Utilisateur;

@Path("/projet")
public class ProjetWs {
	MetierProjet mt = new MetierProjet();
	
    @GET 
    @Path("/listprojets")
    @Produces(MediaType.APPLICATION_JSON)  
    public String getImo(@QueryParam("idutilisateur") int id_utilisateur) {        
		String response = "";
			try {
				List<Projet> projets = mt.getAllProjetByidutil(id_utilisateur);
				if(projets!=null && projets.size() != 0 ){
					String chaine=null;
					String ligne;
					for(int i = 0 ; i < projets.size(); i++){
						ligne = projets.get(i).getIdprojet() + "," + projets.get(i).getNom() + ";";
						if(i==0){
							chaine=ligne;
						}
						else {
						chaine = chaine + ligne;
						}
						}
					response = constructJSON("projets",true,chaine);
				}else{
					response = constructJSON("projet",false,"aucune projet");
				}							
			} catch (Exception e) { 
				e.printStackTrace();
			}
    return response;        
    }
    
    
    public String constructJSON(String tag, boolean status, String liste) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("tag", tag);
			obj.put("status", new Boolean(status));
			obj.put("liste", liste);	
		} catch (JSONException e) {}
		return obj.toString();
	}
 
}
