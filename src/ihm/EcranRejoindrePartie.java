/**
 * 
 */
package ihm;

import java.io.IOException;

import joueurs.Joueur;
import main.Jeu;
import multiplayer.ClientRPR;
import multiplayer.PaquetConnexion;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import Actions.Action;
import exception.FormatAdresseIPException;
import exception.NomTropCourtException;
import extended_components.Bouton;
import extended_components.ChampTexte;
import extended_components.Ecran;

/**
 * Ecran affichant le menu pour rejoindre une partie
 * 
 * @author Remynoschka
 * 
 */
public class EcranRejoindrePartie extends Ecran {
	public static final int ID = 2;
	private ChampTexte ip;
	private ChampTexte pseudo;
	private Bouton rejoindre;
	private Bouton annuler;
	private Image fond;
	private boolean error = false;
	private String errorMsg = "";
	public static final String IP_REGEX = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	/**
	 * 
	 */
	public EcranRejoindrePartie() {
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
		fond = new Image("./data/images/fonds/bandeau_rouge.png");
		ip = new ChampTexte(container, Jeu.FONT,
				(Fenetre.FENETRE.getWidth() / 2) - 300 + 100,
				(Fenetre.FENETRE.getHeight() / 2) - 250 + 10, 200, 30, this);
		ip.setText("xxx.xxx.xxx.xxx");
		pseudo = new ChampTexte(container, Jeu.FONT,
				(Fenetre.FENETRE.getWidth() / 2) - 300 + 100,
				(Fenetre.FENETRE.getHeight() / 2) - 250 + 30 + 10 + 10, 200,
				30, this);
		rejoindre = Bouton.createBouton(container,
				Fenetre.FENETRE.getWidth() / 2 + 180,
				Fenetre.FENETRE.getHeight() / 2 - 50, "Rejoindre",
				new Action() {

					@Override
					public void actionPerformed() {
						try {
							if (!ip.getText().matches(IP_REGEX)) {
								throw new FormatAdresseIPException();

							}
							if (pseudo.getText().length() < 1)
								throw new NomTropCourtException();

							else {
								ClientRPR client = ClientRPR.getInstance(
										ip.getText(), pseudo.getText());
								client.start();
								try {
									client.connect();
								} catch (IOException e) {
									error = true;
									errorMsg = e.getLocalizedMessage();
								}
								Jeu.INSTANCE.setPlayerMe(new Joueur());
								Jeu.INSTANCE.getPlayerMe().setNom(
										pseudo.getText());
								PaquetConnexion paquet = new PaquetConnexion();
								paquet.setName(Jeu.INSTANCE.getPlayerMe()
										.getNom());
								client.sendUDP(paquet);
							}
						} catch (NomTropCourtException e) {
							error = true;
							errorMsg = e.getMessage();
						} catch (FormatAdresseIPException e) {
							error = true;
							errorMsg = e.getMessage();
						}
					}
				}, this, Bouton.KEY_ENTER);
		
		annuler = Bouton.createBouton(container,
				Fenetre.FENETRE.getWidth() / 2 - 280,
				Fenetre.FENETRE.getHeight() / 2 - 50, "Annuler", new Action() {

					@Override
					public void actionPerformed() {
						Fenetre.FENETRE.changerVueActuelle(EcranAcceuil.ID);
					}
				}, this);

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
		fond.draw((Fenetre.FENETRE.getWidth() / 2) - 300,
				(Fenetre.FENETRE.getHeight() / 2) - 250, 600, 300);
		g.setColor(new Color(136, 136, 136));
		g.drawRect((Fenetre.FENETRE.getWidth() / 2) - 300,
				(Fenetre.FENETRE.getHeight() / 2) - 250, 600, 300);
		g.drawString("IP :", (Fenetre.FENETRE.getWidth() / 2) - 300 + 10,
				(Fenetre.FENETRE.getHeight() / 2) - 250 + 10);
		ip.render(container, g);
		g.drawString("Pseudo :", (Fenetre.FENETRE.getWidth() / 2) - 300 + 10,
				(Fenetre.FENETRE.getHeight() / 2) - 250 + 30 + 10 + 10);
		pseudo.render(container, g);
		g.setColor(new Color(255, 50, 75));
		if (error) {
			g.drawString(errorMsg, (Fenetre.FENETRE.getWidth() / 2) - 300 + 10,
					(Fenetre.FENETRE.getHeight() / 2) - 250 + 30 + 10 + 30 + 10);
		}
		g.setColor(Color.black);
		rejoindre.render(container, g);
		annuler.render(container, g);
		super.render(container, jeu, g);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame, int)
	 */
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.Ecran#enterBehaviour()
	 */
	@Override
	public void enterBehaviour() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.Ecran#leaveBehaviour()
	 */
	@Override
	public void leaveBehaviour() {
		error = false;
	}

}
