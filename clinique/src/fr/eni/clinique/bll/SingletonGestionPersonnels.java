package fr.eni.clinique.bll;

import fr.eni.clinique.ihm.Personnels.EcranGestionPersonnels;

public class SingletonGestionPersonnels {

	private static SingletonGestionPersonnels single ;
	// Variable d'instance
	private EcranGestionPersonnels Ecran ;

	private SingletonGestionPersonnels() {
		
	}

	public static SingletonGestionPersonnels getInstance() {
		if (single == null)
			single = new SingletonGestionPersonnels();

		return single;
	}

	public EcranGestionPersonnels getEcran() {
		return this.Ecran;
	}
	
	public void setEcran(EcranGestionPersonnels ec) {
		this.Ecran = ec;
	}

}
