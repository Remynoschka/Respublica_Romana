package panels;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * 
 */

/**
 * Panel affichant toutes les guerres. Si on passes la souris sur une guerre, on
 * a le detail de celle-ci
 * 
 * @author Remynoschka
 * 
 */
public class PanelGuerres extends ZoneCentrale {
	private Image	fondGInactives;
	private Image	fondGImminentes;
	private Image	fondGActives;
	private Image	fondGNEntreprises;

	/**
	 * @param container
	 * @throws SlickException
	 */
	public PanelGuerres(GUIContext container) throws SlickException {
		super(container);
		fondGInactives = new Image(
				"./data/images/fonds/guerres_inactives_small.png");
		fondGImminentes = new Image(
				"./data/images/fonds/guerres_imminentes_small.png");
		fondGActives = new Image(
				"./data/images/fonds/guerres_actives_small.png");
		fondGNEntreprises = new Image(
				"./data/images/fonds/guerres_nentreprises_small.png");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see panels.ZoneCentrale#render(org.newdawn.slick.gui.GUIContext,
	 * org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GUIContext container, Graphics g) {
		fondGActives.draw(getX(), getY(), getWidth(), getHeight() / 4);
		fondGNEntreprises.draw(getX(), getY() + (getHeight() / 4), getWidth(),
				getHeight() / 4);
		fondGImminentes.draw(getX(), getY() + 2 * getHeight() / 4, getWidth(),
				getHeight() / 4);
		fondGInactives.draw(getX(), getY() + 3 * getHeight() / 4, getWidth(),
				getHeight() / 4);
	}

}
