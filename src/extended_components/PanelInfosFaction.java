package extended_components;

import ihm.Fenetre;
import main.Jeu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

/**
 * Informations sur la factions du joueur.
 * 
 * @author Remynoschka
 * 
 */
public class PanelInfosFaction extends MouseOverArea {
	public static final int LARGEUR = 250;
	public static final int HAUTEUR_BANDEAU = 130;
	public static final int HAUTEUR_IMAGE = 70;
	private Image bandeauRouge;
	private Image bois;
	private Image iconeTresor;

	public PanelInfosFaction(GUIContext container, int x, int y)
			throws SlickException {
		super(container, new Image(0, 0), x, y, LARGEUR, container.getHeight());
		bandeauRouge = new Image("./data/images/fonds/bandeau_rouge.png");
		bois = new Image("./data/images/fonds/bois.png");
		iconeTresor = new Image("./data/images/icones/piece1.png");
	}

	@Override
	public void render(GUIContext fenetre, Graphics g) {
		super.render(fenetre, g);
		bandeauRouge.draw(0, getY(), Fenetre.FENETRE.getWidth(),
				HAUTEUR_BANDEAU);
		bois.draw(getX(), HAUTEUR_BANDEAU, LARGEUR, fenetre.getHeight()
				- HAUTEUR_BANDEAU);

		// Symbole
		Jeu.JOUEUR.getSymbole().draw(getX() + LARGEUR / 2 - HAUTEUR_IMAGE / 2,
				20, HAUTEUR_IMAGE, HAUTEUR_IMAGE);
		// Nom joueur
		g.setColor(new Color(215, 160, 75));
		g.drawString(Jeu.JOUEUR.getNom().toUpperCase(), getX() + LARGEUR / 2
				- g.getFont().getWidth(Jeu.JOUEUR.getNom().toUpperCase()) / 2,
				HAUTEUR_IMAGE + 30);
		// Tresorerie
		g.setColor(new Color(255, 255, 255));
		g.drawString("" + Jeu.JOUEUR.getArgentCoffre(), getX() + LARGEUR / 2
				- g.getFont().getWidth("" + Jeu.JOUEUR.getArgentCoffre()) / 2,
				HAUTEUR_IMAGE + 80);
		iconeTresor.draw(
				getX()
						+ LARGEUR
						/ 2
						+ g.getFont().getWidth(
								"" + Jeu.JOUEUR.getArgentCoffre()) + 10,
				HAUTEUR_IMAGE + 80, 20, 20);
		// Compteur de voix total
		g.drawString(
				"Total voix : " + Jeu.JOUEUR.getNbVoix(),
				getX()
						+ LARGEUR
						/ 2
						- g.getFont().getWidth(
								"Total voix : " + Jeu.JOUEUR.getNbVoix()) / 2,
				HAUTEUR_IMAGE + 120);
		// Boutons d'action
	}

}
