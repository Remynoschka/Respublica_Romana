package extended_components;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

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

	public ToggleBouton(GUIContext container, int x, int y)
			throws SlickException {
		super(container, x, y, 75, 75);
		init();
	}

	public ToggleBouton(GUIContext container, int x, int y, Action a)
			throws SlickException {
		super(container, x, y, 75, 75, a);
		init();
	}

	public ToggleBouton(GUIContext container, int x, int y, Action a, String txt)
			throws SlickException {
		super(container, x, y, 75, 75, a, txt);
		init();
	}

	public ToggleBouton(GUIContext container, int x, int y, String text)
			throws SlickException {
		super(container, x, y, 75, 75, text);
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
		if (!selected){
		g.drawString(text, (float) (this.getX() + getWidth() / 2 - g.getFont()
				.getWidth(text) / 2), this.getY()+20);
		} else {
			g.drawString(text, (float) (this.getX() + getWidth() / 2 - g.getFont()
					.getWidth(text) / 2), this.getY()+25);
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
}
