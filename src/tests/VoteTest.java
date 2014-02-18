package tests;

import cartes.Senateur;
import vote.Vote;
import jeu.Ere;
import jeu.Partie;
import joueurs.Joueur;

public class VoteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Partie.nouvellePartie();
		Joueur jp = new Joueur("JP", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(jp);
		Joueur dudu = new Joueur("Dudu", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(dudu);
		Joueur djeff = new Joueur("Djeff", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(djeff);
		Joueur cedric = new Joueur("Cedric", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(cedric);
		Joueur panpan = new Joueur("Panpan", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(panpan);
		jp.addSenateurs(new Senateur("4", "Cesar", Ere.HAUTE_REPUBLIQUE, 3));
		cedric.addSenateurs(new Senateur("18", "Scipion", Ere.HAUTE_REPUBLIQUE,
				2));
		jp.addSenateurs(new Senateur("1", "Asterix", Ere.HAUTE_REPUBLIQUE, 1));
		dudu.addSenateurs(new Senateur("2", "Obelix", Ere.HAUTE_REPUBLIQUE, 4));
		panpan.addSenateurs(new Senateur("16", "Aurelius",
				Ere.HAUTE_REPUBLIQUE, 3));
		djeff.addSenateurs(new Senateur("11", "Lucius", Ere.HAUTE_REPUBLIQUE, 2));

		if (Vote.lancerVote()) {
			System.out.println("Loi pass�e");
		} else {
			System.out.println("Loi refus�e");
		}
	}
}
