package jeu;

import plateau.Rome;
import cartes.CarteGuerre;
import cartes.Senateur;
import exception.NbDeException;

public class Province {
	private String nom;

	private int forceT;
	private int forceM;

	private int armee;
	private int escadres;

	private int mandat;

	private boolean developpe;
	private Senateur gouverneur;

	private int deSpoilNormal; // nb de de
	private int deSpoilDev; // nb de de
	private int bonusSpoilNormal;
	private int bonusSpoilDev;

	private boolean spoliee;

	private int deEtatNormal; // nb de de
	private int deEtatDev; // nb de de
	private int bonusEtatNormal;
	private int bonusEtatDev;

	private CarteGuerre guerreCreatrice;

	// ----
	private int impotsLocaux;
	private boolean frontalier;

	// ------------------------------------------------------------------------

	public Province(String nom, CarteGuerre guerre, int forceT, int forceM,
			int deEN, int deED, int deSN, int deSD, int bEN, int bED, int bSN,
			int bSD) {
		this.nom = nom;
		guerreCreatrice = guerre;
		deSpoilNormal = deSN;
		deSpoilDev = deSD;
		bonusSpoilNormal = bSN;
		bonusSpoilDev = bSD;

		deEtatNormal = deEN;
		deEtatDev = deED;
		bonusEtatNormal = bEN;
		bonusEtatDev = bED;

		this.forceT = forceT;
		this.forceM = forceM;
	}

	// ------------------------------------------------------------------------
	/**
	 * En phase de revenu : fait une spoliation de la province
	 * 
	 * @return les revenus de la province
	 */
	public int spoliation() {
		int revenu = 0;
		try {
			if (!developpe)
				revenu = De.jet(deSpoilNormal) + bonusSpoilNormal;
			else
				revenu = De.jet(deSpoilDev) + bonusSpoilDev;
		} catch (NbDeException e) {
			e.printStackTrace();
		}
		revenu -= De.getMauvaisPresage();
		if (revenu < 0)
			Rome.INSTANCE.retirerArgent(-revenu);
		else
			gouverneur.ajouterTalents(revenu);
		gouverneur.setCorrompu();
		spoliee = true;
		return revenu;
	}

	/**
	 * En phase de revenu : revenus de l'Etat
	 * 
	 * @return les revenus de la province
	 */
	public int revenusEtat() {
		int revenu = 0;
		if (gouverneur != null) {
			try {
				if (!developpe)
					revenu = De.jet(deEtatNormal) + bonusEtatNormal;
				else
					revenu = De.jet(deEtatDev) + bonusEtatDev;
			} catch (NbDeException e) {
				e.printStackTrace();
			}
			revenu -= De.getMauvaisPresage();
			if (revenu < 0)
				Rome.INSTANCE.retirerArgent(-revenu);
			else
				Rome.INSTANCE.ajouterArgent(revenu);
		}
		return revenu;
	}

	/**
	 * En phase de revenu : tentative de developpement de la province
	 * 
	 * @return true si la province a ete developpee
	 */
	public boolean developper() {
		if (gouverneur != null) {
			if (!gouverneur.estRebelle()) {
				int resultDe;
				try {
					resultDe = De.jet(1);
					resultDe -= De.getMauvaisPresage();

					if (!gouverneur.estCorrompu())
						resultDe++;
					if (resultDe >= 6) {
						developpe = true;
						gouverneur.modifierInfluence(3);
					}
				} catch (NbDeException e) {
					e.printStackTrace();
				}
			}
		}
		return developpe;
	}

	/**
	 * Assigner un gouverneur a la province
	 * 
	 * @param gouverneur
	 *            : le Senateur gouverneur assigne
	 */
	public void assignerGouverneur(Senateur gouverneur) {
		this.gouverneur = gouverneur;
		this.gouverneur.assignerProvince(this);
	}

	/**
	 * Fait la phase de retour du gouverneur
	 * 
	 */
	public void retourGouverneur() {
		if (mandat > 1) {
			mandat--;
		} else {
			gouverneur.retourRome();
			gouverneur = null;
		}
	}

	// ------------------------------------------------------------------------
	public String getNom() {
		return nom;
	}

	public Senateur getGouverneur() {
		return this.gouverneur;
	}

	public boolean estDeveloppe() {
		return developpe;
	}

	public int getDureeMandatRestant() {
		return mandat;
	}
}
