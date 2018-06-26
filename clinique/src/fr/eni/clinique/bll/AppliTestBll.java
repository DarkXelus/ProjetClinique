package fr.eni.clinique.bll;

public class AppliTestBll {
	public static void main(String[] args) {
		LoginManager lm = new LoginManager();
		String test = lm.Login("BOSAPIN","AniForm");
		System.out.println(test);
	}
}
