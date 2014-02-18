package jeu;

import java.util.ArrayList;
import java.util.List;

import joueurs.Joueur;

public class Partie {
	public static Partie PARTIE_EN_COURS;

	private List<Joueur> joueurs;

	private Partie(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	private Partie() {
		joueurs = new ArrayList<Joueur>();

	}

	public static Partie nouvellePartie() {
		if (PARTIE_EN_COURS == null)
			PARTIE_EN_COURS = new Partie();
		return PARTIE_EN_COURS;
	}

	public static Partie nouvellePartie(List<Joueur> joueurs) {
		if (PARTIE_EN_COURS == null)
			PARTIE_EN_COURS = new Partie(joueurs);
		return PARTIE_EN_COURS;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}
}
