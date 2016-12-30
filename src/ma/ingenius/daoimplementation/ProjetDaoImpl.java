package ma.ingenius.daoimplementation;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ma.ingenius.daointerfaces.ProjetDao;
import ma.ingenius.model.Projet;

public class ProjetDaoImpl implements ProjetDao {
	
	
	Configuration configuration = new Configuration().configure("ma/ingenius/util/hibernate.cfg.xml");
	SessionFactory sessionfactory = configuration.buildSessionFactory();
	
	
	@Override
	public List<Projet> getAllProjetByUtil(int id) {
		List<Projet> ListProjet=null;
		
		try{
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			String req = "select ac.projet from Activite as ac where ac.utilisateur.idutilisateur= '"+id+"'";
			ListProjet =  (List<Projet>) session.createQuery(req).list();
			tx.commit();
			session.close();
		 	}
	        catch (HibernateException he)
	        {	
	        	he.printStackTrace();

	        }
		return ListProjet;	

	}
}
