package panels;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.GameState;
/**
 * Le panel qui prends toute la place centrale
 * @author Remynoschka
 *
 */
public abstract class PanelPrincipal extends MouseOverArea {
	protected GameState etat;
	public PanelPrincipal(GUIContext container, GameState etat) throws SlickException {
		super(container, new Image(0,0), 0, PanelInfosFaction.HAUTEUR_BANDEAU, container.getWidth()-PanelInfosFaction.LARGEUR, container.getHeight()-PanelInfosFaction.HAUTEUR_BANDEAU-PanelSenateurs.HAUTEUR);
		this.etat = etat;
	}
	
	@Override
	public abstract void render(GUIContext container, Graphics g);
	

}
