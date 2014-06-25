package panels;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

/**
 * Fait l'affichage d'une zone indiquant de quelle partie de la curie il s'agit.
 * Lorsque l'ont passe la souris dessus, les details apparaissent dans la zone
 * centrale.
 * 
 * @author Remynoschka
 * 
 */
public class PanelCurie extends MouseOverArea {
	private PanelCurieContent content;
	private boolean mouseInto;
	private Image fond;

	public PanelCurie(GUIContext container, int x, int y, Image fond,
			PanelCurieContent content) throws SlickException {
		super(container, new Image(0, 0), x, y, PanelPlateau.LARGEUR_CURIE, 105);
		this.fond = fond;
		this.content = content;
	}
	
	public PanelCurie(GUIContext container, int x, int y, Image fond,
			PanelCurieContent content, int h) throws SlickException {
		super(container, new Image(0, 0), x, y, PanelPlateau.LARGEUR_CURIE, h);
		this.fond = fond;
		this.content = content;
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		super.mouseMoved(oldx, oldy, newx, newy);
		if (newx < getX() + getWidth() && newx > getX() && newy > getY()
				&& newy < getY() + getHeight()) {
			mouseInto = true;
		} else if (!(mouseInto && newx < content.getX() + content.getWidth()
				&& newx > content.getX() && newy > content.getY() && newy < content
				.getY() + content.getHeight())) {
			mouseInto = false;
		}
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		super.render(container, g);
		fond.draw(getX(), getY(), getWidth(), getHeight());
		if (mouseInto) {
			content.render(container, g);
		}
	}
}
