/**
 * 
 */
package extended_components;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Classe generique pour les ecrans. Elle oblige un comportement par defaut
 * lorsque l'on entre et sort de l'etat
 * 
 * @author Remynoschka
 * 
 */
public abstract class Ecran extends BasicGameState {
	private List<Popup> popups;

	public Ecran() {
		popups = new ArrayList<Popup>();
	}

	@Override
	public void render(GameContainer container, StateBasedGame jeu, Graphics g)
			throws SlickException {
		for (Popup p : popups) {
			p.render(container, g);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
	 */
	@Override
	public void update(GameContainer container, StateBasedGame jeu, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode appellee lorsqu'on entre dans l'etat
	 */
	public abstract void enterBehaviour();

	/**
	 * Methode appellee lorsqu'on sort de l'etat
	 */
	public abstract void leaveBehaviour();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.BasicGameState#enter(org.newdawn.slick.GameContainer
	 * , org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void enter(GameContainer container, StateBasedGame game)
			throws SlickException {
		enterBehaviour();
		super.enter(container, game);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.BasicGameState#leave(org.newdawn.slick.GameContainer
	 * , org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void leave(GameContainer container, StateBasedGame game)
			throws SlickException {
		super.leave(container, game);
		leaveBehaviour();
	}

	public void displayPopup(Popup popup) {
		popups.add(popup);
	}

	public void removePopup(Popup popup) {
		popups.remove(popup);
	}
}
