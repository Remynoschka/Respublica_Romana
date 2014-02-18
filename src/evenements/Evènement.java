package evenements;

public abstract class Evènement {
	protected int id;
	protected EffetEvent premierEffet;
	protected EffetEvent secondEffet;
	protected int countEvent; // le nombre de fois que cet event est tombe

	/**
	 * Applique les effets de l'evenements (ou les aggraves)
	 */
	public void spawn() {
		if (countEvent == 0) {
			premierEffet.doAction();
		} else {
			secondEffet.doAction();
		}
	}

	/**
	 * Retire l'evenement et annule tout ses effets.
	 */
	public void reinit() {
		for (int i = countEvent; i > 0; i--) {
			secondEffet.remove();
		}
		countEvent = 0;
		premierEffet.remove();
	}

}
