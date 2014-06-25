/**
 * 
 */
package titres;

import Actions.Action;

/**
 * @author Remynoschka
 * 
 */
public class Censeur extends Titre {
	public static final Censeur INSTANCE = new Censeur();

	protected Censeur() {
		super("Censeur", 4, 5, new String[] { "1 Procès majeur", "ou",
				"2 procès mineurs" }, 200, 100);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Titres.Titre#getAction()
	 */
	@Override
	public Action getAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
