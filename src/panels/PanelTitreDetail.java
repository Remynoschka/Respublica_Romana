/**
 * 
 */
package panels;

import main.Jeu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

import titres.Titre;

/**
 * @author Remynoschka
 * 
 */
public class PanelTitreDetail extends MouseOverArea {
	private Image	fond;
	private Titre	titre;

	/**
	 * @param container
	 * @param x
	 * @param y
	 * @throws SlickException
	 */
	public PanelTitreDetail(GUIContext container, Titre titre, int w, int h)
			throws SlickException {
		super(container, new Image(0, 0), 0, 0, w, h);
		fond = new Image("./data/images/fonds/fond_titre.png");
		this.titre = titre;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.gui.MouseOverArea#render(org.newdawn.slick.gui.GUIContext
	 * , org.newdawn.slick.Graphics)
	 */
	public void render(GUIContext context, Graphics g, int x, int y) {
		setX(x);
		setY(y);
		super.render(context, g);
		fond.draw(getX(), getY(), getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(Color.white);
		// Ecrire nom du titre
		g.drawString(titre.getNom(), getX() + getWidth() / 2
				- g.getFont().getWidth(titre.getNom()) / 2, getY() + 5);

		g.setFont(Jeu.LOW_FONT);
		// Ecrire description
		int ydesc = getY();
		for (String desc : titre.getDescription()) {
			g.drawString(desc, x + getWidth() / 2 - g.getFont().getWidth(desc)
					/ 2, ydesc + 25);
			ydesc += 15;
		}
		// Ecrire bonus
		g.drawString(
				"+" + titre.getBonusInfluence(),
				getX() + getWidth()
						- g.getFont().getWidth("+" + titre.getBonusInfluence())
						- 5,
				getY() + getHeight()
						- g.getFont().getHeight("" + titre.getBonusInfluence())
						- 5);
		// Ecrire rang
		g.drawString("" + titre.getRangTitre(), getX() + 5, getY()
				+ getHeight()
				- g.getFont().getHeight("" + titre.getRangTitre()) - 5);
		g.setFont(Jeu.FONT);

	}
}
