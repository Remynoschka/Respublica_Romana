package jeu;

import cartes.Senateur;

/**
 * Classe pour definir une legion
 * 
 * @author Remynoschka
 * 
 */
public class Legion {
	private int numLegion;
	private boolean veteran;
	private Senateur allegence; // le senateur qui controle cette legion

	public Legion(int num) {
		numLegion = num;
		veteran = false;
		allegence = null;
	}

	/**
	 * 
	 * @return true si la legion est une legion de veterans
	 */
	public boolean estVeteran() {
		return veteran;
	}

	/**
	 * @return true si la legion a voue allegence a un senateur
	 */
	public boolean estControlee() {
		if (allegence == null) {
			return false;
		} else
			return true;
	}
	/**
	 * La legion ne voues plus allegence a un senateur
	 */
	public void perdAllegence(){		
		this.allegence = null;
	}

	public int getNumLegion() {
		return numLegion;
	}

	public String toString() {
		return new String("L" + numLegion);
	}
}
