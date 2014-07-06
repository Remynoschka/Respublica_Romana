/**
 * 
 */
package panels;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * Dessine la carte de l'empire et si on passe la souris sur une region, cela
 * affiche les details de la province
 * 
 * @author Remynoschka
 * 
 */
public class PanelCarte extends ZoneCentrale {
	private Image	carte;

	/**
	 * @param container
	 * @throws SlickException
	 */
	public PanelCarte(GUIContext container) throws SlickException {
		super(container);
		carte = new Image("./data/images/carte/europe_small.png");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see panels.ZoneCentrale#render(org.newdawn.slick.gui.GUIContext,
	 * org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GUIContext container, Graphics g) {
		carte.draw(getX(), getY(), getWidth(), getHeight());
	}

}
