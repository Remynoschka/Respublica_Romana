package panels;

import jeu.Partie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.GameState;

import Actions.Action;
import extended_components.GroupeBoutons;
import extended_components.ToggleBouton;
import plateau.Rome;

/**
 * Panel affichant les infos de Rome
 * 
 * @author Remynoschka
 * 
 */
public class PanelPlateau extends PanelPrincipal {
	public static final int	LARGEUR_GAUCHE	= 75;
	public static final int	LARGEUR_CURIE	= 150;
	public static final int	LARGEUR_EVENTS	= 100;
	// Events
	private Image			fond_timer;
	private Image			fond_events;
	// Zone gauche
	private Image			icone_tresor;
	private Image			icone_agitation;
	private Image			fond_legions;
	private Image			fond_escadres;
	private Image			fond_veterans;
	private GroupeBoutons	boutonsGauche;
	private ToggleBouton	carte;
	private ToggleBouton	guerres;
	private ToggleBouton	forum;
	// Curie
	private PanelCurie		chefs;
	private PanelCurie		senateurs;
	private PanelCurie		concessions;
	private Image			fond_lois;
	private PanelCurie		lois;
	// Zone Centrale
	private ZoneCentrale	zoneCentrale;
	private PanelCarte		panelCarte;
	private PanelGuerres	panelGuerre;
	private PanelForum		panelForum;

	public PanelPlateau(GUIContext container, GameState etat)
			throws SlickException {
		super(container, etat);
		zoneCentraleConstruct(container);
		zoneEventsConstruct();
		zoneGaucheConstruct(container);
		zoneCurieConstruct(container);
		carte.selectionner();
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		if (zoneCentrale != null)
			zoneCentrale.render(container, g);
		zoneGaucheRender(container, g);
		zoneEventsRender(container, g);
		zoneCurieRender(container, g);

	}

	/**
	 * Construit les differentes zones centrales
	 */
	private void zoneCentraleConstruct(GUIContext container) {
		try {
			panelCarte = new PanelCarte(container);
			panelGuerre = new PanelGuerres(container);
			panelForum = new PanelForum(container);
		} catch (SlickException e) {
		}
	}

	/**
	 * Construit la zone des evenements
	 * 
	 * @throws SlickException
	 */
	private void zoneEventsConstruct() throws SlickException {
		fond_timer = new Image("./data/images/fonds/dos_carte_small.png");
		fond_events = new Image("./data/images/fonds/fond_event.png");
	}

	/**
	 * Construit la zone de gauche
	 * 
	 * @param container
	 * @throws SlickException
	 */
	private void zoneGaucheConstruct(GUIContext container)
			throws SlickException {
		icone_tresor = new Image("./data/images/icones/tresor.png");
		icone_agitation = new Image("./data/images/icones/agitation.png");
		fond_legions = new Image("./data/images/icones/legion.png");
		fond_escadres = new Image("./data/images/icones/escadre.png");
		fond_veterans = new Image("./data/images/icones/veteran.png");
		boutonsGauche = new GroupeBoutons();
		carte = new ToggleBouton(container, 0, getY() + 300, new Action() {

			@Override
			public void actionPerformed() {
				zoneCentrale = panelCarte;
			}
		}, "Carte", etat);
		guerres = new ToggleBouton(container, 0, getY() + 375, new Action() {

			@Override
			public void actionPerformed() {
				zoneCentrale = panelGuerre;
			}
		}, "Guerres", etat);
		forum = new ToggleBouton(container, 0, getY() + 450, new Action() {

			@Override
			public void actionPerformed() {
				zoneCentrale = panelForum;
			}
		}, "Forum", etat);
		boutonsGauche.add(carte);
		boutonsGauche.add(guerres);
		boutonsGauche.add(forum);
	}

	/**
	 * Construit la zone de la curie
	 * 
	 * @param container
	 * @throws SlickException
	 */
	private void zoneCurieConstruct(GUIContext container) throws SlickException {
		fond_lois = new Image("./data/images/fonds/fond_plateau_small.png");
		chefs = new PanelCurie(container, getWidth() - LARGEUR_EVENTS
				- LARGEUR_CURIE, getY(), new Image(
				"./data/images/fonds/curie_chefs_small.png"),
				new PanelCurieChefsContent(container));
		senateurs = new PanelCurie(container, getWidth() - LARGEUR_EVENTS
				- LARGEUR_CURIE, getY() + 105, new Image(
				"./data/images/fonds/curie_releve_small.png"),
				new PanelCurieReleveContent(container));
		concessions = new PanelCurie(container, getWidth() - LARGEUR_EVENTS
				- LARGEUR_CURIE, getY() + 210, new Image(
				"./data/images/fonds/curie_cons_small.png"),
				new PanelCurieConcessionsContent(container));
		lois = new PanelCurie(container, getWidth() - LARGEUR_EVENTS
				- LARGEUR_CURIE, getY() + 330, new Image(
				"./data/images/fonds/lois_small.png"),
				new PanelLois(container), 180);
	}

	/**
	 * Fait le render de la zone de la Curie
	 * 
	 * @param container
	 * @param g
	 */
	private void zoneCurieRender(GUIContext container, Graphics g) {
		fond_lois.draw(lois.getX(), getY(), lois.getWidth(), getHeight());
		concessions.render(container, g);
		senateurs.render(container, g);
		chefs.render(container, g);
		lois.render(container, g);
	}

	/**
	 * Fait le render de la zone des evenements
	 */
	private void zoneEventsRender(GUIContext container, Graphics g) {
		fond_events.draw(getWidth() - LARGEUR_EVENTS, getY(), LARGEUR_EVENTS,
				getHeight());
		fond_timer.draw(getWidth() - LARGEUR_EVENTS, getY());
		int nbCartes = Partie.PARTIE_EN_COURS.getTasCartes().getNbCartes();
		g.setColor(Color.white);
		g.drawString("" + nbCartes, getWidth() - LARGEUR_EVENTS / 2
				- g.getFont().getWidth("" + nbCartes) / 2, getY() + 25);
		// TODO afficher les icones d'events
	}

	/**
	 * Fait le render de la zone de gauche
	 * 
	 * @param container
	 * @param g
	 */
	private void zoneGaucheRender(GUIContext container, Graphics g) {
		g.setColor(Color.black);
		fond_events.draw(getX(), getY(), LARGEUR_GAUCHE, getHeight());
		icone_agitation.draw(5, getY() + 5 / 2);
		g.drawString("" + Rome.INSTANCE.getAgitationSociale(), 30, getY() + 5);
		icone_tresor.draw(5, getY() + 75 / 2);
		g.drawString("" + Rome.INSTANCE.getArgent(), 30, getY() + 75 / 2);
		g.setColor(new Color(182, 22, 22));
		fond_legions.draw(0, getY() + 75, LARGEUR_GAUCHE, LARGEUR_GAUCHE);
		g.drawString(
				"" + Rome.INSTANCE.getArmees().getNbLegionsDisponibles(),
				LARGEUR_GAUCHE
						/ 2
						- g.getFont().getWidth(
								""
										+ Rome.INSTANCE.getArmees()
												.getNbLegionsDisponibles()) / 2,
				getY()
						+ 75
						+ 75
						/ 2
						- g.getFont().getHeight(
								""
										+ Rome.INSTANCE.getArmees()
												.getNbLegionsDisponibles()) / 2);
		fond_veterans.draw(0, getY() + 150, LARGEUR_GAUCHE, LARGEUR_GAUCHE);
		g.drawString(
				"" + Rome.INSTANCE.getArmees().getNbVeteransDisponibles(),
				LARGEUR_GAUCHE
						/ 2
						- g.getFont().getWidth(
								""
										+ Rome.INSTANCE.getArmees()
												.getNbVeteransDisponibles())
						/ 2,
				getY()
						+ 150
						+ 75
						/ 2
						- g.getFont().getHeight(
								""
										+ Rome.INSTANCE.getArmees()
												.getNbVeteransDisponibles())
						/ 2);
		g.setColor(Color.black);
		fond_escadres.draw(0, getY() + 225, LARGEUR_GAUCHE, LARGEUR_GAUCHE);
		g.drawString(
				"" + Rome.INSTANCE.getArmees().getNbEscadresDisponibles(),
				LARGEUR_GAUCHE
						/ 2
						- g.getFont().getWidth(
								""
										+ Rome.INSTANCE.getArmees()
												.getNbEscadresDisponibles())
						/ 2,
				getY()
						+ 225
						+ 75
						/ 2
						- g.getFont().getHeight(
								""
										+ Rome.INSTANCE.getArmees()
												.getNbEscadresDisponibles())
						/ 2);
		carte.render(container, g);
		guerres.render(container, g);
		forum.render(container, g);
	}
}
