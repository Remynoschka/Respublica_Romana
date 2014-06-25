package ihm;

import java.util.ArrayList;
import java.util.List;

import jeu.Partie;
import joueurs.Joueur;
import main.Jeu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import panels.PanelAutreJoueur;
import panels.PanelInfosFaction;
import panels.PanelPlateau;
import panels.PanelSenateurs;
import extended_components.Ecran;

/**
 * L'ecran principal du jeu.
 * 
 * @author Remynoschka
 * 
 */
public class EcranPrincipal extends Ecran {
	public static final int ID = 1;
	private PanelInfosFaction infosFaction;
	private PanelSenateurs senateurs;
	private List<PanelAutreJoueur> autresJoueurs;
	private PanelPlateau plateau;

	/**
	 * 
	 */
	public EcranPrincipal() {
		super();
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		infosFaction = new PanelInfosFaction(container, container.getWidth()
				- PanelInfosFaction.LARGEUR, 0);
		autresJoueurs = new ArrayList<PanelAutreJoueur>();
		int x = 50;
		for (Joueur p : Partie.PARTIE_EN_COURS.getJoueurs()) {
			if (p != Jeu.INSTANCE.getPlayerMe()) {
				autresJoueurs.add(new PanelAutreJoueur(Fenetre.FENETRE, x, 20,
						p,this));
				x += 200;
			}
		}
		senateurs = new PanelSenateurs(container, 0, container.getHeight()
				- PanelSenateurs.HAUTEUR, container.getWidth()
				- PanelInfosFaction.LARGEUR);
		plateau = new PanelPlateau(container,this);

		
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
		super.render(container, game, g);
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

	/* (non-Javadoc)
	 * @see ihm.Ecran#enterBehaviour()
	 */
	@Override
	public void enterBehaviour() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see ihm.Ecran#leaveBehaviour()
	 */
	@Override
	public void leaveBehaviour() {
		// TODO Auto-generated method stub
		
	}

}
