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
import exception.NomTropCourtException;
import extended_components.Bouton;
import extended_components.ChampTexte;
import extended_components.Ecran;

/**
 * Ecran affichant le menu pour creer une partie
 * 
 * @author Remynoschka
 * 
 */
public class EcranDemandeNom extends Ecran {
	public static final int	ID					= 4;
	private ChampTexte		pseudo;
	private Bouton			ok;
	private Bouton			annuler;
	private Image			fond;
	private boolean			warningNameLength	= false;
	private String			errMsg				= "";

	/**
	 * 
	 */
	public EcranDemandeNom() {
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
		pseudo = new ChampTexte(container, Jeu.FONT,
				(Fenetre.FENETRE.getWidth() / 2) - 300 + 100,
				(Fenetre.FENETRE.getHeight() / 2) - 250 + 30 + 10 + 10, 200,
				30, this);
		ok = Bouton.createBouton(container,
				Fenetre.FENETRE.getWidth() / 2 + 180,
				Fenetre.FENETRE.getHeight() / 2 - 50, "OK", new Action() {

					@Override
					public void actionPerformed() {
						// Verifier qu'on a un nom
						if (pseudo.getText().length() < 1)
							try {
								throw new NomTropCourtException();
							} catch (NomTropCourtException e) {
								errMsg = e.getMessage();
								warningNameLength = true;
							}
						else {
							// Creer le joueur qui est moi
							Jeu.INSTANCE.setPlayerMe(new Joueur(pseudo
									.getText()));
							// Lancer le serveur et passer à l'écran de lobby
							Action.HEBERGER.actionPerformed();
							// Ajouter l'host au serveur
							ClientRPR client = ClientRPR.getInstance(
									"127.0.0.1", pseudo.getText());
							client.start();
							try {
								client.connect();
								PaquetConnexion paquet = new PaquetConnexion();
								paquet.setName(Jeu.INSTANCE.getPlayerMe()
										.getNom());
								client.sendUDP(paquet);
							} catch (IOException e) {
								errMsg = e.getMessage();
								warningNameLength = true;
							}
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
		g.drawString("Pseudo :", (Fenetre.FENETRE.getWidth() / 2) - 300 + 10,
				(Fenetre.FENETRE.getHeight() / 2) - 250 + 30 + 10 + 10);
		pseudo.render(container, g);
		g.setColor(new Color(255, 50, 75));
		if (warningNameLength) {
			g.drawString(errMsg, (Fenetre.FENETRE.getWidth() / 2) - 300 + 10,
					(Fenetre.FENETRE.getHeight() / 2) - 250 + 30 + 10 + 30 + 10);
		}
		g.setColor(Color.black);
		ok.render(container, g);
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
		warningNameLength = false;
	}

}
