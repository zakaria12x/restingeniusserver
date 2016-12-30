package ma.ingenius.daointerfaces;

import java.util.List;

import ma.ingenius.model.Projet;

public interface ProjetDao {
	public List<Projet> getAllProjetByUtil(int id);
}
