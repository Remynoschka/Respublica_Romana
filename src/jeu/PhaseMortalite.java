/**
 * 
 */
package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import joueurs.Joueur;
import main.Main;
import cartes.Senateur;

/**
 * 
 * Classe simulant la phase de mortalite
 * 
 * @author Remynoschka
 * 
 */
public class PhaseMortalite implements PhaseJeu {
	public static final PhaseMortalite INSTANCE = new PhaseMortalite();
	private static final int VALEUR_X2 = -1;
	private static final int VALEUR_NUL = 0;
	private List<Integer> tokens;

	private PhaseMortalite() {
		tokens = new ArrayList<Integer>();
	}

	private void initTokens() {
		for (int i = 0; i < 30; i++) {
			tokens.add(i + 1);
		}
		tokens.add(VALEUR_NUL);
		tokens.add(VALEUR_X2);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jeu.PhaseJeu#jouer()
	 */
	@Override
	public void jouer() {
		// TODO Activer guerres imminentes
		initTokens();
		int nbPionsAPioche = 1;
		piocheJetons(nbPionsAPioche);

	}

	/**
	 * Pioche des jetons mortalite et tue les senateurs concernes
	 * 
	 * @param nbPionsAPioche
	 *            : le nombre de pions a piocher
	 */
	public void piocheJetons(int nbPionsAPioche) {
		Random alea = new Random();
		int pioche = tokens.remove(alea.nextInt(tokens.size() - 1));
		while (nbPionsAPioche != 0) {
			switch (pioche) {
			case VALEUR_X2:
				nbPionsAPioche++;
				tokens.add(pioche);
				if (Main.debug) {
					System.out.println("Mortalite/x2");
				}
				break;
			case VALEUR_NUL:
				nbPionsAPioche--;
				if (Main.debug) {
					System.out.println("Mortalite/nul");
				}
				break;
			default:
				nbPionsAPioche--;
				for (Joueur j : Partie.PARTIE_EN_COURS.getJoueurs()) {
					for (Senateur s : j.getSenateurs()) {
						if (s.getIDSenateur().startsWith("" + pioche)) {
							s.tuer();
							if (Main.debug) {
								System.out
										.println(s.getIDSenateur()
												+ " a ete tue lors de la phase de mortalite");
							}
						}
					}
				}
				break;
			}
		}
	}

}
