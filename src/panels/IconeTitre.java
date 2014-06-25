/**
 * 
 */
package panels;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

import titres.Titre;

/**
 * Icone indiquant qu'un senateur possede un titre Passer la souris dessus fait
 * apparaitre le detail du titre
 * 
 * @author Remynoschka
 * 
 */
public class IconeTitre extends MouseOverArea {
	private boolean mouseInto;
	private Image icone;
	private PanelTitreDetail detail;
	public static final int HAUTEUR_IMAGE = 45;
	public static final int LARGEUR_IMAGE = 17;

	/**
	 * 
	 * @param container
	 * @param titre
	 * @param w
	 *            : la largeur du texte d'aide
	 * @param h
	 *            : la hauteur du texte d'aide
	 * @throws SlickException
	 */
	public IconeTitre(GUIContext container, Titre titre, int w, int h)
			throws SlickException {
		super(container, new Image(0, 0), 0, 0, LARGEUR_IMAGE, HAUTEUR_IMAGE);
		icone = new Image("./data/images/icones/titre.png");
		detail = new PanelTitreDetail(container, titre, w, h);
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		super.mouseMoved(oldx, oldy, newx, newy);
		if (newx < getX() + getWidth() && newx > getX() && newy > getY()
				&& newy < getY() + getHeight()) {
			mouseInto = true;
		} else if (!(mouseInto && newx < detail.getX() + detail.getWidth()
				&& newx > detail.getX() && newy > detail.getY() && newy < detail
				.getY() + detail.getHeight())) {
			mouseInto = false;
		}
	}

	public void render(GUIContext container, Graphics g, int x, int y) {
		setX(x);
		setY(y-10);
		super.render(container, g);
		icone.draw(getX(), getY(), LARGEUR_IMAGE, HAUTEUR_IMAGE);
		g.setColor(new Color(215, 160, 75));
		if (mouseInto) {
			detail.render(container, g, getX() + LARGEUR_IMAGE, getY()
					- HAUTEUR_IMAGE / 2);
		}
	}

}
