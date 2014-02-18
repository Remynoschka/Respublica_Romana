package exception;

/**
 * Exception traversee quand un senateur est introuvable
 */
public class SenateurIntrouvableException extends Exception {

	private static final long serialVersionUID = 691394975295831718L;

	public SenateurIntrouvableException() {
		System.err.println("Senateur introuvable.");
	}
}
