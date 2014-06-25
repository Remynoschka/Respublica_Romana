/**
 * 
 */
package extended_components;

import ihm.Fenetre;

import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.GameState;

/**
 * @author Remynoschka
 * 
 */
public abstract class Components extends MouseOverArea {
	protected boolean disabled = false;
	protected boolean visible = true;
	protected GameState conteneur;

	/**
	 * @param container
	 * @param image
	 * @param x
	 * @param y
	 * @param etat
	 */
	public Components(GUIContext container, int x, int y, GameState etat) {
		super(container, null, x, y);
		this.conteneur = etat;
	}

	/**
	 * 
	 * @param container
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param etat
	 */
	public Components(GUIContext container, int x, int y, int w, int h,
			GameState etat) {
		super(container, null, x, y, w, h);
		this.conteneur = etat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.gui.MouseOverArea#mouseDragged(int, int, int, int)
	 */
	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur) {
			if (!disabled) {
				super.mouseDragged(oldx, oldy, newx, newy);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.gui.MouseOverArea#mouseMoved(int, int, int, int)
	 */
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur) {
			if (!disabled) {
				super.mouseMoved(oldx, oldy, newx, newy);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.gui.MouseOverArea#mousePressed(int, int, int)
	 */
	@Override
	public void mousePressed(int button, int mx, int my) {
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur) {
			if (!disabled) {
				super.mousePressed(button, mx, my);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.gui.MouseOverArea#mouseReleased(int, int, int)
	 */
	@Override
	public void mouseReleased(int button, int mx, int my) {
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur) {
			if (!disabled) {
				super.mouseReleased(button, mx, my);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.util.InputAdapter#mouseWheelMoved(int)
	 */
	@Override
	public void mouseWheelMoved(int change) {
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur) {
			if (!disabled) {
				super.mouseWheelMoved(change);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.util.InputAdapter#keyPressed(int, char)
	 */
	@Override
	public void keyPressed(int key, char c) {
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur) {
			if (!disabled) {
				super.keyPressed(key, c);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.util.InputAdapter#keyReleased(int, char)
	 */
	@Override
	public void keyReleased(int key, char c) {
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur) {
			if (!disabled) {
				super.keyReleased(key, c);
			}
		}
	}

	public void setVisible(boolean val) {
		visible = val;
	}
}
