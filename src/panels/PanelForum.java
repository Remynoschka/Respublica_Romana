/**
 * 
 */
package panels;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * Panel affichant le forum
 * 
 * @author Remynoschka
 * 
 */
public class PanelForum extends ZoneCentrale {
	private Image fond;
	private Image forum;

	/**
	 * @param container
	 * @throws SlickException
	 */
	public PanelForum(GUIContext container) throws SlickException {
		super(container);
		fond = new Image("./data/images/fonds/fond_plateau.png");
		forum = new Image("./data/images/fonds/forum_small.png");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see panels.ZoneCentrale#render(org.newdawn.slick.gui.GUIContext,
	 * org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GUIContext container, Graphics g) {
		fond.draw(getX(), getY(), getWidth(), getHeight());
		forum.draw(getWidth() / 2 + forum.getWidth() / 2, getY());
	}

}
