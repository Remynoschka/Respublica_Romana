package plateau;

import java.util.ArrayList;
import java.util.List;

public class LoiAgraires {

	protected List<LoiAgraire> lois;

	public LoiAgraires() {
		lois = new ArrayList<LoiAgraire>();
		lois.add(new LoiAgraire1());
		lois.add(LoiAgraire.buildLoiAgraire2());
		lois.add(LoiAgraire.buildLoiAgraire2());
		lois.add(LoiAgraire.buildLoiAgraire3());
		lois.add(LoiAgraire.buildLoiAgraire3());
		lois.add(LoiAgraire.buildLoiAgraire3());
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
		int cout = 0;
		for (LoiAgraire l : lois) {
			cout += l.payerCout();
		}
		return cout;
	}
}
