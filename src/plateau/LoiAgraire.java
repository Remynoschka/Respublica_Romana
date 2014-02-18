package plateau;

public abstract class LoiAgraire {
	protected int couts;
	protected boolean estActive;

	public LoiAgraire() {

	}

	/**
	 * Methode qui paye les couts de la loi
	 * 
	 * @return l'argent restant dans les caisses de Rome
	 */
	public int payerCout() {
		Rome.rome.retirerArgent(couts);
		return Rome.rome.getArgent();
	}

	/**
	 * Active une loi agraire et provoque ses effets.
	 */
	public abstract void activer();

	/**
	 * Abroge une loi agraire et applique les effets.
	 */
	public abstract void abroger();

	public boolean estActive() {
		return this.estActive;
	}
}
