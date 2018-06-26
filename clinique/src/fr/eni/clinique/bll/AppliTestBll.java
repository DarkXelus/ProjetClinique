package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Personnels;

public class AppliTestBll {
	public static void main(String[] args) {

		LoginManager lm = new LoginManager();
		String test;
		try {
<<<<<<< HEAD
			test = lm.Login("BOSAPIN","AniForm");
		System.out.println(test);
=======
			test = lm.Login("BOSAPIN", "AniForm");
			System.out.println(test);
>>>>>>> 27a5d24a1f211f5e0596509401868d1ebfbc1d82
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
<<<<<<< HEAD
=======
		
>>>>>>> 27a5d24a1f211f5e0596509401868d1ebfbc1d82

		PersonnelsManager pm = new PersonnelsManager();
		List<Personnels> lstPersonnels = new ArrayList<Personnels>();

		Personnels perso;
		try {
			perso = new Personnels("TOURNE", "AniForm", "VET", false);
			pm.Create(perso);
			lstPersonnels = pm.SelectAll();

			for (Personnels personnels : lstPersonnels) {
				System.out.println(personnels.toString());
			}

		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
