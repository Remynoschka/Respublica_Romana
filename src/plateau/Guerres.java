package plateau;

import java.util.ArrayList;

import cartes.CarteGuerre;

public class Guerres {
	private ArrayList<CarteGuerre>	guerresInactives;		// les guerres
															// inactives
	private ArrayList<CarteGuerre>	guerresImminentes;		// guerres
															// imminentes
	private ArrayList<CarteGuerre>	guerresNonEntreprises;	// guerres non
															// entreprises
	private ArrayList<CarteGuerre>	guerresActives;		// guerres actives

	public Guerres() {
		guerresInactives = new ArrayList<CarteGuerre>();
		guerresImminentes = new ArrayList<CarteGuerre>();
		guerresNonEntreprises = new ArrayList<CarteGuerre>();
		guerresActives = new ArrayList<CarteGuerre>();
	}

	// ------------------------------------------------------------------------
	public ArrayList<CarteGuerre> getGuerresActives() {
		return guerresActives;
	}

	public ArrayList<CarteGuerre> getGuerresInactives() {
		return guerresInactives;
	}

	public ArrayList<CarteGuerre> getGuerresImminentes() {
		return guerresImminentes;
	}

	public ArrayList<CarteGuerre> getGuerresNonEntreprises() {
		return guerresNonEntreprises;
	}

	// ------------------------------------------------------------------------
	public int getDettes() {
		return (guerresActives.size() + guerresNonEntreprises.size()) * 20;
	}
}
