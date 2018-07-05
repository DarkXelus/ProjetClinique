package fr.eni.clinique.bll;

import fr.eni.clinique.ihm.login.EcranMain;

public class SingletonMain {
	private static SingletonMain single ;
	// Variable d'instance
	private EcranMain Ecran ;

	private SingletonMain() {
		
	}

	public static SingletonMain getInstance() {
		if (single == null)
			single = new SingletonMain();

		return single;
	}

	public EcranMain getEcran() {
		return this.Ecran;
	}
	
	public void setEcran(EcranMain ec) {
		this.Ecran = ec;
	}
}
