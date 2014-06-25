package exception;

import main.Main;

/**
 * Exception traversee quand un senateur est introuvable
 */
public class SenateurIntrouvableException extends Exception {

	private static final long serialVersionUID = 691394975295831718L;

	public SenateurIntrouvableException() {
		if (Main.debug)
			System.err.println("Senateur introuvable.");
	}
}
