/**
 * 
 */
package multiplayer;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;

/**
 * Classe permettant l'envoie de messages au serveur
 * 
 * @author Remynoschka
 * 
 */
public class ClientRPR extends NetworkInterface {
	public static ClientRPR INSTANCE;
	private Client client;
	private String ipServeur;

	public static ClientRPR getInstance(String ipServeur, String playerName) {
		if (INSTANCE == null)
			INSTANCE = new ClientRPR(ipServeur, playerName);
		return INSTANCE;
	}

	private ClientRPR(String ipServeur, String playerName) {
		client = new Client();
		client.setName(playerName);
		registerPaquets();
		this.ipServeur = ipServeur;
		client.addListener(new ConnexionListener());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see multiplayer.NetworkInterface#registerPaquets()
	 */
	@Override
	protected void registerPaquets() {
		client.getKryo().register(PaquetConnexion.class);
		client.getKryo().register(PaquetException.class);
		client.getKryo().register(PaquetJoueur.class);
		client.getKryo().register(PaquetQuitterLobby.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see multiplayer.NetworkInterface#start()
	 */
	@Override
	public void start() {
		System.out.println("======= LANCEMENT CLIENT ========");
		client.start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see multiplayer.NetworkInterface#stop()
	 */
	@Override
	public void stop() {
		System.out.println("======= FERMETURE CLIENT ========");
		client.stop();
		INSTANCE = null;
	}

	public int sendTCP(Object obj) {
		return client.sendTCP(obj);
	}

	public int sendUDP(Object obj) {
		return client.sendUDP(obj);
	}

	public void connect() throws IOException {
		client.connect(TIMEOUT, ipServeur, PORT_TCP, PORT_UDP);
	}

}
