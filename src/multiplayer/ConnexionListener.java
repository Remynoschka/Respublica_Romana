/**
 * 
 */
package multiplayer;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ihm.EcranAcceuil;
import ihm.EcranRejoindrePartie;
import ihm.EcranSalleAttente;
import ihm.Fenetre;
import joueurs.Joueur;
import main.Jeu;
import Actions.Action;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import exception.LimiteJoueurAtteintException;
import extended_components.OkPopup;

/**
 * @author Remynoschka
 * 
 */
public class ConnexionListener extends Listener {

	/**
	 * 
	 */
	public ConnexionListener() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.esotericsoftware.kryonet.Listener#connected(com.esotericsoftware.
	 * kryonet.Connection)
	 */
	@Override
	public void connected(Connection c) {
		// TODO Auto-generated method stub
	}

	public void disconnected(Connection c) {
		if (!Serveur.INSTANCE.isRunning()) {
			Fenetre.FENETRE.changerVueActuelle(EcranAcceuil.ID);
			Fenetre.FENETRE.displayPopup(new OkPopup("Deconnecté",
					"Vous avez été déconnecté du serveur"));
		} else {
			if (Jeu.INSTANCE.getCurrentStateID() == EcranSalleAttente.ID) {
				PaquetQuitterLobby paquetQuitLobby = new PaquetQuitterLobby();
				paquetQuitLobby.setId(c.getID());
				Serveur.INSTANCE.SentToAllUDP(paquetQuitLobby);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.esotericsoftware.kryonet.Listener#received(com.esotericsoftware.kryonet
	 * .Connection, java.lang.Object)
	 */
	@Override
	public void received(Connection c, Object obj) {
		if (main.Main.debug)
			System.out.println("Recu de " + c.getID() + " un "
					+ obj.getClass().getName());

		// XXX Ce serait bien d'ameliorer cette chose immonde

		// RECEPTION D'UNE DEMANDE DE CONNEXION
		if (obj instanceof PaquetConnexion) {
			try {
				// Ajouter le joueur au lobby
				String nom = ((PaquetConnexion) obj).getName();
				((EcranSalleAttente) Jeu.INSTANCE
						.getState(EcranSalleAttente.ID)).addJoueur(c.getID(),
						new Joueur(nom));
				// Envoyer a tout les joueurs que qqn s'est connecte
				for (Joueur j : ((EcranSalleAttente) Jeu.INSTANCE
						.getState(EcranSalleAttente.ID)).getAllPlayers()) {
					PaquetJoueur paquetJ = new PaquetJoueur();
					paquetJ.setID(j.getID());
					paquetJ.setName(j.getNom());
					paquetJ.setSymboleName(j.getSymbole()
							.getResourceReference());
					paquetJ.setTalentsCoffre(j.getArgentCoffre());
					Serveur.INSTANCE.SentToAllUDP(paquetJ);
				}
			} catch (LimiteJoueurAtteintException e) {
				System.err
						.println("Impossible de rejoindre la partie. Celle-ci est pleine");
				PaquetException paquet = new PaquetException();
				paquet.setException(e);
				Serveur.INSTANCE.SentToUDP(c.getID(), paquet);
			}

		} else if (obj instanceof PaquetJoueur) {
			// On recoit les informations d'un joueur
			try {
				Joueur j;
				j = new Joueur(((PaquetJoueur) obj).getID(),
						((PaquetJoueur) obj).getName(), new Image(
								((PaquetJoueur) obj).getSymboleName()));
				switch (Jeu.INSTANCE.getCurrentStateID()) {
					case EcranRejoindrePartie.ID:

						((EcranSalleAttente) Jeu.INSTANCE
								.getState(EcranSalleAttente.ID)).addJoueur(
								j.getID(), j);
						if (Jeu.INSTANCE.getCurrentStateID() != EcranSalleAttente.ID)
							Action.CONNECTER.actionPerformed();
						break;
					case EcranSalleAttente.ID:
						((EcranSalleAttente) Jeu.INSTANCE
								.getState(EcranSalleAttente.ID)).addJoueur(
								j.getID(), j);
						break;

				}
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LimiteJoueurAtteintException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (obj instanceof PaquetQuitterLobby) {
			((EcranSalleAttente) Jeu.INSTANCE.getCurrentState())
					.removeJoueur(((PaquetQuitterLobby) obj).getId());

		} else if (obj instanceof PaquetException) {
			Fenetre.FENETRE.displayPopup(new OkPopup("Erreur",
					((PaquetException) obj).getException()));
		}
	}
}
