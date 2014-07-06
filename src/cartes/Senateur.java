package cartes;

import java.util.ArrayList;
import java.util.Scanner;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import plateau.Rome;
import titres.Titre;
import vote.Abstention;
import vote.Non;
import vote.Oui;
import vote.ResultatVote;
import main.Main;
import exception.ChoixIncorrectException;
import exception.NbDeException;
import exception.SenateurDejaOccupeException;
import exception.TalentsInsuffisantException;
import jeu.Armee;
import jeu.De;
import jeu.Ere;
import jeu.Legion;
import jeu.Province;
import joueurs.Joueur;

/**
 * Classe definissant un senateur
 * 
 * @author Remynoschka
 * 
 */
public class Senateur extends Carte {
	public static final int			JEUX_ESCLAVE		= 0;
	public static final int			JEUX_CHARS			= 1;
	public static final int			JEUX_GLADIATEURS	= 2;

	protected String				id_senateur;
	protected Joueur				joueur;					// le joueur qui
																// possede ce
																// senateur

	protected boolean				aligne;
	protected boolean				rebelle;
	protected boolean				prisonnier;

	protected int					militaire;
	protected int					eloquance;
	protected int					loyaute;

	protected int					popularite;
	protected int					influence;
	protected int					influenceDepart;
	protected int					chevaliers;

	protected int					talents;					// le tresor
																// personnel du
																// senateur

	protected ArrayList<Concession>	concessions;				// les
																// concessions
																// du senateur
	protected ArrayList<Legion>		veterans;					// les legions
																// ayant jure
																// allegence au
																// senateur

	protected boolean				corrompu;
	protected boolean				majeur;
	protected boolean				ancienConsul;
	protected boolean				chefFaction;

	protected boolean				estEscorte;				// possede une
																// escorde
																// officiele
	protected boolean				aRome;						// le senateur
																// est a Rome ou
																// pas
	protected Titre					titre;						// le titre du
																// senateur
	protected Province				province;					// la province
																// du senateur

	protected Armee					armee;						// l'armee du
																// senateur

	protected Image					image;						// Sa photo

	public Senateur(String id, String nom, Ere ere, int eloquance) {
		super(nom, ere);
		this.eloquance = eloquance;
		this.id_senateur = id;
		try {
			this.image = new Image("./data/images/senateurs/" + id_senateur
					+ ".png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------------------
	/**
	 * @return vrai si le senateur est chef de faction
	 */
	public boolean estChefFaction() {
		return chefFaction;
	}

	public void perdreChefFaction() {
		chefFaction = false;
	}

	public void devientChefFaction() {
		chefFaction = true;
	}

	// -------------------------------------------------------------------
	/**
	 * Assigne une armee au senateur
	 * 
	 * @param armee
	 *            : l'armee a assigner au senateur
	 */
	public void ajouterArmee(Armee armee) {
		this.armee = armee;
	}

	// ------------------------------------------------------------------------
	/**
	 * Transfert des talents du senateur vers un autre
	 * 
	 * @param nb
	 *            : le nombre de talents a transferer
	 * @param senateur
	 *            : le senateur cible
	 * @return la quantite de talents restante au senateur
	 * @throws TalentsInsuffisantException
	 */
	public int transfertTalents(int nb, Senateur senateur)
			throws TalentsInsuffisantException {
		if (talents - nb < 0) {
			throw new TalentsInsuffisantException();
		} else {
			retirerTalents(nb);
			senateur.ajouterTalents(nb);
		}
		return talents;
	}

	/**
	 * Retire un nombre de talents au senateur
	 * 
	 * @param nb
	 *            : le nombre de talents
	 * @return la quantite de talents restante
	 */
	public int retirerTalents(int nb) {
		talents -= nb;
		return talents;
	}

	/**
	 * Ajoute un nombre de talents au senateur
	 * 
	 * @param nb
	 *            : le nombre de talents
	 * @return la nouvelle quantite de talents
	 */
	public int ajouterTalents(int nb) {
		talents += nb;
		return talents;
	}

	/**
	 * Transfert des talents du senateur vers le coffre de faction
	 * 
	 * @param nb
	 *            : le nombre de talents a transferer
	 * @return le nombre de talents restant au senateur
	 * @throws TalentsInsuffisantException
	 */
	public int transfererCoffreFaction(int nb)
			throws TalentsInsuffisantException {
		if (talents - nb < 0)
			throw new TalentsInsuffisantException();
		else {
			talents -= nb;
			joueur.ajouterArgentCoffre(nb);
		}
		return talents;
	}

	/**
	 * Methode pour la contribution du senateur a l'Etat
	 * 
	 * @param nb
	 *            : le nombre de talents a donner
	 * @return le nombre de talents restants
	 * @throws TalentsInsuffisantException
	 */
	public int contribution(int nb) throws TalentsInsuffisantException {
		if (talents < nb)
			throw new TalentsInsuffisantException();
		else {
			talents -= nb;
			Rome.INSTANCE.ajouterArgent(nb);
			if (nb >= 50)
				influence += 7;
			else if (nb >= 25)
				influence += 3;
			else if (nb >= 10)
				influence++;
		}
		return talents;
	}

	// ------------------------------------------------------------------------

	public int revenus() {
		if (!rebelle && !prisonnier && aligne) {
			int revenus = 0;
			// revenus de base
			if (chefFaction)
				revenus += 3;
			else
				revenus += 1;
			// chevaliers
			revenus += chevaliers;
			// concession
			// TODO revenus concessions
			// spolier province
			if (province != null) {
				if (Main.debug) {
					System.out.println("Spolier la province  "
							+ province.getNom() + " ? 1 : oui, 0 : non");
					if (Main.scanDebug.nextInt() == 1) {
						revenus += province.spoliation();
					}
				}
			}
			// entretien rebelles
			// TODO entretient rebelles
			// developper province
			if (province != null) {
				province.developper();
			}
			if (Main.debug)
				System.out.println("Revenus du senateur " + nom + " : "
						+ revenus);
		}
		return talents;
	}

	// ------------------------------------------------------------------------
	/**
	 * Methode pour attirer une chevalier
	 * 
	 * @param talents
	 *            : le nombre de talents depenses
	 * @return le nouveau nombre de chevaliers
	 */
	public int attirerChevalier(int talents) {
		int valeur = talents;
		try {
			valeur += De.jet(1);
			valeur -= De.getMauvaisPresage();
			if (Main.debug)
				System.out.println("Valeur : " + valeur);
		} catch (NbDeException e) {
			return chevaliers;
		}
		if (valeur >= 6)
			chevaliers++;
		return chevaliers;
	}

	/**
	 * Methodes qui permet a un senateur d'abuser de ses chevaliers pour avoir
	 * des talents. Il perds ses chevaliers.
	 * 
	 * @param nbChevaliers
	 *            : le nombre de chevaliers sacrifies
	 * @return le nouveau solde de talents du senateur
	 */
	public int abuserChevalier(int nbChevaliers) {
		if (nbChevaliers <= chevaliers) {
			try {
				int revenus = 0;
				for (int i = 0; i < nbChevaliers; i++) {
					revenus += De.jet(1);
					revenus -= De.getMauvaisPresage();
				}
				if (revenus < 0)
					revenus = 0;
				chevaliers -= nbChevaliers;
				talents += revenus;
				if (Main.debug)
					System.out.println("Revenus de l'abus de chevaliers : "
							+ revenus);
			} catch (NbDeException e) {
				return talents;
			}
		}
		return talents;
	}

	// ------------------------------------------------------------------------
	/**
	 * Methode qui permet d'organiser des jeux du cirque par le senateur.
	 * 
	 * @param type
	 *            : le type de jeux
	 * @return la nouvelle popularite du senateur
	 * @throws ChoixIncorrectException
	 *             si le type de jeux est incorrect
	 */
	public int organiserJeux(int type) throws ChoixIncorrectException {
		if (type == JEUX_ESCLAVE) {
			if (talents < 7)
				System.out.println("Talents insuffisants.");
			else {
				talents -= 7;
				popularite++;
				Rome.INSTANCE.modifierMecontentement(-1);
			}
		}
		if (type == JEUX_CHARS) {
			if (talents < 13)
				System.out.println("Talents insuffisants.");
			else {
				talents -= 13;
				popularite += 2;
				Rome.INSTANCE.modifierMecontentement(-2);
			}
		}
		if (type == JEUX_GLADIATEURS) {
			if (talents < 18)
				System.out.println("Talents insuffisants.");
			else {
				talents -= 18;
				popularite += 3;
				Rome.INSTANCE.modifierMecontentement(-3);
			}
		} else {
			throw new ChoixIncorrectException();
		}
		return popularite;
	}

	// ------------------------------------------------------------------------
	/**
	 * Attribue un titre au senateur
	 * 
	 * @param titre
	 *            : le titre que l'on va attribuer au senateur
	 * @throws SenateurDejaOccupeException
	 */

	public void attribuerTitre(Titre titre) throws SenateurDejaOccupeException {
		if (this.titre == null) {
			this.titre = titre;
			modifierInfluence(titre.getBonusInfluence());
			Rome.INSTANCE.getSenateursAvecTitre().put(titre.getRangTitre(),
					this);
		} else {
			throw new SenateurDejaOccupeException();
		}
	}

	/**
	 * Retire le titre du senateur
	 */
	public void retirerTitre() {
		this.titre = null;
		Rome.INSTANCE.getSenateursAvecTitre().remove(this);
	}

	public Titre getTitre() {
		return this.titre;
	}

	// ------------------------------------------------------------------------
	public ResultatVote vote() {
		if (Main.debug) {
			System.out.println("0 : Abstention, 1 : Oui, 2 : Non");
			int result = new Scanner(System.in).nextInt();
			switch (result) {
				case 0:

					return new Abstention(this);
				case 1:

					return new Oui(this);
				case 2:

					return new Non(this);
				default:
					return new Abstention(this);
			}
		}
		return null;
	}

	public int getVoix() {
		int achat = 0;
		while (achat <= talents && talents != 0) {
			System.out.println("Acheter des voix ? 1 : Oui, Autre : Non");
			if (new Scanner(System.in).nextInt() == 1) {

				System.out.println("Combien");
				achat = new Scanner(System.in).nextInt();

			}
		}
		retirerTalents(achat);
		return eloquance + chevaliers + achat;
	}

	// ------------------------------------------------------------------------
	public int modifierInfluence(int nb) {
		influence += nb;
		return influence;
	}

	// ------------------------------------------------------------------------
	public void desassignerArmee() {
		armee = null;
	}

	// ------------------------------------------------------------------------
	public void assignerProvince(Province province) {
		this.aRome = false;
		this.province = province;
	}

	public void retourRome() {
		this.aRome = true;
		this.province = null;
	}

	public boolean estARome() {
		return aRome;
	}

	// ------------------------------------------------------------------------
	/**
	 * Tue le senateur
	 */
	public void tuer() {
		if (!chefFaction) {
			this.joueur.perdSenateur(this);
			this.joueur = null;
			this.aligne = false;
		}
		this.ancienConsul = false;
		this.influence = influenceDepart;
		this.popularite = 0;
		this.chevaliers = 0;
		this.corrompu = false;
		this.majeur = false;
		this.aRome = true;
		this.prisonnier = false;
		this.talents = 0;
		Rome.INSTANCE.getArmees().retourArmee(armee);
		for (Legion l : veterans) {
			l.perdAllegence();
		}
		this.veterans = new ArrayList<Legion>();
		// TODO rendre les concessions
		// TODO rendre titre
		// TODO rendre province
		// TODO ...
	}

	/**
	 * Le senateur assassine un autre senateur
	 * 
	 * @param victime
	 *            : le senateur victime
	 * @return true si l'assasinat est reussis.
	 */
	public boolean assassiner(Senateur victime) {
		try {

			int result = De.jet(1);
			if (victime.estEscorte()) {
				result--;
			}
			// TODO bonus assassin + table à gerer + escorte + echec(proces)

		} catch (NbDeException e) {

		}
		return false;
	}

	/**
	 * 
	 * @return true si le senateur possede une escorte officiele
	 */
	public boolean estEscorte() {
		return estEscorte;
	}

	// ------------------------------------------------------------------------

	public Joueur getJoueur() {
		return joueur;
	}

	public void setCorrompu() {
		corrompu = true;
	}

	public void perdCorrompu() {
		corrompu = false;
	}

	public boolean estCorrompu() {
		return corrompu;
	}

	public boolean estRebelle() {
		return rebelle;
	}

	public Armee getArmee() {
		return armee;
	}

	public String getNom() {
		return nom;
	}

	public String getIDSenateur() {
		return id_senateur;
	}

	public int getValeurMilitaire() {
		return militaire;
	}

	public int getEloquance() {
		return eloquance;
	}

	public int getLoyaute() {
		return loyaute;
	}

	public int getPopularite() {
		return popularite;
	}

	public int getTalents() {
		return talents;
	}

	public int getNbChevaliers() {
		return chevaliers;
	}

	public int getInfluence() {
		return this.influence;
	}

	public Image getImage() {
		return this.image;
	}

	/**
	 * Modifie la valeur de popularite du senateur
	 * 
	 * @param val
	 *            : la valeur de popularite a ajouter (+/-)
	 * @return la nouvelle valeur de popularite
	 */
	public int modifiePopularite(int val) {
		popularite += val;
		return popularite;
	}

	public boolean estAncienConsul() {
		return ancienConsul;
	}

	public void setAncienConsul() {
		ancienConsul = true;
	}

	public void perdAncienConsul() {
		ancienConsul = false;
	}

	public boolean estMajeur() {
		return majeur;
	}

	public void setMajeur() {
		majeur = true;
	}

	public void perdMajeur() {
		majeur = false;
	}

	public boolean estHommeEtat() {
		return false;
	}

	// ------------------------------------------------------------------------

	public String toString() {
		return new String("SENATEUR\nNom : " + nom + "\nID :" + id_senateur
				+ "\n Talents : " + talents + "\n Titre : " + titre.getNom()
				+ "\n Militaire : " + militaire + "\n Eloquance : " + eloquance
				+ "\n Loyaute : " + loyaute + "\n Influence : " + influence
				+ "\n Chevaliers : " + chevaliers + "\n Popularite :"
				+ popularite);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cartes.Carte#pioche()
	 */
	@Override
	public void pioche() {
		// TODO envoyer la carte au forum

	}
};
