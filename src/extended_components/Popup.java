/**
 * 
 */
package extended_components;

import joueurs.Joueur;
import ihm.Fenetre;
import main.Jeu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.GUIContext;

/**
 * Affiche une popup contenant un message et un bouton ok.
 * 
 * @author Remynoschka
 * 
 */
public abstract class Popup extends Components {
	public static final int WIDTH = 512;
	public static final int HEIGHT = 256;
	private String titre;
	private String message;

	/**
	 * 
	 * @param titre
	 *            : le titre de la popup
	 * @param message
	 *            : le message de la popup
	 */
	public Popup(String titre, String message) {
		super(Fenetre.FENETRE, Fenetre.FENETRE.getWidth() / 2 - WIDTH / 2,
				Fenetre.FENETRE.getHeight() / 2 - HEIGHT / 2, WIDTH, HEIGHT,
				Jeu.INSTANCE.getCurrentState());
		this.titre = titre.toUpperCase();
		this.message = message;
		visible = true;
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		if (visible) {
			// fond
			g.setColor(Color.lightGray);
			g.fillRect(getX(), getY(), WIDTH, HEIGHT);
			// titre
			g.setColor(Joueur.COLOR_DISPLAY_NAME);
			g.drawString(titre,
					getX() + WIDTH / 2 - (g.getFont().getWidth(titre) / 2),
					getY() + 5);
			// message
			g.setColor(Color.white);
			g.drawString(message,
					getX() + WIDTH / 2 - (g.getFont().getWidth(message) / 2),
					getY() + 50);
		}
	}

	public void close() {
		this.visible = false;
		Fenetre.FENETRE.setPopupActive(false);
	}
}
