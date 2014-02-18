package cartes;

import java.util.ArrayList;

import jeu.Ere;

public class CarteChef extends Carte {
	public CarteChef(String nom, Ere ere) {
		super(nom, ere);
		// TODO Auto-generated constructor stub
	}
	private ArrayList<CarteGuerre> guerresAffiliees;
	private int desastre;
	private int retraite;
	private int bonusForce;
}
