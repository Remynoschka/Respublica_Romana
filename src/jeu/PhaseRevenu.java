/**
 * 
 */
package jeu;

import plateau.Rome;
import cartes.Senateur;
import joueurs.Joueur;

/**
 * @author Remynoschka
 * 
 */
public class PhaseRevenu implements PhaseJeu {
	public static final PhaseRevenu INSTANCE = new PhaseRevenu();

	private PhaseRevenu() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jeu.PhaseJeu#jouer()
	 */
	@Override
	public void jouer() {
		// revenus des senateurs
		for (Joueur j : Partie.PARTIE_EN_COURS.getJoueurs()) {
			for (Senateur s : j.getSenateurs()) {
				s.revenus();
			}
		}
		// developpement des provinces
		for (Province p : Rome.INSTANCE.getProvinces()) {
			p.developper();
		}
		// revenus de l'etat
		Rome.INSTANCE.revenus();
		// dettes de l'etat
		Rome.INSTANCE.dettes();
		// retour des gouverneur
		for (Province p : Rome.INSTANCE.getProvinces()) {
			p.retourGouverneur();
		}

	}

}
