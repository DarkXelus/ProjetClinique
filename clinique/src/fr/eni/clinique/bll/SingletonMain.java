package fr.eni.clinique.bll;

import fr.eni.clinique.ihm.login.EcranMain1;

public class SingletonMain {
	private static SingletonMain single ;
	// Variable d'instance
	private EcranMain1 Ecran ;

	private SingletonMain() {
		
	}

	public static SingletonMain getInstance() {
		if (single == null)
			single = new SingletonMain();

		return single;
	}

	public EcranMain1 getEcran() {
		return this.Ecran;
	}
	
	public void setEcran(EcranMain1 ec) {
		this.Ecran = ec;
	}
}
