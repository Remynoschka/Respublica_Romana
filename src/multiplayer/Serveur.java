/**
 * 
 */
package multiplayer;

import java.io.IOException;

import com.esotericsoftware.kryonet.Server;

/**
 * @author Remynoschka
 * 
 */
public class Serveur extends NetworkInterface {
	public static final Serveur	INSTANCE	= new Serveur();
	private Server				serveur;
	private boolean				isRunning;

	private Serveur() {
		serveur = new Server();
		registerPaquets();
		try {
			serveur.bind(PORT_TCP, PORT_UDP);
			serveur.addListener(new ConnexionListener());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	protected void registerPaquets() {
		serveur.getKryo().register(PaquetConnexion.class);
		serveur.getKryo().register(PaquetException.class);
		serveur.getKryo().register(PaquetJoueur.class);
		serveur.getKryo().register(PaquetQuitterLobby.class);
	}

	public void SentToAllUDP(Object obj) {
		serveur.sendToAllUDP(obj);
	}

	public void SentToAllTCP(Object obj) {
		serveur.sendToAllTCP(obj);
	}

	public void SentToUDP(int connectionID, Object obj) {
		serveur.sendToUDP(connectionID, obj);
	}

	public void SentToTCP(int connectionID, Object obj) {
		serveur.sendToTCP(connectionID, obj);
	}

	@Override
	public void start() {
		serveur.start();
		isRunning = true;
		System.out.println("======= LANCEMENT SERVEUR ========");
	}

	@Override
	public void stop() {
		System.out.println("======= FERMETURE SERVEUR ========");
		serveur.stop();
		isRunning = false;
	}

	public boolean isRunning() {
		return isRunning;
	}
}
