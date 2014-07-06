/**
 * 
 */
package ihm;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import joueurs.Joueur;
import main.Jeu;
import main.Main;
import multiplayer.ClientRPR;
import multiplayer.Serveur;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import panels.LobbyPlayerDisplay;
import Actions.Action;
import exception.LimiteJoueurAtteintException;
import extended_components.Bouton;
import extended_components.Checkbox;
import extended_components.Ecran;

/**
 * Classe qui affiche l'ecran d'hebergement d'une partie
 * 
 * @author Remynoschka
 * 
 */
public class EcranSalleAttente extends Ecran {
	public static final int						ID				= 3;
	private static final int					LIMITE_JOUEURS	= 6;
	private boolean								host;
	private Image								fond1;
	private Image								fond2;
	private Bouton								lancer;
	private Bouton								annuler;
	private Bouton								quit;
	private Checkbox							h_rep;
	private Checkbox							m_rep;
	private Checkbox							b_rep;
	private Checkbox							alternatif;
	private Checkbox							jeu_avance;
	private Map<Integer, LobbyPlayerDisplay>	joueurs;
	private List<Image>							symbolesDispo;
	private String								ip				= "";

	/**
	 * 
	 */
	public EcranSalleAttente() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void init(GameContainer container, StateBasedGame jeu)
			throws SlickException {
		fond1 = new Image("./data/images/fonds/bandeau_rouge.png");
		fond2 = new Image("./data/images/fonds/bandeau_bas.png");
		fond2 = fond2.getScaledCopy((float) container.getWidth()
				/ (float) fond2.getWidth());
		lancer = Bouton.createBouton(container, container.getWidth() - 120,
				container.getHeight() - 120, "Commencer", null, this);
		annuler = Bouton.createBouton(container, 20,
				container.getHeight() - 120, "Annuler", new Action() {

					@Override
					public void actionPerformed() {
						Fenetre.FENETRE.changerVueActuelle(EcranAcceuil.ID);
						if (host) {
							Serveur.INSTANCE.stop();
						}
						ClientRPR.INSTANCE.stop();

					}
				}, this);
		quit = Bouton.createXBouton(container, container.getWidth() - 25, 0,
				this);
		int yEre = container.getHeight() - fond2.getHeight();
		h_rep = new Checkbox(container, container.getWidth() / 2 - 200, yEre,
				"Haute République", Checkbox.TEXT_UP, this);
		m_rep = new Checkbox(container, container.getWidth() / 2, yEre,
				"Moyenne République", Checkbox.TEXT_UP, this);
		b_rep = new Checkbox(container, container.getWidth() / 2 + 200, yEre,
				"Basse République", Checkbox.TEXT_UP, this);
		alternatif = new Checkbox(container, container.getWidth() - 50, yEre,
				"Scenario Alternatif", Checkbox.TEXT_LEFT, this);
		jeu_avance = new Checkbox(container, container.getWidth() - 50, 50,
				"Règles avancées", Checkbox.TEXT_LEFT, this);
		joueurs = new HashMap<Integer, LobbyPlayerDisplay>();
		// Ajout des symboles dispo
		symbolesDispo = new ArrayList<Image>();
		String pathSymboles = "./data/images/symboles/factions";
		File directorySymboles = new File(pathSymboles);
		for (String s : directorySymboles.list()) {
			if (s.endsWith(".png")) {
				symbolesDispo.add(new Image(pathSymboles + "/" + s));
			}
		}

		try {
			for (InetAddress ipAdress : InetAddress.getAllByName(InetAddress
					.getLocalHost().getCanonicalHostName())) {

				if (!ipAdress.getHostAddress().startsWith("192.168")
						&& ipAdress.getAddress().length == 4) {
					ip = ipAdress.getHostAddress();
				}

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GameContainer container, StateBasedGame jeu, Graphics g)
			throws SlickException {

		g.setFont(Jeu.FONT);
		fond1.draw(0, 0, Fenetre.FENETRE.getWidth(), container.getHeight());
		fond2.draw(0, container.getHeight() - fond2.getHeight());
		annuler.render(container, g);
		if (host)
			lancer.render(container, g);
		quit.render(container, g);
		h_rep.render(container, g);
		m_rep.render(container, g);
		b_rep.render(container, g);
		alternatif.render(container, g);
		jeu_avance.render(container, g);
		int y = 20;
		for (LobbyPlayerDisplay j : joueurs.values()) {
			j.setY(y);
			j.render(container, g);
			y += LobbyPlayerDisplay.HEIGHT + 10;
		}
		g.setColor(new Color(200, 200, 200));
		g.drawString("Votre IP : " + ip, (container.getWidth() / 2)
				- (g.getFont().getWidth(ip) / 2), container.getHeight() - 50);
		super.render(container, jeu, g);
		if (Main.debug) {
			g.setColor(Color.white);
			if (host)
				g.drawString("debug_info : HOST", container.getWidth() / 2, 10);
			else
				g.drawString("debug_info : CLIENT", container.getWidth() / 2,
						10);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame, int)
	 */
	@Override
	public void update(GameContainer container, StateBasedGame state, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.state.BasicGameState#getID()
	 */
	@Override
	public int getID() {
		return ID;
	}

	/**
	 * Ajoute un joueur au lobby
	 * 
	 * @param j
	 *            : le joueur a ajouter
	 * @throws LimiteJoueurAtteintException
	 */
	public Joueur addJoueur(int id, Joueur j)
			throws LimiteJoueurAtteintException {
		if (joueurs.size() < LIMITE_JOUEURS) {
			try {
				if (!joueurs.containsKey(id)) {
					j.setID(id);
					if (j.getSymbole() == null
							|| (j.getSymbole().getResourceReference()
									.equals("")))
						j.setSymbole(symbolesDispo.remove(0));
					joueurs.put(id, new LobbyPlayerDisplay(Fenetre.FENETRE, j));
				}
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new LimiteJoueurAtteintException();
		}
		return j;
	}

	/**
	 * Retire un joueur du lobby
	 * 
	 * @param j
	 *            : le LobbyDisplayPlayer a retirer
	 */
	public void removeJoueur(LobbyPlayerDisplay j) {
		symbolesDispo.add(j.getJoueur().getSymbole());
		joueurs.remove(j);
	}

	public void removeJoueur(int connexionID) {
		joueurs.remove(connexionID);
	}

	/**
	 * 
	 * @return une liste de tout les joueurs presents dans la salle d'attente
	 */
	public List<Joueur> getAllPlayers() {
		List<Joueur> listeJoueurs = new ArrayList<Joueur>();
		for (LobbyPlayerDisplay j : joueurs.values()) {
			listeJoueurs.add(j.getJoueur());
		}
		return listeJoueurs;
	}

	public boolean isHost() {
		return host;
	}

	public void setHost() {
		this.host = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.Ecran#enterBehaviour()
	 */
	@Override
	public void enterBehaviour() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.Ecran#leaveBehaviour()
	 */
	@Override
	public void leaveBehaviour() {
		host = false;
		LobbyPlayerDisplay[] jArray = (LobbyPlayerDisplay[]) joueurs.values()
				.toArray(new LobbyPlayerDisplay[joueurs.size()]);
		for (LobbyPlayerDisplay j : jArray) {
			removeJoueur(j);
		}
	}

}
