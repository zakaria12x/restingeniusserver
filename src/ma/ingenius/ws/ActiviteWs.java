package ma.ingenius.ws;

import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import ma.ingenius.metier.MetierActivite;

@Path("/act")
public class ActiviteWs {
	
	MetierActivite act = new MetierActivite();

	
    @GET 
    @Path("/commenter")
    @Produces(MediaType.APPLICATION_JSON)  
    public String commenter(@QueryParam("date") int date,
    		@QueryParam("comment") String commentaire,
    		@QueryParam("quantite") int quantite,
    		@QueryParam("id_util") int id_utilisateur,
    		@QueryParam("id_projet") int id_projet) {        
		String response = "";
        System.out.println("999999999999999999999");

		try {
			Long a = (long) date;
			Long b = (long) quantite;
			Long c = (long) id_utilisateur;
			Long d = (long) id_projet;			
			
			if(act.modifier( a,  commentaire, b, c, d)){
					response = constructJSON("immo",true,"ok");	
				}else{
					response = constructJSON("immo",false,"ko");
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
