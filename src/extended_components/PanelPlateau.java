package extended_components;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

import plateau.Rome;

/**
 * Panel affichant les infos de Rome
 * 
 * @author Remynoschka
 * 
 */
public class PanelPlateau extends PanelPrincipal {
	public static final int LARGEUR_GAUCHE = 75;
	public static final int LARGEUR_CURIE = 150;
	public static final int LARGEUR_EVENTS = 100;
	private Image fond_timer;
	private Image fond_events;
	private Image fond_legions;
	private Image fond_escadres;
	private Image fond_veterans;
	private GroupeBoutons boutonsGauche;
	private ToggleBouton carte;
	private ToggleBouton guerres;
	private ToggleBouton forum;

	public PanelPlateau(GUIContext container) throws SlickException {
		super(container);
		fond_timer = new Image("./data/images/fonds/dos_carte_small.png");
		fond_events = new Image("./data/images/fonds/fond_event.png");
		fond_legions = new Image("./data/images/icones/legion.png");
		fond_escadres = new Image("./data/images/icones/escadre.png");
		fond_veterans = new Image("./data/images/icones/veteran.png");
		boutonsGauche = new GroupeBoutons();
		carte = new ToggleBouton(container, 0, getY() + 300, "Carte");
		guerres = new ToggleBouton(container, 0, getY() + 375, "Guerres");
		forum = new ToggleBouton(container, 0, getY() + 450, "Forum");
		boutonsGauche.add(carte);
		boutonsGauche.add(guerres);
		boutonsGauche.add(forum);
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		// ZONE GAUCHE
		g.setColor(Color.black);
		fond_events.draw(getX(), getY(), LARGEUR_GAUCHE, getHeight());
		g.drawString("" + Rome.rome.getAgitationSociale(), 5, getY() + 5);
		g.drawString("" + Rome.rome.getArgent(), 5, getY() + 75 / 2);
		g.setColor(new Color(182,22,22));
		fond_legions.draw(0, getY() + 75, LARGEUR_GAUCHE, LARGEUR_GAUCHE);
		g.drawString(
				"" + Rome.rome.getArmees().getNbLegionsDisponibles(),
				LARGEUR_GAUCHE
						/ 2
						- g.getFont().getWidth(
								""
										+ Rome.rome.getArmees()
												.getNbLegionsDisponibles()) / 2,
				getY()
						+ 75
						+ 75
						/ 2
						- g.getFont().getHeight(
								""
										+ Rome.rome.getArmees()
												.getNbLegionsDisponibles()) / 2);
		fond_veterans.draw(0, getY() + 150, LARGEUR_GAUCHE, LARGEUR_GAUCHE);
		g.drawString(
				"" + Rome.rome.getArmees().getNbVeteransDisponibles(),
				LARGEUR_GAUCHE
						/ 2
						- g.getFont().getWidth(
								""
										+ Rome.rome.getArmees()
												.getNbVeteransDisponibles())
						/ 2,
				getY()
						+ 150
						+ 75
						/ 2
						- g.getFont().getHeight(
								""
										+ Rome.rome.getArmees()
												.getNbVeteransDisponibles()) / 2);
		g.setColor(Color.black);
		fond_escadres.draw(0, getY() + 225, LARGEUR_GAUCHE, LARGEUR_GAUCHE);
		g.drawString("" + Rome.rome.getArmees().getNbEscadresDisponibles(), LARGEUR_GAUCHE
				/ 2
				- g.getFont().getWidth(
						""
								+ Rome.rome.getArmees()
										.getNbEscadresDisponibles())
				/ 2,
				getY()
				+ 225
				+ 75
				/ 2
				- g.getFont().getHeight(
						""
								+ Rome.rome.getArmees()
										.getNbEscadresDisponibles()) / 2);
		carte.render(container, g);
		guerres.render(container, g);
		forum.render(container, g);
		// ZONE EVENTS

		fond_events.draw(getWidth() - LARGEUR_EVENTS, getY(), LARGEUR_EVENTS,
				getHeight());
		fond_timer.draw(getWidth() - LARGEUR_EVENTS, getY());

		// ZONE DROITE
		g.drawLine(getWidth() - LARGEUR_CURIE - LARGEUR_EVENTS,
				PanelInfosFaction.HAUTEUR_BANDEAU, getWidth() - LARGEUR_CURIE
						- LARGEUR_EVENTS, getY() + getHeight());
	}
}
