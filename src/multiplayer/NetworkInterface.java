/**
 * 
 */
package multiplayer;

/**
 * Classe generique pour les 2 interfaces reseau possibles (Client / Serveur).
 * Elles ont des methodes et attributs communs
 * 
 * Dans le constructeur des sous classes, ne pas oublier de faire appel a
 * registerPaquets
 * 
 * @author Remynoschka
 * 
 */
public abstract class NetworkInterface {
	public static final int PORT_UDP = 20592;
	public static final int PORT_TCP = 20593;
	public static final int TIMEOUT = 30000;

	/**
	 * Enregistre les paquets qui doivent etre enregistres
	 */
	protected abstract void registerPaquets();

	/**
	 * Lance l'interface
	 */
	public abstract void start();

	/**
	 * Arrete l'interface
	 */
	public abstract void stop();
}
