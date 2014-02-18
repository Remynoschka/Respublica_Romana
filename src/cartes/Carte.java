package cartes;

import jeu.Ere;

public abstract class Carte {

	
	protected String nom;
	protected int num; //ID de la carte
	
	protected Ere ere; // l'ere de la carte
	
	
	//------------------------------------------------------------------------
	public Carte(String nom,  Ere ere){
		this.nom = nom;		
		this.ere = ere;
	}
	
	//------------------------------------------------------------------------
	public Ere getEre(){
		return ere;
	}
	
	public int getID(){
		return num;
	}
}
