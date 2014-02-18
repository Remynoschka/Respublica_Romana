package extended_components;

import org.newdawn.slick.Image;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

public class PanelRome extends MouseOverArea {

	public PanelRome(GUIContext container, Image image, int x, int y,
			ComponentListener listener) {
		super(container, image, x, y, listener);
	}

}
