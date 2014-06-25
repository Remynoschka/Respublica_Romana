package exception;

import main.Main;

/**
 * Exception traversee lorsqu'un choix incorrect a ete effectue
 */
public class ChoixIncorrectException extends Exception {

	private static final long serialVersionUID = 27066005209477561L;

	public ChoixIncorrectException() {
		if (Main.debug)
			System.err.println("Valeur de choix incorrect.");
	}
	

}
