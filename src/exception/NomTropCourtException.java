/**
 * 
 */
package exception;

import main.Main;

/**
 * @author Remynoschka
 * 
 */
public class NomTropCourtException extends Exception {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1497690018407391029L;

	public NomTropCourtException() {
		if (Main.debug)
			System.err.println("Le nom est trop court");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Le pseudo doit contenir au moins 1 caractères";
	}
}
