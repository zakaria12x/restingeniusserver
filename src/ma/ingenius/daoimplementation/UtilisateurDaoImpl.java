package ma.ingenius.daoimplementation;


import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ma.ingenius.daointerfaces.UtilisateurDao;
import ma.ingenius.model.Utilisateur;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
	
	Configuration configuration = new Configuration().configure("ma/ingenius/util/hibernate.cfg.xml");
	SessionFactory sessionfactory = configuration.buildSessionFactory();

	@Override
	public Utilisateur getByIdUtilisateur(int id) {
		Utilisateur util=null;
		try{
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();				
			util = (Utilisateur)session.get("ma.ingenius.model.Utilisateur", id);
			tx.commit();
			session.close();							
		 	}
	        catch (HibernateException he)
	        {		        	
	        	he.printStackTrace();
	        }
		return util;
}

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		List<Utilisateur> listeutilisateur =null;
		try{
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();				
			 listeutilisateur =  (List<Utilisateur>) session.createQuery("from Utilisateur").list();
			tx.commit();	
			session.close();
		 	}
	        catch (HibernateException he)
	        {		        	
	        	he.printStackTrace();
	        }
		return listeutilisateur;							

}
}
