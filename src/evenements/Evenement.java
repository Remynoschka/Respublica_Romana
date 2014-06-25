package evenements;

public class Evenement {
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
			countEvent++;
		} else {
			secondEffet.doAction();
			countEvent++;
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

	public EffetEvent getPremierEffet() {
		return premierEffet;
	}

	public EffetEvent getDeuxiemeEffet() {
		return secondEffet;
	}

	/**
	 * Methode qui renvoie quel effet est actuellement applique
	 * 
	 * @return true si c'est le deuxieme effet, false sinon
	 */
	public boolean whichEffect() {
		return countEvent > 1;
	}

}
