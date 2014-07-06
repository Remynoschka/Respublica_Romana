package extended_components;

import ihm.Fenetre;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.GameState;

import Actions.Action;

/**
 * Classe generique pour faire des boutons groupables
 * 
 * @author Remynoschka
 * 
 */
public abstract class BoutonGroupable extends Components {
	protected boolean		selected	= false;
	protected GroupeBoutons	groupe;
	protected Action		action;
	protected String		text;

	public BoutonGroupable(GUIContext container, int x, int y, GameState etat)
			throws SlickException {
		super(container, x, y, etat);
	}

	public BoutonGroupable(GUIContext container, int x, int y, String text,
			GameState etat) throws SlickException {
		super(container, x, y, etat);
		this.text = text;
	}

	public BoutonGroupable(GUIContext container, int x, int y, Action a,
			String text, GameState etat) throws SlickException {
		super(container, x, y, etat);
		this.action = a;
		this.text = text;
	}

	public BoutonGroupable(GUIContext container, int x, int y, int w, int h,
			Action a, String text, GameState etat) throws SlickException {
		super(container, x, y, w, h, etat);
		this.action = a;
		this.text = text;
	}

	public BoutonGroupable(GUIContext container, int x, int y, int w, int h,
			Action a, GameState etat) throws SlickException {
		super(container, x, y, w, h, etat);
		this.action = a;
	}

	public BoutonGroupable(GUIContext container, int x, int y, Action a,
			GameState etat) throws SlickException {
		super(container, x, y, etat);
		this.action = a;
	}

	public BoutonGroupable(GUIContext container, int x, int y, int w, int h,
			GameState etat) throws SlickException {
		super(container, x, y, w, h, etat);
	}

	public BoutonGroupable(GUIContext container, int x, int y, int w, int h,
			String txt, GameState etat) throws SlickException {
		super(container, x, y, w, h, etat);
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
		} else if (groupe == null) {
			deselectionner();
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
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive())
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

	public boolean isSelected() {
		return selected;
	}

}
