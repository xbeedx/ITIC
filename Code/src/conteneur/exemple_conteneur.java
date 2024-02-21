package conteneur;

import testEtat.Conteneur;

public class exemple_conteneur {

	public static void main(String[] args) {

		Conteneur C;
		Object A1, A2, A3, A4, A5, B1, B2, B3, B4, B5;

		try{

			C = new Conteneur(5);
			A1 = new Object();
			A2 = new Object();
			A3 = new Object();
			A4 = new Object();
			A5 = new Object();
			B1 = new Object();
			B2 = new Object();
			B3 = new Object();
			B4 = new Object();
			B5 = new Object();
			
			C.ajouter(A1, B1);
			C.ajouter(A2, B2);
			C.ajouter(A3, B3);
			C.ajouter(A4, B4);
			C.ajouter(A5, B5);
			
			System.out.println("conteneur est plein ? : " + (C.taille() == C.capacite()));
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
