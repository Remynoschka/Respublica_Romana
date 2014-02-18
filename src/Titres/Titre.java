package Titres;

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
	
	public Titre(String nom, int rang, int bonus){
		this.nom = nom;
		importance = rang;
		bonusInfluence = bonus;
	}
	
	public String getNom(){
		return nom;
	}
	
	public int getBonusInfluence(){
		return bonusInfluence;
	}
	
	public int getRangTitre(){
		return importance;
	}
	
	public abstract Action getAction();
}
