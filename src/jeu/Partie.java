package jeu;

import java.util.ArrayList;
import java.util.List;

import plateau.Rome;

import joueurs.Joueur;
import cartes.Senateur;
import cartes.TasCartes;
import evenements.Evenement;

public class Partie {
	public static Partie PARTIE_EN_COURS;
	public static final int LIMITE_JOUEURS = 6;
	private TasCartes tas;
	private Ere ereActuelle;
	private List<Joueur> joueurs;
	private List<Evenement> eventsActifs;

	private Partie(Ere ere, List<Joueur> joueurs) {
		this.joueurs = joueurs;
		construct(ere);
	}

	private Partie(Ere ere) {
		joueurs = new ArrayList<Joueur>();
		construct(ere);

	}

	/**
	 * @param ere
	 */
	private void construct(Ere ere) {
		eventsActifs = new ArrayList<Evenement>();
		tas = new TasCartes(ere);
		ereActuelle = ere; // TODO modifier l'ere actuelle
	}

	/**
	 * Configure et creer une nouvelle partie
	 * 
	 * @param ere
	 *            : l'ere utilisee pour la partie
	 * @return la partie cree
	 */
	public static Partie nouvellePartie(Ere ere) {
		if (PARTIE_EN_COURS == null)
			PARTIE_EN_COURS = new Partie(ere);
		return PARTIE_EN_COURS;
	}

	/**
	 * Configure et creer une nouvelle partie
	 * 
	 * @param ere
	 *            : l'ere utilisee pour la partie
	 * @param joueurs
	 *            : les joueurs appartenant a la partie
	 * @return
	 */
	public static Partie nouvellePartie(Ere ere, List<Joueur> joueurs) {
		if (PARTIE_EN_COURS == null)
			PARTIE_EN_COURS = new Partie(ere, joueurs);
		return PARTIE_EN_COURS;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public TasCartes getTasCartes() {
		return tas;
	}

	public List<Evenement> getEvenementsActifs() {
		return eventsActifs;
	}

	/**
	 * Joue la phase de mortalite
	 */
	public void phaseMortalite() {
		PhaseMortalite.INSTANCE.jouer();
	}

	/**
	 * Joue la phase de revenu
	 */
	public void phaseRevenus() {
		PhaseRevenu.INSTANCE.jouer();
	}

	/**
	 * Joue la phase de forum
	 */
	public void phaseForum() {
		PhaseForum.INSTANCE.jouer();
	}

	/**
	 * 
	 * @return le joueur possedant le Senateur de Plus Haut Rang
	 */
	public Joueur getJoueurSPHR() {
		for (Senateur s : Rome.INSTANCE.getSenateursAvecTitre().values()) {
			if (s.estARome()) {
				return s.getJoueur();
			}
		}
		return null;
	}

	/**
	 * 
	 * @return le Senateur de Plus Haut Rang
	 */
	public Senateur getSPHR() {
		for (Senateur s : Rome.INSTANCE.getSenateursAvecTitre().values()) {
			if (s.estARome()) {
				return s;
			}
		}
		return null;
	}

	public Ere getEreActuelle() {
		return ereActuelle;
	}
}
