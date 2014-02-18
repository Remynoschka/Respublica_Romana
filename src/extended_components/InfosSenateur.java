package extended_components;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

import cartes.Senateur;
/**
 * Le detail des informations du senateur
 * @author Remynoschka
 *
 */
public class InfosSenateur extends MouseOverArea {
	public static final int HAUTEUR = 180;
	private Senateur senateur;
	private Image fond;

	public InfosSenateur(GUIContext container, int x, int y, Senateur s)
			throws SlickException {
		super(container, new Image(0, 0), x, y, PanelSenateur.LARGEUR, HAUTEUR);
		this.senateur = s;
		fond = new Image("./data/images/fonds/fond_senateur.png");
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		super.render(container, g);
		
		fond.draw(getX(), getY(), getWidth(), getHeight());
		
		g.drawString("ELO : "+senateur.getEloquance(), getX()+5, getY()+5);
		g.drawString("MIL : "+senateur.getValeurMilitaire(), getX()+5, getY()+20);
		g.drawString("LOY : "+senateur.getLoyaute(), getX()+5, getY()+35);
		g.drawString("POP : "+senateur.getPopularite(), getX()+5, getY()+50);
		g.drawString("INF : "+senateur.getInfluence(), getX()+5, getY()+65);
		g.drawString("CHE : "+senateur.getNbChevaliers(), getX()+5, getY()+80);
		g.drawString("TAL : "+senateur.getTalents(), getX()+5, getY()+95);
		g.setColor(Color.black);
		g.drawRect(getX(), getY(), getWidth(), getHeight()-1);
		
	}

}
