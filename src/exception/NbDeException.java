package exception;

@SuppressWarnings("serial")
public class NbDeException extends Exception {


	public NbDeException(){
		System.err.println("Nombre de Dés incorrect");
	}
}
