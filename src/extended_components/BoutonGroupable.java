package extended_components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

import Actions.Action;

/**
 * Classe generique pour faire des boutons groupables
 * 
 * @author Remynoschka
 * 
 */
public abstract class BoutonGroupable extends MouseOverArea {
	protected boolean selected;
	protected GroupeBoutons groupe;
	protected Action action;
	protected String text;

	public BoutonGroupable(GUIContext container, int x, int y)
			throws SlickException {
		super(container, new Image(0, 0), x, y);
	}

	public BoutonGroupable(GUIContext container, int x, int y, String text)
			throws SlickException {
		super(container, new Image(0, 0), x, y);
		this.text = text;
	}

	public BoutonGroupable(GUIContext container, int x, int y, Action a,
			String text) throws SlickException {
		super(container, new Image(0, 0), x, y);
		this.action = a;
		this.text = text;
	}

	public BoutonGroupable(GUIContext container, int x, int y, int w, int h,
			Action a, String text) throws SlickException {
		super(container, new Image(0, 0), x, y, w, h);
		this.action = a;
		this.text = text;
	}

	public BoutonGroupable(GUIContext container, int x, int y, int w, int h,
			Action a) throws SlickException {
		super(container, new Image(0, 0), x, y, w, h);
		this.action = a;
	}

	public BoutonGroupable(GUIContext container, int x, int y, Action a)
			throws SlickException {
		super(container, new Image(0, 0), x, y);
		this.action = a;
	}

	public BoutonGroupable(GUIContext container, int x, int y, int w, int h)
			throws SlickException {
		super(container, new Image(0, 0), x, y, w, h);
	}

	public BoutonGroupable(GUIContext container, int x, int y, int w, int h,
			String txt) throws SlickException {
		super(container, new Image(0, 0), x, y, w, h);
		this.text = txt;
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		super.render(container, g);
	}

	/**
	 * Methode qui deselectionne ce bouton
	 */
	public void deselectionner() {
		this.selected = false;
	}

	/**
	 * Methode qui selectionne ce bouton
	 */
	public void selectionner() {
		if (!selected) {
			selected = true;
			if (groupe != null) {
				groupe.deselectAll(this);
			}

			if (action != null) {
				action.actionPerformed();
			}
		}
		if (groupe != null) {
			groupe.deselectAll(this);
		}
	}

	/**
	 * Definit le groupe de boutons de ce bouton
	 * 
	 * @param groupe
	 *            : le groupe de bouton
	 */
	public void setGroupe(GroupeBoutons groupe) {
		this.groupe = groupe;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (x > getX() && x < getX() + getWidth() && y > getY()
				&& y < getY() + getHeight()) {
			selectionner();
		}

	}

	public GroupeBoutons getGroupe() {
		return this.groupe;
	}

	public void setAction(Action a) {
		this.action = a;
	}

	public Action getAction(Action a) {
		return this.action;
	}

	public void setTexte(String txt) {
		this.text = txt;
	}
}
