/**
 * 
 */
package multiplayer;

/**
 * @author Remynoschka
 *
 */
public class PaquetException extends PaquetReseau {
	private String exception;
	
	public void setException(Exception e){
		this.exception = e.getMessage();
	}
	
	public String getException(){
		return exception;
	}
}
