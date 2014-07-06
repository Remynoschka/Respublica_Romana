/**
 * 
 */
package exception;

import main.Main;

/**
 * @author Remynoschka
 * 
 */
public class FormatAdresseIPException extends Exception {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 3877041855275697500L;

	public FormatAdresseIPException() {
		if (Main.debug)
			System.err.println("Adresse IP invalide.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Adresse IP invalide.";
	}
}
