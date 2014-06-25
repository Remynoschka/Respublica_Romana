package joueurs;

import java.util.ArrayList;
import java.util.List;

import jeu.De;
import jeu.Partie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import cartes.Carte;
import cartes.Senateur;
import evenements.Evenement;
import evenements.TableEvents;
import exception.NbDeException;

/**
 * Classe pour definir un joueur
 * 
 * @author Remynoschka
 * 
 */
public class Joueur {
	private int ID;
	protected String nom; // Nom du joueur
	protected int talentsCoffre; // talents dans le coffre de faction
	protected List<Senateur> senateurs; // les senateurs poses
	protected List<Carte> mainCarte; // les cartes en main
	protected Image imgFaction;
	public static final Color COLOR_DISPLAY_NAME = new Color(215, 160, 75);

	public Joueur(int ID, String nom, ArrayList<Carte> mainDepart, Image img) {
		this.ID = ID;
		this.nom = nom;
		mainCarte = mainDepart;
		senateurs = new ArrayList<Senateur>();
		this.imgFaction = img;
	}

	public Joueur(int ID,String nom, Image img) {
		this.ID = ID;
		this.nom = nom;
		mainCarte = new ArrayList<Carte>();
		senateurs = new ArrayList<Senateur>();
		this.imgFaction = img;
	}

	public Joueur() {
		this.nom = "";
		mainCarte = new ArrayList<Carte>();
		senateurs = new ArrayList<Senateur>();
		try {
			this.imgFaction = new Image(0, 0);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Joueur(String nom) {
		this.nom = nom;
		mainCarte = new ArrayList<Carte>();
		senateurs = new ArrayList<Senateur>();
//		try {
			this.imgFaction = null;
//		} catch (SlickException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	// ------------------------------------------------------------------------
	public int getArgentCoffre() {
		return talentsCoffre;
	}

	public int getNbVoix() {
		int voix = 0;
		for (Senateur s : senateurs) {
			voix += s.getEloquance();
			voix += s.getNbChevaliers();
		}
		return voix;
	}

	public boolean addSenateur(Senateur senateur) {
		// TODO modifier la methode d'ajout de senateurs en prenant en compte
		// certains parametres
		return this.senateurs.add(senateur);
	}

	public boolean perdSenateur(Senateur senateur) {
		// TODO modifier la methode d'ajout de senateurs en prenant en compte
		// certains parametres
		return this.senateurs.remove(senateur);
	}

	public List<Senateur> getSenateurs() {
		return this.senateurs;
	}

	public int ajouterArgentCoffre(int nb) {
		talentsCoffre += nb;
		return talentsCoffre;
	}

	public int retirerArgentCoffre(int nb) {
		talentsCoffre -= nb;
		return talentsCoffre;
	}

	public void designerNouveauChef(Senateur senateur) {
		if (senateurs.contains(senateur)) {
			for (Senateur chef : senateurs) {
				if (chef.estChefFaction()) {
					chef.perdreChefFaction();
				}
			}
			senateur.devientChefFaction();
		}
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setSymbole(Image symb) {
		this.imgFaction = symb;
	}

	public Image getSymbole() {
		return imgFaction;
	}

	/**
	 * Methode qui joue l'initiative du joueur
	 * 
	 * @throws NbDeException
	 */
	public void jouerInitiative() throws NbDeException {
		int de = De.jet(2) - De.getMauvaisPresage();
		if (de == 7) {
			Evenement evt = TableEvents.getEvent(
					De.jet(3) - De.getMauvaisPresage(),
					Partie.PARTIE_EN_COURS.getEreActuelle());
			evt.spawn();
			Partie.PARTIE_EN_COURS.getEvenementsActifs().add(evt);
		} else {
			// Piocher une carte
			Carte carte = Partie.PARTIE_EN_COURS.getTasCartes().piocher();
			carte.pioche();
			// Tentative persuasion

			// Attirer chevalier

			// Organiser jeux du cirque

			// Changer chef faction

		}
	}

	/**
	 * @return ID
	 */
	public int getID() {
		return ID;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
}
