package panels;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

import cartes.Senateur;

/**
 * Un senateur
 * 
 * @author Remynoschka
 * 
 */
public class PanelSenateur extends MouseOverArea {
	private Senateur		senateur;
	private boolean			mouseInto;
	public static final int	LARGEUR		= 100;
	private InfosSenateur	infos;
	private final Color		couleurHE	= new Color(115, 52, 60);

	public PanelSenateur(GUIContext container, int x, int y, Senateur s)
			throws SlickException {
		super(container, new Image(0, 0), x, y, LARGEUR, LARGEUR);
		this.senateur = s;
		infos = new InfosSenateur(container, x, y - 30 - InfosSenateur.HAUTEUR,
				s);

	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		super.mouseMoved(oldx, oldy, newx, newy);
		if (newx < getX() + getWidth() && newx > getX() && newy > getY()
				&& newy < getY() + getHeight()) {
			mouseInto = true;
		} else {
			mouseInto = false;
		}
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		super.render(container, g);
		if (mouseInto) {
			if (senateur.estHommeEtat()) {
				g.setColor(couleurHE);
			} else {
				g.setColor(Color.black);
			}
			int xnom = (getX() + 50 - g.getFont().getWidth(senateur.getNom())
					/ 2 < 0) ? 0 : getX() + 50
					- g.getFont().getWidth(senateur.getNom()) / 2;
			g.drawString(senateur.getNom(), xnom, getY() - 20);
			infos.render(container, g);
		}
		senateur.getImage().draw(getX() + 10, getY(), 80, 80);
		if (senateur.getTitre() != null) {
			senateur.getTitre()
					.getIcon()
					.render(container, g,
							getX() + getWidth() - IconeTitre.LARGEUR_IMAGE,
							getY());
		}
	}
}
