package exception;

import main.Main;

@SuppressWarnings("serial")
public class NbDeException extends Exception {

	public NbDeException() {
		if (Main.debug)
			System.err.println("Nombre de Dés incorrect");
	}
}
