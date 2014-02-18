package extended_components;

import joueurs.Joueur;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

/**
 * Panel faisant l'affichage des informations sur un autre joueur. Au passage de
 * la souris sur le nom/symbole, les details sont affiches.
 * 
 * @author Remynoschka
 * 
 */
public class PanelAutreJoueur extends MouseOverArea {
	private Joueur joueur;
	private boolean mouseInto;
	private InfosAutreJoueur infos;
	public static final int HAUTEUR_IMAGE = 70;

	public PanelAutreJoueur(GUIContext container, int x, int y, Joueur joueur)
			throws SlickException {
		super(container, new Image(0, 0), x, y, HAUTEUR_IMAGE, 111);
		this.joueur = joueur;
		this.infos = new InfosAutreJoueur(container, joueur);
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		super.mouseMoved(oldx, oldy, newx, newy);
		if (newx < getX() + getWidth() && newx > getX() && newy > getY()
				&& newy < getY() + getHeight()) {
			mouseInto = true;
		} else if (!(mouseInto && newx < infos.getX() + infos.getWidth()
				&& newx > infos.getX() && newy > infos.getY()
				&& newy < infos.getY() + infos.getHeight())) {
			mouseInto = false;
		}
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		super.render(container, g);
		joueur.getSymbole().draw(getX(), 20, HAUTEUR_IMAGE, HAUTEUR_IMAGE);
		g.setColor(new Color(215, 160, 75));
		g.drawString(joueur.getNom().toUpperCase(), getX() + HAUTEUR_IMAGE/2
				- g.getFont().getWidth(joueur.getNom().toUpperCase()) / 2, 100);
		if (mouseInto) {
			g.setColor(Color.orange);
			infos.render(container, g);
		}
	}

}
