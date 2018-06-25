package fr.eni.clinique.BO;

import java.sql.Date;

public class Agendas {
	Long CodeVeto;
	// Rendez-vous tous les quarts d’heures : 00 ; 15 ; 30 ; 45
	Date DateRdv;
	Long CodeAnimal;

	public Long getCodeVeto() {
		return CodeVeto;
	}

	public void setCodeVeto(Long codeVeto) {
		CodeVeto = codeVeto;
	}

	public Date getDateRdv() {
		return DateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		DateRdv = dateRdv;
	}

	public Long getCodeAnimal() {
		return CodeAnimal;
	}

	public void setCodeAnimal(Long codeAnimal) {
		CodeAnimal = codeAnimal;
	}

	public Agendas(Long codeVeto, Date dateRdv, Long codeAnimal) {
		super();
		CodeVeto = codeVeto;
		DateRdv = dateRdv;
		CodeAnimal = codeAnimal;
	}
}
