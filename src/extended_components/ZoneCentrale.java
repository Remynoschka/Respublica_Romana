package extended_components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

public abstract class ZoneCentrale extends MouseOverArea {

	public ZoneCentrale(GUIContext container, int y, int width, int height)
			throws SlickException {
		super(container, new Image(0, 0), PanelPlateau.LARGEUR_GAUCHE,
				PanelInfosFaction.HAUTEUR_BANDEAU, container.getWidth()
						- PanelInfosFaction.LARGEUR
						- PanelPlateau.LARGEUR_CURIE
						- PanelPlateau.LARGEUR_EVENTS
						- PanelPlateau.LARGEUR_GAUCHE, container.getHeight()
						- PanelInfosFaction.HAUTEUR_BANDEAU
						- PanelSenateurs.HAUTEUR);
		;
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void render(GUIContext container, Graphics g);
}
