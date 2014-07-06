/**
 * 
 */
package extended_components;

import ihm.Fenetre;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.GameState;

/**
 * Classe representant une combobox (liste sur un bouton)
 * 
 * @author Remynoschka
 * 
 */
public class Combobox<E> extends Components {
	protected List<E>			liste;
	protected E					selectedItem;
	protected boolean			deroule;
	protected static final int	HEIGHT_ITEM	= 100;
	protected static Image		bouton;
	protected static Image		boutonHover;
	protected static Image		boutonOnClick;

	/**
	 * @param container
	 * @param image
	 * @param x
	 * @param y
	 * @throws SlickException
	 */
	public Combobox(GUIContext container, Image image, int x, int y,
			GameState etat) throws SlickException {
		super(container, x, y, etat);
		liste = new ArrayList<E>();
		selectedItem = null;
		deroule = false;
		bouton = new Image("./data/images/bouton/combobox.png");
		boutonHover = new Image("./data/images/bouton/combobox_hover.png");
		boutonOnClick = new Image("./data/images/bouton/combobox_clicked.png");
		this.setNormalImage(bouton);
		this.setMouseOverImage(boutonHover);
		this.setMouseDownImage(boutonOnClick);
	}

	/**
	 * Indique l'item selectionne dans la liste
	 * 
	 * @param index
	 *            : l'index de l'item a selectionne
	 * @return l'item selectionne
	 */
	public E setSelectedIndex(int index) {
		E obj = liste.get(index);
		selectedItem = obj;
		return obj;
	}

	/**
	 * 
	 * @return l'item selectionne dans la liste
	 */
	public E getSelectedItem() {
		return selectedItem;
	}

	/**
	 * Ajoute un element a la liste
	 * 
	 * @param item
	 *            : l'element a ajouter
	 */
	public void addItem(E item) {
		liste.add(item);
	}

	/**
	 * Defini la liste affichee
	 * 
	 * @param list
	 *            : la liste a afficher
	 */
	public void setListe(List<E> list) {
		this.liste = list;
	}

	/**
	 * Retire l'item de la liste
	 * 
	 * @param item
	 *            : l'item a retirer
	 */
	public void removeItem(E item) {
		liste.remove(item);
	}

	/**
	 * Retire un item de la liste
	 * 
	 * @param index
	 *            : l'index de l'item a retirer
	 */
	public void removeItemAt(int index) {
		liste.remove(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.gui.MouseOverArea#render(org.newdawn.slick.gui.GUIContext
	 * , org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GUIContext container, Graphics g) {
		super.render(container, g);
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		super.mousePressed(button, x, y);
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive()) {
			if (!disabled) {
				if (x > getX() && x < getX() + getWidth() && y > getY()
						&& y < getY() + getHeight()) {
					deroule = !deroule;
					if (deroule) {
					}
				}
			}
		}
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		super.mouseMoved(oldx, oldy, newx, newy);
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive()) {
			if (!disabled) {
				if (!(newx > getX() && newx < getX() + getWidth()
						&& newy > getY() && newy < getY() + getHeight())) {
				}
			}
		}
	}

	@Override
	public void mouseReleased(int button, int mx, int my) {
		super.mouseReleased(button, mx, my);
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive()) {
			if (!disabled) {
			}
		}
	}

}
