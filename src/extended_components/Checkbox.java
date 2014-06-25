/**
 * 
 */
package extended_components;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.GameState;

/**
 * Classe definissant un element de type checkbox pour une ihm
 * 
 * @author Remynoschka
 * 
 */
public class Checkbox extends BoutonGroupable {
	private static Image unchecked;
	private static Image checked;
	private int emplacement_texte;
	public static final int TEXT_UP = 0;
	public static final int TEXT_RIGHT = 1;
	public static final int TEXT_LEFT = 2;
	public static final int TEXT_DOWN = 3;

	/**
	 * @param container
	 *            : la fenetre
	 * @param x
	 *            : coorodonne X
	 * @param y
	 *            : coordonnee Y
	 * @throws SlickException
	 */
	public Checkbox(GUIContext container, int x, int y, GameState etat)
			throws SlickException {
		super(container, x, y, 25, 25, etat);
		this.text = "";
		emplacement_texte = TEXT_RIGHT;
		setNormalImage(unchecked);
		setMouseOverImage(unchecked);
		setMouseDownImage(checked);
	}

	/**
	 * 
	 * @param container
	 *            : la fenetre
	 * @param x
	 *            : coorodonne X
	 * @param y
	 *            : coordonnee Y
	 * @param text
	 *            : le texte de la checkbox
	 * @throws SlickException
	 */
	public Checkbox(GUIContext container, int x, int y, String text,
			GameState etat) throws SlickException {
		super(container, x, y, 25, 25, etat);
		this.text = text;
		emplacement_texte = TEXT_RIGHT;
		setNormalImage(unchecked);
		setMouseOverImage(unchecked);
		setMouseDownImage(checked);
	}

	/**
	 * 
	 * @param container
	 *            : la fenetre
	 * @param x
	 *            : coorodonne X
	 * @param y
	 *            : coordonnee Y
	 * @param text
	 *            : le texte de la checkbox
	 * @throws SlickException
	 */
	public Checkbox(GUIContext container, int x, int y, String text,
			int emplacement, GameState etat) throws SlickException {
		super(container, x, y, 25, 25, etat);
		this.text = text;
		emplacement_texte = emplacement;
		setNormalImage(unchecked);
		setMouseOverImage(unchecked);
		setMouseDownImage(checked);
	}

	/**
	 * Initialise les donnees
	 * 
	 * @throws SlickException
	 */
	public static void init() throws SlickException {
		checked = new Image("./data/images/bouton/checkbox.png");
		unchecked = new Image("./data/images/bouton/checkbox_unchecked.png");
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		super.render(container, g);
		g.setColor(new Color(0, 0, 0));
		switch (emplacement_texte) {
		case TEXT_RIGHT:
			g.drawString(text, (float) (this.getX() + getWidth() + 10),
					this.getY() + getHeight() / 2 - g.getFont().getHeight(text)
							/ 2);
			break;
		case TEXT_LEFT:
			g.drawString(text, (float) (this.getX()
					- g.getFont().getWidth(text) - 10), this.getY()
					+ getHeight() / 2 - g.getFont().getHeight(text) / 2);
			break;
		case TEXT_UP:
			g.drawString(text, (float) (this.getX() + getWidth() / 2 - g
					.getFont().getWidth(text) / 2), this.getY()
					- g.getFont().getHeight(text) - 5);
			break;
		case TEXT_DOWN:
			g.drawString(text, (float) (this.getX() + getWidth() / 2 - g
					.getFont().getWidth(text) / 2), this.getY() + getHeight()
					+ 5);
			break;
		}

	}

	@Override
	public void deselectionner() {
		super.deselectionner();
		setNormalImage(unchecked);
		setMouseOverImage(unchecked);
		setMouseDownImage(checked);

	}

	@Override
	public void selectionner() {
		if (!selected) {
			setNormalImage(checked);
			setMouseOverImage(checked);
			setMouseDownImage(unchecked);
		}
		super.selectionner();
	}
}
