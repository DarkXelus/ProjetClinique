package fr.eni.clinique.BO;

import fr.eni.clinique.bll.BLLException;

public class AppliTestBO {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Personnels P1,P2,P3,P4;
	
		try {
			P1= new Personnels("jimmy","incorect","","MED", false) ;
		} catch (BLLException e) {
			e.printStackTrace();
		}
		try {
			P2= new Personnels("jimmy","incorect","","MED545", false) ;
		} catch (BLLException e) {
			e.printStackTrace();
		}
		try {
			P3= new Personnels("jimmy","incorect654854","","MED", false) ;
		} catch (BLLException e) {
			e.printStackTrace();
		}
		try {
			P4= new Personnels("jimmyfdsgsgfgdgdsgsgsdgffsgsfgsgsfdgsdgdfsdfg","incorect","","MED", false) ;
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
}
