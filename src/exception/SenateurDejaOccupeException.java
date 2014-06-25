package exception;

import main.Main;

public class SenateurDejaOccupeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7059970302822880017L;

	public SenateurDejaOccupeException() {
		if (Main.debug)
			System.err.println("Le senateur a deja un titre.");
	}
}
