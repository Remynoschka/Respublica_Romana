/**
 * 
 */
package jeu;

import cartes.Senateur;

/**
 * Simule la phase de senat
 * 
 * @author Remynoschka
 * 
 */
public class PhaseSenat implements PhaseJeu {
	public static final PhaseSenat INSTANCE = new PhaseSenat();
	private Senateur presidentSeance;

	private PhaseSenat() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jeu.PhaseJeu#jouer()
	 */
	@Override
	public void jouer() {
		// TODO jouer phase senat
	}

	/**
	 * Change le president de seance
	 * 
	 * @param newPresident
	 *            : le nouveau president de seance
	 * @return l'ancien president de seance
	 */
	public Senateur changerPresident(Senateur newPresident) {
		Senateur old = presidentSeance;
		presidentSeance = newPresident;
		return old;

	}

}
