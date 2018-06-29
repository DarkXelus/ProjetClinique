package fr.eni.clinique.dal;

import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.bll.BLLException;

public interface DAO<T> {

	public void create(T data) throws DALException;

	// Sélectionner un business object par son id
	public T read(Long id) throws DALException, BLLException;

	// Modifier les attributs d'un business object
	public void update(T data) throws DALException, BLLException;

	// Supprimer un business object
	public void delete(T obj) throws DALException, BLLException;
}
