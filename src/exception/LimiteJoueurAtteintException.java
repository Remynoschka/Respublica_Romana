/**
 * 
 */
package exception;

import main.Main;

/**
 * @author Remynoschka
 * 
 */
public class LimiteJoueurAtteintException extends Exception {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8424238110039722200L;

	/**
	 * 
	 */
	public LimiteJoueurAtteintException() {
		if (Main.debug)
			System.err.println("Nombre de joueurs limite atteint");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Nombre de joueurs limite atteint";
	}
}
