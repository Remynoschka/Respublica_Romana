package tests;

import jeu.Ere;
import jeu.Province;
import plateau.Rome;
import cartes.Senateur;

public class AssignationProvinceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Senateur s = new Senateur("4", "Julius", Ere.HAUTE_REPUBLIQUE, 4);
		s.ajouterTalents(30);
		
		Province p = new Province("Gaule", null, 10, 2, 1, 3, 2, 1, -1, 1, -2,
				0);
		System.out.println("ASSIGNATION");
		p.assignerGouverneur(s);
		System.out.println(p.getGouverneur().getNom());
		System.out.println("SPOLIATION");
		System.out.println("avant : " + s.getTalents());
		p.spoliation();
		System.out.println("apres : " + s.getTalents());
		System.out.println("REVENUS POUR L'ETAT");
		System.out.println("avant : " + Rome.INSTANCE.getArgent());
		p.revenusEtat();
		System.out.println("apres : " + Rome.INSTANCE.getArgent());

	}
}
