/**
 * 
 */
package proces;

import jeu.De;
import cartes.Senateur;
import exception.NbDeException;

/**
 * Classe definissant les caracteristiques d'un proces
 * 
 * @author Remynoschka
 * 
 */
public abstract class Proces {
	protected Senateur		accuse, accusateur;
	public static final int	APPEL_PEUPLE_ACCUSE_TUE		= -1;
	public static final int	APPEL_PEUPLE_ACCUSE_LIBERE	= 1;

	public Proces(Senateur accuse, Senateur accusateur) {
		this.accusateur = accusateur;
		this.accuse = accuse;
	}

	public boolean lancerProces() {
		boolean result = false;
		int appelPeuple = appelPeuple();
		switch (appelPeuple) {
			case APPEL_PEUPLE_ACCUSE_TUE:
				break;
			case APPEL_PEUPLE_ACCUSE_LIBERE:
				break;
		}
		// Rome.rome.getSenateursAvecTitre().get(Censeur.INSTANCE.getRangTitre());
		consequenceProces();
		return result;
	}

	public abstract void consequenceProces();

	/**
	 * Fais l'appel au peuple
	 * 
	 * @return : le nombre de voix supplementaire
	 */
	public int appelPeuple() {
		try {
			int jet = De.jet(2) - De.getMauvaisPresage();
			jet += accuse.getPopularite();
			switch (jet) {
				case 3:
					return -16;
				case 4:
					return -12;
				case 5:
					return -8;
				case 6:
					return -4;
				case 7:
					return 0;
				case 8:
					return 4;
				case 9:
					return 8;
				case 10:
					return 12;
				case 11:
					return 16;
				default:
					if (jet <= 2) {
						return APPEL_PEUPLE_ACCUSE_TUE;
					} else if (jet >= 12) {
						return APPEL_PEUPLE_ACCUSE_LIBERE;
					}
					break;

			}
		} catch (NbDeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
