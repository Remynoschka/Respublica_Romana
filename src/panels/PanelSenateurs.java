package panels;

import java.util.ArrayList;
import java.util.List;

import main.Jeu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

import cartes.Senateur;

public class PanelSenateurs extends MouseOverArea {
	private List<PanelSenateur> senateurs;
	private Image fond;
	public static final int HAUTEUR = 110;

	public PanelSenateurs(GUIContext container, int x, int y, int w)
			throws SlickException {
		super(container, new Image(0, 0), x, y, w, HAUTEUR);
		senateurs = new ArrayList<PanelSenateur>();
		x  = 100 * (Jeu.INSTANCE.getPlayerMe().getSenateurs().size()-1);
		for (Senateur s : Jeu.INSTANCE.getPlayerMe().getSenateurs()) {
			senateurs.add(new PanelSenateur(container, x, y + HAUTEUR - 80, s));
			x -= 100;
		}
		fond = new Image("./data/images/fonds/fond_senateur.png");
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		fond.draw(getX(), getY(), getWidth(), getHeight());
		super.render(container, g);
		for (PanelSenateur s : senateurs) {
			s.render(container, g);
		}
	}

}
