package vote;

import java.util.Iterator;

import cartes.Senateur;

import jeu.Partie;
import joueurs.Joueur;

public class Vote {

	/**
	 * Lance un vote.
	 * 
	 * @return un boolean indiquant si le vote a �t� r�ussis ou pas.
	 */
	public static boolean lancerVote() {
		int compteur = 0; // Ce compteur sers � compter les voix
		Iterator<Joueur> iterator = Partie.PARTIE_EN_COURS.getJoueurs()
				.iterator();
		while (iterator.hasNext()) {
			Joueur joueur = iterator.next();
			Iterator<Senateur> senateurs = joueur.getSenateurs().iterator();
			int voix = 0;
			while (senateurs.hasNext()) {
				voix += senateurs.next().vote().getValue();
			}
			System.out.println(joueur.getNom() + " a vot� pour " + voix);
			compteur += voix;
		}

		return compteur > 0;
	}
}
