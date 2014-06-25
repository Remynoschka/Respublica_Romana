package panels;

import joueurs.Joueur;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

/**
 * Classe qui sert a afficher un joueur qui est dans le lobby Affiche son nom,
 * et son symbole
 * 
 * @author Remynoschka
 * 
 */
public class LobbyPlayerDisplay extends MouseOverArea {
	private Joueur joueur;
	public static final int HEIGHT = 50;
	public static final int WIDTH = 400;

	public LobbyPlayerDisplay(GUIContext container, Joueur joueur)
			throws SlickException {
		super(container, null,
				(int) (container.getWidth() / 2 - WIDTH / 2), 0, WIDTH, HEIGHT);
		this.joueur = joueur;
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
		g.setColor(Joueur.COLOR_DISPLAY_NAME);
		g.drawString(joueur.getNom(), getX(), getY() + HEIGHT / 2
				- g.getFont().getHeight(joueur.getNom()) / 2);
		g.setColor(Color.black);
		g.drawImage(joueur.getSymbole().getScaledCopy(HEIGHT, HEIGHT), getX()
				+ WIDTH, getY());
	}
	
	public Joueur getJoueur(){
		return this.joueur;
	}

}
