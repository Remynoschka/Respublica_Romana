/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import main.Jeu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Actions.Action;

import extended_components.Bouton;

/**
 * Ecran correspondant a celui quand on ouvre le programme
 * 
 * @author Remynoschka
 */
public class EcranAcceuil extends BasicGameState {
	public static final int ID = 0;
	private static final String FOND_PATH = "./data/images/fonds/acceuil.jpg";
	private static Image imageFond;
	private Bouton heberger;
	private Bouton rejoindre;

	/**
	 * Creates new form EcranAcceuil
	 */
	public EcranAcceuil() {

	}

	@Override
	public void init(GameContainer fenetre, StateBasedGame jeu)
			throws SlickException {
		imageFond = new Image(FOND_PATH);
		heberger = Bouton.createBouton(fenetre,
				(int) (Fenetre.FENETRE.getWidth() * 0.4),
				(int) (Fenetre.FENETRE.getHeight() * 0.7), "Héberger", Action.HEBERGER,
				this);
		rejoindre = Bouton.createBouton(fenetre,
				(int) (Fenetre.FENETRE.getWidth() * 0.6),
				(int) (Fenetre.FENETRE.getHeight() * 0.7), "Rejoindre",
				Action.REJOINDRE, this);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game,
			org.newdawn.slick.Graphics g) throws SlickException {
		g.setFont(Jeu.FONT);
		imageFond.draw(0, 0, Fenetre.FENETRE.getWidth(),
				Fenetre.FENETRE.getHeight());
		heberger.render(container, g);
		rejoindre.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		return ID;
	}
}
