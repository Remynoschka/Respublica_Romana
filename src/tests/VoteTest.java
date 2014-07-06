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
		Partie.nouvellePartie(Ere.HAUTE_REPUBLIQUE);
		Joueur jp = new Joueur(1, "JP", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(jp);
		Joueur dudu = new Joueur(2, "Dudu", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(dudu);
		Joueur djeff = new Joueur(3, "Djeff", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(djeff);
		Joueur cedric = new Joueur(4, "Cedric", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(cedric);
		Joueur panpan = new Joueur(5, "Panpan", null, null);
		Partie.PARTIE_EN_COURS.getJoueurs().add(panpan);
		jp.addSenateur(new Senateur("4", "Cesar", Ere.HAUTE_REPUBLIQUE, 3));
		cedric.addSenateur(new Senateur("18", "Scipion", Ere.HAUTE_REPUBLIQUE,
				2));
		jp.addSenateur(new Senateur("1", "Asterix", Ere.HAUTE_REPUBLIQUE, 1));
		dudu.addSenateur(new Senateur("2", "Obelix", Ere.HAUTE_REPUBLIQUE, 4));
		panpan.addSenateur(new Senateur("16", "Aurelius", Ere.HAUTE_REPUBLIQUE,
				3));
		djeff.addSenateur(new Senateur("11", "Lucius", Ere.HAUTE_REPUBLIQUE, 2));

		if (Vote.lancerVote()) {
			System.out.println("Loi passee");
		} else {
			System.out.println("Loi refusee");
		}
	}
}
