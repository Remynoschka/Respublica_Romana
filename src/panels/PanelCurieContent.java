package panels;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * Ce que contient la zone de curie sur la zone où l'on passe la souris.
 * 
 * @author Remynoschka
 * 
 */
public abstract class PanelCurieContent extends ZoneCentrale {
	protected Image fond;

	public PanelCurieContent(GUIContext container) throws SlickException {
		super(container);
		fond = new Image("./data/images/fonds/fond_senateur.png");
	}

	@Override
	public abstract void render(GUIContext container, Graphics g);
}
