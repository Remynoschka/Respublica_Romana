/**
 * 
 */
package extended_components;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.GUIContext;

import Actions.Action;

/**
 * @author Remynoschka
 * 
 */
public class OkPopup extends Popup {
	private Bouton ok;

	/**
	 * @param titre
	 * @param message
	 */
	public OkPopup(String titre, String message) {
		super(titre, message);
		ok = Bouton.createBouton(container, getX() + WIDTH / 2 - Bouton.WIDTH
				/ 2, getY() + HEIGHT - Bouton.HEIGHT - 10, "Ok", new Action() {

			@Override
			public void actionPerformed() {
				System.out.println("OK POPUP PRESSED");
				close();
			}
		}, conteneur, Keyboard.KEY_NUMPADENTER);
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see extended_components.Popup#render(org.newdawn.slick.gui.GUIContext,
	 * org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GUIContext container, Graphics g) {
		super.render(container, g);
		if (visible) {
			ok.render(container, g);
		}
	}
}
