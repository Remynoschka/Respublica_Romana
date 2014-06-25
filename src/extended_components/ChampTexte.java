/**
 * 
 */
package extended_components;

import ihm.Fenetre;

import org.newdawn.slick.Font;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.GameState;

/**
 * TextField mais le probleme de la souris
 * 
 * @author Remynoschka
 * 
 */
public class ChampTexte extends TextField {
	protected GameState conteneur;

	/**
	 * @param container
	 * @param font
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param etat
	 *            : l'ecran sur lequel le composant est
	 */
	public ChampTexte(GUIContext container, Font font, int x, int y, int width,
			int height, GameState etat) {
		super(container, font, x, y, width, height);
		this.conteneur = etat;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive())
			super.mouseClicked(button, x, y, clickCount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.util.InputAdapter#mouseDragged(int, int, int, int)
	 */
	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive())
			super.mouseDragged(oldx, oldy, newx, newy);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.util.InputAdapter#mouseMoved(int, int, int, int)
	 */
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive())
			super.mouseMoved(oldx, oldy, newx, newy);
	}/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.util.InputAdapter#mousePressed(int, int, int)
	 */

	@Override
	public void mousePressed(int button, int x, int y) {
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive())
			super.mousePressed(button, x, y);
	}/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.gui.AbstractComponent#mouseReleased(int, int, int)
	 */

	@Override
	public void mouseReleased(int button, int x, int y) {
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive())
			super.mouseReleased(button, x, y);
	}/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.util.InputAdapter#mouseWheelMoved(int)
	 */

	@Override
	public void mouseWheelMoved(int change) {
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive())
			super.mouseWheelMoved(change);
	}/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.gui.TextField#keyPressed(int, char)
	 */

	@Override
	public void keyPressed(int arg0, char arg1) {
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive())
			super.keyPressed(arg0, arg1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.util.InputAdapter#keyReleased(int, char)
	 */
	@Override
	public void keyReleased(int key, char c) {
		if (Fenetre.FENETRE.getVueActuelle() == conteneur
				&& !Fenetre.FENETRE.hasPopupActive())
			super.keyReleased(key, c);
	}
}
