package extended_components;

import ihm.Fenetre;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.GameState;

import Actions.Action;

/**
 * Bouton avec image faisant partie d'un groupe de boutons
 * 
 * @author Remynoschka
 * 
 */
public class ToggleBouton extends BoutonGroupable {
	private Image normal;
	private Image hover;
	private Image clicked;
	private boolean pressed;

	public ToggleBouton(GUIContext container, int x, int y, GameState etat)
			throws SlickException {
		super(container, x, y, 75, 75, etat);
		init();
	}

	public ToggleBouton(GUIContext container, int x, int y, Action a,
			GameState etat) throws SlickException {
		super(container, x, y, 75, 75, a, etat);
		init();
	}

	public ToggleBouton(GUIContext container, int x, int y, Action a,
			String txt, GameState etat) throws SlickException {
		super(container, x, y, 75, 75, a, txt, etat);
		init();
	}

	public ToggleBouton(GUIContext container, int x, int y, String text,
			GameState etat) throws SlickException {
		super(container, x, y, 75, 75, text, etat);
		init();
	}

	private void init() {
		try {
			normal = new Image("./data/images/bouton/toggle.png");
			hover = new Image("./data/images/bouton/toggle_hover.png");
			clicked = new Image("./data/images/bouton/toggle_clicked.png");
			setNormalImage(normal);
			setMouseOverImage(hover);
			setMouseDownImage(clicked);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		super.render(container, g);
		g.setColor(new Color(0, 0, 0));
		if (!selected && !pressed) {
			g.drawString(text, (float) (this.getX() + getWidth() / 2 - g
					.getFont().getWidth(text) / 2), this.getY() + 20);
		} else {
			g.drawString(text, (float) (this.getX() + getWidth() / 2 - g
					.getFont().getWidth(text) / 2), this.getY() + 25);
		}
	}

	@Override
	public void deselectionner() {
		super.deselectionner();
		setNormalImage(normal);
		setMouseOverImage(hover);
		setMouseDownImage(clicked);

	}

	@Override
	public void selectionner() {
		if (!selected) {
			setNormalImage(clicked);
			setMouseOverImage(clicked);
			setMouseDownImage(clicked);
		}
		super.selectionner();
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		super.mousePressed(button, x, y);
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur
				&& !Fenetre.FENETRE.hasPopupActive()) {
			if (!disabled) {
				if (x > getX() && x < getX() + getWidth() && y > getY()
						&& y < getY() + getHeight()) {
					pressed = true;
				}
			}
		}
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		super.mouseMoved(oldx, oldy, newx, newy);
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur
				&& !Fenetre.FENETRE.hasPopupActive()) {
			if (!disabled) {
				if (!(newx > getX() && newx < getX() + getWidth()
						&& newy > getY() && newy < getY() + getHeight())) {
					pressed = false;
				}
			}
		}
	}

	@Override
	public void mouseReleased(int button, int mx, int my) {
		super.mouseReleased(button, mx, my);
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur
				&& !Fenetre.FENETRE.hasPopupActive()) {
			if (!disabled) {
				pressed = false;
			}
		}
	}
}
