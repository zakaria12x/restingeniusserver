package ma.ingenius.ws;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import ma.ingenius.metier.MetierUtilisateur;
import ma.ingenius.model.Utilisateur;

@Path("/login")
public class UtilisateurWs {
	MetierUtilisateur metier = new MetierUtilisateur();
	
	    @GET 
	    @Path("/dologin")
	    @Produces(MediaType.APPLICATION_JSON)  
	    public String doLogin(@QueryParam("login") String login,@QueryParam("pwd") String pwd) {        
			String response = "";
				try {
					Utilisateur com = metier.findByLoginAndPass(login,pwd);
					if(com!=null){
						response = constructJSON("login",true,com.getIdutilisateur());	
					}else{
						response = constructJSONInt("login",false,-1);
					}
								
				} catch (Exception e) { 
					e.printStackTrace();
				}
			    
			
			  
	    return response;        
	    }
	    
	    public String constructJSON(String tag, boolean status, Long bigDecimal) {
			JSONObject obj = new JSONObject();
			try {
				obj.put("tag", tag);
				obj.put("status", new Boolean(status));
				obj.put("id", bigDecimal);	
			} catch (JSONException e) {}
			return obj.toString();
		}
	    
	    public String constructJSONInt(String tag, boolean status, int i) {
			JSONObject obj = new JSONObject();
			try {
				obj.put("tag", tag);
				obj.put("status", new Boolean(status));
				obj.put("id", i);	
			} catch (JSONException e) {}
			return obj.toString();
		}
	 

}
