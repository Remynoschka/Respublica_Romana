package jeu;

import java.util.ArrayList;

import cartes.Senateur;

/**
 * Classe qui definit une armee lors d'un combat
 * 
 * @author Remynoschka
 * 
 */
public class Armee {
	private ArrayList<Legion>	legions;
	private ArrayList<Flotte>	flottes;
	private Senateur			chef;

	// ---------------------------------------------------------------
	public Armee(Senateur senateur, ArrayList<Legion> legions,
			ArrayList<Flotte> flottes) {
		chef = senateur;
		this.legions = legions;
		this.flottes = flottes;
		senateur.ajouterArmee(this);
	}

	public ArrayList<Legion> getLegions() {
		return legions;
	}

	public ArrayList<Flotte> getFlottes() {
		return flottes;
	}

	public Senateur getChef() {
		return chef;
	}

	public boolean estRebelle() {
		return chef.estRebelle();
	}

	public String toString() {
		return new String("Senateur : " + chef.getNom() + " \n Legions : "
				+ legions + "\n Flottes : " + flottes);
	}
}
