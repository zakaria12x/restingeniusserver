package ma.ingenius.daoimplementation;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ma.ingenius.daointerfaces.ActiviteDao;
import ma.ingenius.model.Activite;
import ma.ingenius.model.Projet;
import ma.ingenius.model.Utilisateur;


public class ActiviteDaoImpl implements ActiviteDao {
	
	
	
	Configuration configuration = new Configuration().configure("ma/ingenius/util/hibernate.cfg.xml");
	SessionFactory sessionfactory = configuration.buildSessionFactory();
	
	@Override
	public Activite getActByDate(Long code, Long util, Long projet) {
		Activite act = new Activite();
		try{
			Session session1 = sessionfactory.openSession();
			Transaction tx1 = session1.beginTransaction();
			String req1 = "from Activite as ac "
					+ "where ac.dat= '"+code+"'"+
					"and  ac.utilisateur.idutilisateur= '"+util+"'"+
					"and  ac.projet.idprojet= '"+projet+"'";
			act = (Activite) session1.createQuery(req1).uniqueResult();
			tx1.commit();
			session1.close();

		 	}
	        catch (HibernateException he)
	        {		        	
	    		he.printStackTrace();
	        }
			return act;
	}
	
	@Override
	 public void modifier(Activite act){
		 try{
			 Session session = sessionfactory.openSession();
				Transaction tx = session.beginTransaction();
				session.update(act);
				tx.commit();
			 session.close();	
			 	}
		        catch (HibernateException he)
		        {		        	
		        	he.printStackTrace();
		        }
		 }
	
	@Override
	 public void insert(Long date, String commentaire, Long quantite ,Long util, Long projet){
		 try{
			 Session session = sessionfactory.openSession();
			 Transaction tx = session.beginTransaction();
		
			 String hqlInsert = "insert into Activite (utilisateur, projet, quantite, commentaire, dat) values ("+util+", "+projet+", "+quantite+", "+commentaire+", "+date+")";
			 int createdEntities = session.createQuery( hqlInsert )
			         .executeUpdate();
			 tx.commit();
			 session.close();	
			 	}
		        catch (HibernateException he)
		        {		        	
		        	he.printStackTrace();
		        }
		 }
	
	
	 }
