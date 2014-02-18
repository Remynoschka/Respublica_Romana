package main;

import ihm.ConfigMonitors;
import ihm.EcranAcceuil;
import ihm.EcranPrincipal;
import ihm.Fenetre;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jeu.Ere;
import joueurs.Joueur;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.StateBasedGame;

import plateau.Rome;
import cartes.HommeEtat;
import cartes.Senateur;
import extended_components.Bouton;

public class Jeu extends StateBasedGame {
	public static final Jeu GAME = new Jeu();
	public static Rome ROME;
	public static Joueur JOUEUR;
	public List<Joueur> joueurs;
	public static UnicodeFont FONT;
	public static final ColorEffect COLOR_EFFECT = new ColorEffect();

	private Jeu() {
		super("Respublica Romana");
		this.joueurs = new ArrayList<Joueur>();
	}

	@Override
	public void initStatesList(GameContainer fenetre) throws SlickException {
		try {
			Rome.newRome(Ere.HAUTE_REPUBLIQUE);
			Bouton.init();
			FONT = new UnicodeFont("./data/fonts/times.ttf", 20, false, false);
			FONT.addAsciiGlyphs();
			FONT.addGlyphs(400, 600);
			FONT.getEffects().add(COLOR_EFFECT);
			FONT.loadGlyphs();
			JOUEUR = new Joueur("JP", null, new Image(
					"./data/images/symboles/factions/aigle.png"));
			joueurs.add(JOUEUR);
			JOUEUR.addSenateurs(new Senateur("4", "Julius",
					Ere.HAUTE_REPUBLIQUE, 3));
			JOUEUR.addSenateurs(new Senateur("1", "Cornelius",
					Ere.HAUTE_REPUBLIQUE, 3));
			JOUEUR.addSenateurs(new Senateur("2", "Fabius",
					Ere.HAUTE_REPUBLIQUE, 2));
			JOUEUR.addSenateurs(new Senateur("9", "Aurelius",
					Ere.HAUTE_REPUBLIQUE, 3));
			JOUEUR.addSenateurs(new HommeEtat("19a",
					"L. Aemilius Paulus Macedonicus", Ere.HAUTE_REPUBLIQUE, 4));
			Joueur djeff = new Joueur("Djeff", null, new Image(
					"./data/images/symboles/factions/main.png"));
			djeff.addSenateurs(new Senateur("12", "Acilius",
					Ere.HAUTE_REPUBLIQUE, 2));
			djeff.addSenateurs(new HommeEtat("2a",
					"Q. Fabius Maximus Verrucosus Cunctator",
					Ere.HAUTE_REPUBLIQUE, 2));
			joueurs.add(djeff);
			Joueur upsie = new Joueur("Upsie", null, new Image(
					"./data/images/symboles/factions/etoile.png"));
			joueurs.add(upsie);
			Joueur panpan = new Joueur("Panpan", null, new Image(
					"./data/images/symboles/factions/couronne.png"));
			joueurs.add(panpan);
			Joueur cedric = new Joueur("Cedric", null, new Image(
					"./data/images/symboles/factions/rond.png"));
			joueurs.add(cedric);
			Joueur mout = new Joueur("Mout", null, new Image(
					"./data/images/symboles/factions/Lune.png"));
			joueurs.add(mout);
			ConfigMonitors.getConfiguration();
			addState(new EcranAcceuil());
			addState(new EcranPrincipal());
			enterState(EcranAcceuil.ID);
			Fenetre.FENETRE.setShowFPS(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return La liste des joueurs dans la partie
	 */
	public List<Joueur> getJoueurs() {
		return joueurs;
	}

}
