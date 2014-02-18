package tests;

import jeu.Ere;
import plateau.Rome;
import cartes.Carte;
import cartes.Senateur;

public class CreationArmeeTest {
	public static void main(String[] args) {
		Rome rome = Rome.newRome(Ere.HAUTE_REPUBLIQUE);
		Senateur s = new Senateur("4", "Julius", Ere.HAUTE_REPUBLIQUE, 4);
		s.ajouterTalents(30);
		System.out.println(rome.getArgent());
		rome.getArmees().recruterLegions(5);
		rome.getArmees().assignerArmee(s);
		System.out.println(s.getArmee());
		rome.getArmees().retourArmee(s.getArmee());
		System.out.println(s.getArmee());

	}
}
