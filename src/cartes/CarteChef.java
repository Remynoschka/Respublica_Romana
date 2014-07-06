package cartes;

import java.util.ArrayList;

import jeu.Ere;

public class CarteChef extends Carte {
	private ArrayList<CarteGuerre>	guerresAffiliees;
	private int						desastre;
	private int						retraite;
	private int						bonusForce;

	public CarteChef(String nom, Ere ere) {
		super(nom, ere);
		// TODO Auto-generated constructor stub
	}

	// -------------------------------GETTERS &
	// SETTERS---------------------------
	public ArrayList<CarteGuerre> getGuerresAffiliees() {
		return guerresAffiliees;
	}

	public void setGuerresAffiliees(ArrayList<CarteGuerre> guerresAffiliees) {
		this.guerresAffiliees = guerresAffiliees;
	}

	public int getDesastre() {
		return desastre;
	}

	public void setDesastre(int desastre) {
		this.desastre = desastre;
	}

	public int getRetraite() {
		return retraite;
	}

	public void setRetraite(int retraite) {
		this.retraite = retraite;
	}

	public int getBonusForce() {
		return bonusForce;
	}

	public void setBonusForce(int bonusForce) {
		this.bonusForce = bonusForce;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cartes.Carte#pioche()
	 */
	@Override
	public void pioche() {
		// TODO carte chef piochee
	}
}
