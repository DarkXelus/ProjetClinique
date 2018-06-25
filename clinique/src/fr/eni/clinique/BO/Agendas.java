package fr.eni.clinique.BO;

import java.sql.Date;

public class Agendas {
	Long CodeVeto;
	//Rendez-vous tous les quarts d’heures : 00 ; 15 ; 30 ; 45
	Date DateRdv;
	Long CodeAnimal;
	
	public Agendas(Long codeVeto, Date dateRdv, Long codeAnimal) {
		super();
		CodeVeto = codeVeto;
		DateRdv = dateRdv;
		CodeAnimal = codeAnimal;
	}	
}
