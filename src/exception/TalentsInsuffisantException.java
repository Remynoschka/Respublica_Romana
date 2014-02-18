package exception;

public class TalentsInsuffisantException extends Exception {

	/**
	 * Exception levee quand le nombre de talents est insuffisant
	 */
	private static final long serialVersionUID = -459694328442700136L;

	public TalentsInsuffisantException() {
		System.err.println("Nombre de talents insuffisant pour cette opération.");
	}
}
