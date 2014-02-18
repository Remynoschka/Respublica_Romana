package ihm;

import java.util.ArrayList;
import java.util.List;

import joueurs.Joueur;

import main.Jeu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import extended_components.GroupeBoutons;
import extended_components.PanelAutreJoueur;
import extended_components.PanelInfosFaction;
import extended_components.PanelPlateau;
import extended_components.PanelRome;
import extended_components.PanelSenateurs;
import extended_components.ToggleBouton;

/**
 * L'ecran principal du jeu.
 * 
 * @author Remynoschka
 * 
 */
public class EcranPrincipal extends BasicGameState {
	public static final int ID = 1;
	private PanelInfosFaction infosFaction;
	private PanelRome panelRome;
	private PanelSenateurs senateurs;
	private List<PanelAutreJoueur> autresJoueurs;
	private PanelPlateau plateau;


	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		infosFaction = new PanelInfosFaction(container, container.getWidth()
				- PanelInfosFaction.LARGEUR, 0);
		autresJoueurs = new ArrayList<PanelAutreJoueur>();
		int x = 50;
		for (Joueur p : Jeu.GAME.getJoueurs()) {
			if (p != Jeu.JOUEUR) {
				autresJoueurs.add(new PanelAutreJoueur(Fenetre.FENETRE, x, 20,
						p));
				x += 200;
			}
		}
		senateurs = new PanelSenateurs(container, 0, container.getHeight()
				- PanelSenateurs.HAUTEUR, container.getWidth()
				- PanelInfosFaction.LARGEUR);
		plateau = new PanelPlateau(container);

		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.setFont(Jeu.FONT);
		plateau.render(container, g);
		infosFaction.render(container, g);
		for (PanelAutreJoueur aj : autresJoueurs) {
			aj.render(container, g);
		}
		senateurs.render(container, g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		return ID;
	}

}
