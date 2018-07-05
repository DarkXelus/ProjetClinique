package fr.eni.clinique.bll;

import fr.eni.clinique.ihm.clients.EcranGestionClients;

public class SingletonGestionClients {

	private static SingletonGestionClients single ;
	// Variable d'instance
	private EcranGestionClients Ecran ;

	private SingletonGestionClients() {
		
	}

	public static SingletonGestionClients getInstance() {
		if (single == null)
			single = new SingletonGestionClients();

		return single;
	}

	public EcranGestionClients getEcran() {
		return this.Ecran;
	}
	
	public void setEcran(EcranGestionClients ec) {
		this.Ecran = ec;
	}
}
