/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import main.Jeu;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;

import extended_components.Ecran;
import extended_components.Popup;

/**
 * 
 * @author Remynoschka
 */
public class Fenetre extends AppGameContainer {
	public static Fenetre FENETRE;
	private boolean popupActive;// moche mais sinon faut tout refaire
	public static final ConfigMonitors config = ConfigMonitors
			.getConfiguration();

	/**
	 * Creates new form Fenetre
	 */
	private Fenetre(Game game, int width, int height) throws SlickException {
		super(game, width, height, true);

	}

	public void displayPopup(Popup popup) {
		((Ecran) Jeu.INSTANCE.getCurrentState()).displayPopup(popup);
		popupActive = true;
	}

	public GameState getVueActuelle() {
		return Jeu.INSTANCE.getCurrentState();
	}

	/**
	 * 
	 * @return si une popup est active
	 */
	public boolean hasPopupActive() {
		return popupActive;
	}
	
	public void setPopupActive(boolean val){
		popupActive = val;
	}

	/**
	 * Change la vue affichee dans la fenetre
	 * 
	 * @param idState
	 *            : l'id d'un GameState representant cette vue
	 * @return l'id de l'etat que l'on quitte
	 */
	public int changerVueActuelle(int idState) {
		int leave = Jeu.INSTANCE.getCurrentStateID();
		Jeu.INSTANCE.enterState(idState);
		return leave;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre.FENETRE = new Fenetre(Jeu.INSTANCE, ConfigMonitors
							.getGraphicsDevice().getDisplayMode().getWidth(),
							ConfigMonitors.getGraphicsDevice().getDisplayMode()
									.getHeight());

					FENETRE.start();

				} catch (SlickException e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables
}
