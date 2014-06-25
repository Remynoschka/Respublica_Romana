package cartes;

import jeu.Ere;
import Actions.Action;

/**
 * Classe generique pour les cartes actions
 * 
 * @author Remynoschka
 * 
 */
public abstract class CarteAction extends Carte {
	public CarteAction(String nom, Ere ere) {
		super(nom, ere);
		construct();
	}

	private Action action;

	/**
	 * @return the action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Effectue l'action
	 */
	public void effectuerAction() {
		action.actionPerformed();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cartes.Carte#pioche()
	 */
	@Override
	public void pioche() {
		// TODO ajouter la carte a la main du joueur
	}

	/**
	 * Methode qui doit servir pour declarer l'action de la carte
	 */
	protected abstract void construct();
}
