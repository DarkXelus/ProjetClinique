package fr.eni.clinique.BO;

public class Races {
	// size 20
	String Race;
	// size 20
	String Espece;

	public String getRace() {
		return Race;
	}

	public void setRace(String race) {
		Race = race;
	}

	public String getEspece() {
		return Espece;
	}

	public void setEspece(String espece) {
		Espece = espece;
	}

	public Races(String race, String espece) {
		super();
		Race = race;
		Espece = espece;
	}
}
