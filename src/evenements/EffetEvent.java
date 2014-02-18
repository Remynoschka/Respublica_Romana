package evenements;

public abstract class EffetEvent {
	
	/**
	 * Ce qui est effectue par l'effet
	 */
	public abstract void doAction();
	
	/**
	 * Annule l'effet de l'event
	 */
	public abstract void remove();
}
