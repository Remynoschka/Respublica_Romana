package exception;

import main.Main;

public class TalentsInsuffisantException extends Exception {

	/**
	 * Exception levee quand le nombre de talents est insuffisant
	 */
	private static final long serialVersionUID = -459694328442700136L;

	public TalentsInsuffisantException() {
		if (Main.debug)
			System.err
					.println("Nombre de talents insuffisant pour cette opération.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Nombre de talents insuffisant pour cette op�ration.";
	}
}
