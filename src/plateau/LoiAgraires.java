package plateau;

public class LoiAgraires {
	protected LoiAgraire1 loiAgraire1;
	protected LoiAgraire2 loiAgraire2;
	protected LoiAgraire3 loiAgraire3;

	public LoiAgraires() {

	}

	/**
	 * Acitve une loi agraire
	 * 
	 * @param loi
	 *            : la loi a activer
	 * @return true si la loi est active
	 */
	public boolean activerLoi(LoiAgraire loi) {
		loi.activer();
		return loi.estActive();
	}

	/**
	 * Abroge une loi agraire
	 * 
	 * @param loi
	 *            : la loi a abroger
	 * @return false si la loi n'est pas active
	 */
	public boolean abrogerLoi(LoiAgraire loi) {
		loi.abroger();
		return loi.estActive();
	}

	/**
	 * Paye le couts des lois agraires
	 * 
	 * @return le cout total des lois agraires
	 */
	public int payerCouts() {
		return loiAgraire1.payerCout() + loiAgraire2.payerCout()
				+ loiAgraire3.payerCout();

	}
}
