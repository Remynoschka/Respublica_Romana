package cartes;

import java.util.ArrayList;
import java.util.List;

import Actions.Action;
import jeu.Ere;

/**
 * Classe etendant un senateur pour ajouter les caracteristiques des Hommes
 * d'Etat
 * 
 * @author Remynoschka
 * 
 */
public class HommeEtat extends Senateur {
	public HommeEtat(String id, String nom, Ere ere, int eloquance) {
		super(id, nom, ere, eloquance);
		// TODO Auto-generated constructor stub
		frereEnnemi = new ArrayList<Senateur>();
		frereAmi = new ArrayList<Senateur>();
	}

	private List<Senateur> frereEnnemi;
	private List<Senateur> frereAmi;
	// Pouvoir
	private Action pouvoir;

	public boolean estHommeEtat() {
		return true;
	}

	public void appliquerPouvoir() {
		pouvoir.actionPerformed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cartes.Senateur#getLoyaute()
	 */
	@Override
	public int getLoyaute() {
		// Verification frere ennemi
		for (Senateur s : frereEnnemi)
			if (this.joueur.getSenateurs().contains(s)) {
				return 0;
			}
		// Verification frere ami
		for (Senateur s : frereAmi)
			if (!this.joueur.getSenateurs().contains(s)) {
				return 0;
			}
		return super.getLoyaute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cartes.Senateur#pioche()
	 */
	@Override
	public void pioche() {
		// TODO envoyer la carte dans la main du joueur en cours
	}
}
