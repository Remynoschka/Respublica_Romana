/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extended_components;

import ihm.Fenetre;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.GameState;

import Actions.Action;

/**
 * Composant Bouton pour le jeu
 * 
 * @author Remynoschka
 */
public class Bouton extends Components {
	protected String		texte		= "";
	protected Action		action;
	protected int			mnemonic	= -1;
	public static final int	KEY_ENTER	= 28;
	protected static Image	bouton;
	protected static Image	boutonHover;
	protected static Image	boutonOnClick;
	protected static Image	boutonX;
	protected static Image	boutonXHover;
	protected static Image	boutonXOnClick;

	public static final int	WIDTH		= 100;
	public static final int	HEIGHT		= 100;

	// CONSTRUCTEURS
	/**
	 * Creer un bouton croix qui permet de quitter le programme.
	 * 
	 * @param container
	 *            : la fenetre
	 * @param x
	 *            : la coordonnee X
	 * @param y
	 *            : la coordonee Y
	 * @param etat
	 *            : l'ecran auquel le bouton appartient
	 */
	public static Bouton createXBouton(GUIContext container, int x, int y,
			GameState etat) {
		Bouton bouton = new Bouton(container, x, y, 25, 25, "", Action.QUITTER,
				Keyboard.KEY_ESCAPE, false, etat);
		bouton.setNormalImage(boutonX);
		bouton.setMouseDownImage(boutonXOnClick);
		bouton.setMouseOverImage(boutonXHover);
		return bouton;

	}

	/**
	 * Creer un bouton
	 * 
	 * @param container
	 * @param x
	 * @param y
	 * @param texte
	 *            : le texte du bouton
	 * @param a
	 *            : l'action executee au clic
	 * @param etat
	 *            : l'ecran auquel appartient le bouton
	 * @return le bouton creer
	 */
	public static Bouton createBouton(GUIContext container, int x, int y,
			String texte, Action a, GameState etat) {
		return new Bouton(container, x, y, WIDTH, HEIGHT, texte, a, false, etat);
	}

	/**
	 * Creer un bouton
	 * 
	 * @param container
	 * @param x
	 * @param y
	 * @param texte
	 *            : le texte du bouton
	 * @param a
	 *            : l'action executee au clic
	 * @param etat
	 *            : l'ecran auquel appartient le bouton
	 * @param mnemonic
	 *            : le raccourcis clavier
	 * @return le bouton creer
	 */
	public static Bouton createBouton(GUIContext container, int x, int y,
			String texte, Action a, GameState etat, int mnemonic) {
		return new Bouton(container, x, y, WIDTH, HEIGHT, texte, a, mnemonic,
				false, etat);
	}

	private void construire(String texte, Action a) {
		this.setNormalImage(bouton);
		this.setMouseOverImage(boutonHover);
		this.setMouseDownImage(boutonOnClick);
		this.texte = texte;
		this.action = a;
	}

	private Bouton(GUIContext container, int x, int y, int w, int h,
			String texte, Action a, boolean large, GameState etat) {
		super(container, x, y, w, h, etat);
		construire(texte, a);

	}

	private Bouton(GUIContext container, int x, int y, int h, int w,
			String texte, Action a, int mnemonic, boolean large, GameState etat) {
		super(container, x, y, h, w, etat);
		this.mnemonic = mnemonic;
		construire(texte, a);
	}

	/**
	 * Fait les prechargements
	 * 
	 * @throws IOException
	 */
	public static void init() throws IOException {
		try {
			bouton = new Image("./data/images/bouton/bouton.png");
			boutonHover = new Image("./data/images/bouton/bouton_hover.png");
			boutonOnClick = new Image("./data/images/bouton/bouton_onclick.png");
			boutonX = new Image("./data/images/bouton/croix.png");
			boutonXHover = new Image("./data/images/bouton/croix_hover.png");
			boutonXOnClick = new Image("./data/images/bouton/croix_clic.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		if (visible) {
			super.render(container, g);
			if (!disabled)
				g.setColor(new Color(36, 36, 36));
			else
				g.setColor(new Color(136, 136, 136));

			g.drawString(texte, (float) (this.getX() + getWidth() / 2 - g
					.getFont().getWidth(texte) / 2), this.getY() + HEIGHT / 2
					- g.getFont().getHeight(texte) / 2);
		}
	}

	public void setAction(Action a) {
		this.action = a;
	}

	public void setMnemonic(int mnemonic) {
		this.mnemonic = mnemonic;
	}

	public void doAction() {
		action.actionPerformed();

	}

	public void setVisible(boolean value) {
		this.visible = value;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {

		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur) {
			if (!disabled) {
				super.mouseClicked(button, x, y, clickCount);
				if (x > getX() && x < getX() + getWidth() && y > getY()
						&& y < getY() + getHeight()) {
					if (action != null)
						this.doAction();
					else
						System.err.println("Pas d'action définie");
				}
			}
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		if (Fenetre.FENETRE.getVueActuelle() == this.conteneur) {
			if (!disabled) {
				super.keyPressed(key, c);
				if (key == this.mnemonic) {
					if (action != null)
						this.doAction();
					else
						System.err.println("Pas d'action définie");
				}
			}
		}
	}

}
