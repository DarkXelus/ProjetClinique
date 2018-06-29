package fr.eni.clinique.bll;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.Personnels.EcranGestionPersonnels;

public class SingletonGestionClient {
	private SingletonGestionClient() {
	}

	private EcranGestionPersonnels  test ;
	private static SingletonGestionClient INSTANCE = new SingletonGestionClient();

	public EcranGestionPersonnels getTest() {
		if(test == null)
		{
			try {
				test = new EcranGestionPersonnels();
			} catch (DALException | BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return test;
	}

	public void setTest(EcranGestionPersonnels test) {
		this.test = test;
	}

	public static SingletonGestionClient getInstance() {
		
		return INSTANCE;
	}

}
