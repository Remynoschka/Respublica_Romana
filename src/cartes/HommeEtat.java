package cartes;

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
	}
	private Senateur frereEnnemi;
	private Senateur frereAmi;
	//ID complementaire
	//Pouvoir
	
	
	
	public boolean estHommeEtat(){
		return true;
	}
}
