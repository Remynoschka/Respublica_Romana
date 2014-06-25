package evenements;

import org.newdawn.slick.Image;

public abstract class EffetEvent {
	protected String description;
	protected Image icone;

	public EffetEvent(String description, Image icone) {
		this.description = description;
		this.icone = icone;
	}

	/**
	 * Ce qui est effectue par l'effet
	 */
	public abstract void doAction();

	/**
	 * Annule l'effet de l'event
	 */
	public abstract void remove();

	public String getDescription() {
		return description;
	}

	public Image getIcone() {
		return icone;
	}
}
