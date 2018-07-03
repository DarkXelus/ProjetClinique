package fr.eni.clinique.bll;

import fr.eni.clinique.ihm.Personnels.EcranGestionPersonnels;

public class SingletonGestionClient {

	private static SingletonGestionClient single ;
	// Variable d'instance
	private EcranGestionPersonnels Ecran ;

	private SingletonGestionClient() {
		
	}

	public static SingletonGestionClient getInstance() {
		if (single == null)
			single = new SingletonGestionClient();

		return single;
	}

	public EcranGestionPersonnels getEcran() {
		return this.Ecran;
	}
	
	public void setEcran(EcranGestionPersonnels ec) {
		this.Ecran = ec;
	}

}
