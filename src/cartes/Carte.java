package cartes;

import jeu.Ere;
import joueurs.Joueur;

public abstract class Carte {

	protected String nom;
	protected int num; // ID de la carte
	protected Joueur joueur; // Le joueur qui possede la carte
	protected Ere ere; // l'ere de la carte

	// ------------------------------------------------------------------------
	public Carte(String nom, Ere ere) {
		this.nom = nom;
		this.ere = ere;
	}

	// ------------------------------------------------------------------------
	public void defausser() {
		// TODO defausser la carte
	}

	// ------------------------------------------------------------------------
	public Ere getEre() {
		return ere;
	}

	public int getID() {
		return num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		return ((Carte) arg0).getID() == this.getID();
	}

	/**
	 * Methode appliquee quand la carte est piochee. Definit si elle va sur le
	 * plateau ou dans la main du joueur
	 */
	public abstract void pioche();

}
