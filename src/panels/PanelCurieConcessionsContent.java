package panels;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

public class PanelCurieConcessionsContent extends PanelCurieContent {

	public PanelCurieConcessionsContent(GUIContext container)
			throws SlickException {
		super(container);
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		fond.draw(getX(), getY(), getWidth(), getHeight());
		// TODO afficher les concessions a la curie
	}

}
