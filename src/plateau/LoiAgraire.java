package plateau;

/**
 * Classe decrivant une loi agraire et les operations possible sur elle. Elle
 * decrit egalement les bonus qu'elle procure. Cependant, elle ne gere pas les
 * actions en relation avec le vote telle qu'appliquer un bonus a l'initiateur.
 * Elle ne connais que la valeur de ce bonus
 * 
 * @author Remynoschka
 * 
 */
public class LoiAgraire {
	protected int		couts;
	protected boolean	estActive	= false;
	protected int		modificateurMecontentement;
	protected int		initiateur;
	protected int		coinitiateur;
	protected int		opposant;

	/**
	 * 
	 * @param couts
	 *            : le cout de la loi agraire
	 * @param modificateur
	 *            : le modificateur de mecontentement
	 * @param initiateur
	 *            : le bonus de pop de l'initiateur
	 * @param coninitiateur
	 *            : le bonus de pop du coinitiateur
	 * @param opposant
	 *            : le malus de pop de l'opposant
	 */
	protected LoiAgraire(int couts, int modificateur, int initiateur,
			int coinitiateur, int opposant) {
	}

	/**
	 * Creer une instance de LoiAgraire correspondant au type 2
	 * 
	 * @return une loi agraire de type 2
	 */
	public static LoiAgraire buildLoiAgraire2() {
		return new LoiAgraire(5, 2, 2, 1, -2);
	}

	/**
	 * Creer une instance de LoiAgraire correspondant au type 3
	 * 
	 * @return une loi agraire de type 3
	 */
	public static LoiAgraire buildLoiAgraire3() {
		return new LoiAgraire(10, 3, 4, 2, -2);
	}

	/**
	 * Methode qui paye les couts de la loi
	 * 
	 * @return l'argent restant dans les caisses de Rome
	 */
	public int payerCout() {
		Rome.INSTANCE.retirerArgent(couts);
		return Rome.INSTANCE.getArgent();
	}

	/**
	 * Active une loi agraire et provoque ses effets.
	 */
	public void activer() {
		if (!estActive) {
			Rome.INSTANCE.modifierMecontentement(-modificateurMecontentement);
			estActive = true;
		}
	}

	/**
	 * Abroge une loi agraire et applique les effets.
	 */
	public void abroger() {
		Rome.INSTANCE.modifierMecontentement(modificateurMecontentement);
		this.estActive = false;
	}

	public boolean estActive() {
		return this.estActive;
	}

	public int getBonusInitiateur() {
		return initiateur;
	}

	public int getBonusCoInitiateur() {
		return coinitiateur;
	}

	public int getMalusOpposant() {
		return opposant;
	}
}
