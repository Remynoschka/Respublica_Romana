package titres;

import main.Jeu;

import org.newdawn.slick.SlickException;

import panels.IconeTitre;
import Actions.Action;

/**
 * Classe qui definit les differents titres du senat
 * 
 * @author Remynoschka
 * 
 */
public abstract class Titre {

	private String nom; // le nom du titre
	private int importance; // le numero d'importance du titre
	private int bonusInfluence; // le bonus d'influence que donne le titre
	private String[] descriptif; // Texte descriptif du titre
	private IconeTitre ihm; // L'element d'ihm correspondant au titre

	protected Titre(String nom, int rang, int bonus, String[] descriptif, int w, int h) {
		this.nom = nom;
		importance = rang;
		bonusInfluence = bonus;
		this.descriptif = descriptif;
		try {
			ihm = new IconeTitre(Jeu.INSTANCE.getContainer(), this, w, h);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public String getNom() {
		return nom;
	}

	public int getBonusInfluence() {
		return bonusInfluence;
	}

	public int getRangTitre() {
		return importance;
	}

	public String[] getDescription() {
		return descriptif;
	}

	public abstract Action getAction();

	public String toString() {
		return this.nom + "/+" + bonusInfluence + "/" + importance;
	}

	// ///////////////////////// IHM ///////////////////////////////////////////

	/**
	 * 
	 * @return l'element d'ihm correspondant a ce titre
	 */
	public IconeTitre getIcon() {
		return ihm;
	}


}
