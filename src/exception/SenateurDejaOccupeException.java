package exception;

@SuppressWarnings("serial")
public class SenateurDejaOccupeException extends Exception {
	public SenateurDejaOccupeException(){
		System.err.println("Le senateur a deja un titre.");
	}
}
