package panels;

import java.util.ArrayList;
import java.util.List;

import joueurs.Joueur;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.GameState;

import cartes.Senateur;

/**
 * Le detail des infos sur un autre joueur
 * 
 * @author Remynoschka
 * 
 */
public class InfosAutreJoueur extends PanelPrincipal {
	private Joueur joueur;
	private List<PanelSenateur> senateurs;
	private Image fond;

	public InfosAutreJoueur(GUIContext container, Joueur j, GameState etat)
			throws SlickException {
		super(container,etat);
		this.joueur = j;
		senateurs = new ArrayList<PanelSenateur>();
		int x = 20;
		for (Senateur s : joueur.getSenateurs()) {
			senateurs.add(new PanelSenateur(container, x,
					getY() + 40 + 120 - 80, s));
			x += 100;
		}
		fond = new Image("./data/images/fonds/fond_senateur.png");
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		g.setColor(Color.black);
		fond.draw(getX(), getY(), getWidth(), getHeight());
		// Senateurs
		g.drawString("SENATEURS",
				getWidth() / 2 - g.getFont().getWidth("SENATEURS") / 2,
				getY() + 20);
		for (PanelSenateur s : senateurs) {
			s.render(container, g);
		}

	}

}
