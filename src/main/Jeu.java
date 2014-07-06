package main;

import ihm.ConfigMonitors;
import ihm.EcranAcceuil;
import ihm.EcranDemandeNom;
import ihm.EcranSalleAttente;
import ihm.EcranPrincipal;
import ihm.EcranRejoindrePartie;
import ihm.Fenetre;

import java.io.IOException;

import jeu.Ere;
import jeu.Partie;
import joueurs.Joueur;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.StateBasedGame;

import plateau.Rome;
import titres.Titre;
import Actions.Action;
import cartes.HommeEtat;
import cartes.Senateur;
import exception.SenateurDejaOccupeException;
import extended_components.Bouton;
import extended_components.Checkbox;

public class Jeu extends StateBasedGame {
	public static final Jeu			INSTANCE		= new Jeu();
	private Joueur					joueurMoi;
	public static UnicodeFont		FONT;
	public static UnicodeFont		LOW_FONT;
	public static final ColorEffect	COLOR_EFFECT	= new ColorEffect();

	private Jeu() {
		super("Respublica Romana");
	}

	@Override
	public void initStatesList(GameContainer fenetre) throws SlickException {
		try {
			Rome.newRome(Ere.HAUTE_REPUBLIQUE);
			Bouton.init();
			Checkbox.init();
			// Chargement de la police
			initFonts();
			// TODO Maquette init ( a retirer)
			testsLaunch();
			// Configuration d'ecran
			ConfigMonitors.getConfiguration();
			// Ajout des etats
			addState(new EcranAcceuil());
			addState(new EcranPrincipal());
			addState(new EcranRejoindrePartie());
			addState(new EcranSalleAttente());
			addState(new EcranDemandeNom());
			// Debut
			enterState(EcranAcceuil.ID);
			Fenetre.FENETRE.setShowFPS(Main.debug);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SenateurDejaOccupeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Fait des initialisations pour la maquette
	 * 
	 * @throws SlickException
	 * @throws SenateurDejaOccupeException
	 */
	private void testsLaunch() throws SlickException,
			SenateurDejaOccupeException {
		Partie.nouvellePartie(Ere.HAUTE_REPUBLIQUE);
		joueurMoi = new Joueur(1, "JP", null, new Image(
				"./data/images/symboles/factions/aigle.png"));
		Partie.PARTIE_EN_COURS.getJoueurs().add(joueurMoi);

		joueurMoi.addSenateur(new Senateur("1", "Cornelius",
				Ere.HAUTE_REPUBLIQUE, 3));
		joueurMoi.addSenateur(new Senateur("2", "Fabius", Ere.HAUTE_REPUBLIQUE,
				2));
		joueurMoi.addSenateur(new Senateur("4", "Julius", Ere.HAUTE_REPUBLIQUE,
				3));
		joueurMoi.addSenateur(new Senateur("9", "Aurelius",
				Ere.HAUTE_REPUBLIQUE, 3));
		joueurMoi.addSenateur(new HommeEtat("19a",
				"L. Aemilius Paulus Macedonicus", Ere.HAUTE_REPUBLIQUE, 4));
		joueurMoi
				.getSenateurs()
				.get(2)
				.attribuerTitre(
						new Titre("Consul de Rome", 1, 5, new String[] {
								"Président de Séance", "Elu chaque année" },
								200, 100) {

							@Override
							public Action getAction() {
								return null;
							}
						});
		Joueur djeff = new Joueur(2, "Djeff", null, new Image(
				"./data/images/symboles/factions/main.png"));
		djeff.addSenateur(new Senateur("12", "Acilius", Ere.HAUTE_REPUBLIQUE, 2));
		djeff.addSenateur(new HommeEtat("2a",
				"Q. Fabius Maximus Verrucosus Cunctator", Ere.HAUTE_REPUBLIQUE,
				2));
		Partie.PARTIE_EN_COURS.getJoueurs().add(djeff);
		Joueur upsie = new Joueur(3, "Upsie", null, new Image(
				"./data/images/symboles/factions/etoile.png"));
		Partie.PARTIE_EN_COURS.getJoueurs().add(upsie);
		Joueur panpan = new Joueur(4, "Panpan", null, new Image(
				"./data/images/symboles/factions/couronne.png"));
		Partie.PARTIE_EN_COURS.getJoueurs().add(panpan);
		Joueur cedric = new Joueur(5, "Cedric", null, new Image(
				"./data/images/symboles/factions/rond.png"));
		Partie.PARTIE_EN_COURS.getJoueurs().add(cedric);
		Joueur mout = new Joueur(6, "Mout", null, new Image(
				"./data/images/symboles/factions/Lune.png"));
		Partie.PARTIE_EN_COURS.getJoueurs().add(mout);
	}

	/**
	 * Initialise les polices de caracteres
	 * 
	 * @throws SlickException
	 */
	@SuppressWarnings("unchecked")
	private void initFonts() throws SlickException {
		FONT = new UnicodeFont("./data/fonts/times.ttf", 20, false, false);
		FONT.addAsciiGlyphs();
		FONT.addGlyphs(400, 600);
		FONT.getEffects().add(COLOR_EFFECT);
		FONT.loadGlyphs();
		// Police petite
		LOW_FONT = new UnicodeFont("./data/fonts/times.ttf", 15, false, false);
		LOW_FONT.addAsciiGlyphs();
		LOW_FONT.addGlyphs(400, 600);
		LOW_FONT.getEffects().add(Jeu.COLOR_EFFECT);
		LOW_FONT.loadGlyphs();
	}

	public void setPlayerMe(Joueur moi) {
		this.joueurMoi = moi;
	}

	public Joueur getPlayerMe() {
		return joueurMoi;
	}

}
