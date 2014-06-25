/**
 * 
 */
package extended_components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.GUIContext;

import Actions.Action;

/**
 * @author Remynoschka
 * 
 */
public class OuiNonPopup extends Popup {
	private Bouton oui;
	private Bouton non;
	public static final int OUI = 0;
	public static final int NON = 1;
	private int closeValue;

	/**
	 * @param titre
	 * @param message
	 */
	public OuiNonPopup(String titre, String message) {
		super(titre, message);
		oui = Bouton.createBouton(container, getX() + 1 * WIDTH / 4, getY()
				+ getHeight() - Bouton.HEIGHT - 10, "Oui", new Action() {

			@Override
			public void actionPerformed() {
				closeValue = OUI;
				close();
			}
		}, conteneur);
		non = Bouton.createBouton(container, getX() + 3 * WIDTH / 4, getY()
				+ getHeight() - Bouton.HEIGHT - 10, "Non", new Action() {

			@Override
			public void actionPerformed() {
				closeValue = NON;
				close();
			}
		}, conteneur);
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
		if (visible){
			oui.render(container, g);
			non.render(container, g);
		}

	}

	public int getCloseValue() {
		return closeValue;
	}

}
