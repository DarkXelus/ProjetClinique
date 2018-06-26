package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Personnels;

public class AppliTestBll {
	public static void main(String[] args) {
		
		LoginManager lm = new LoginManager();
		String test = lm.Login("BOSAPIN","AniForm");
		System.out.println(test);

		PersonnelsManager pm = new PersonnelsManager();
		List<Personnels> lstPersonnels = new ArrayList<Personnels>();
		
		Personnels perso;
		//try {
			/*perso = new Personnels("AIMON","AniForm","VET",false);
			pm.Create(perso);*/
			lstPersonnels = pm.SelectAll();
			
			for (Personnels personnels : lstPersonnels) {
				System.out.println(personnels.toString());
			}
			
		/*} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
