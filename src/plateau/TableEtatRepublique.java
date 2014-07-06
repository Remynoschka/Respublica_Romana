/**
 * 
 */
package plateau;

/**
 * Classe modelisant le table d'etat de la republique
 * 
 * @author Remynoschka
 * 
 */
public class TableEtatRepublique {

	// TODO completer les effets de la table d'etat de la rep
	public static void doEffects(int jet) {
		switch (jet) {
			case 17:
				Rome.INSTANCE.modifierMecontentement(-2);
				break;
			case 16:
				Rome.INSTANCE.modifierMecontentement(-1);
				break;
			case 10:
				Rome.INSTANCE.modifierMecontentement(+1);
				break;
			case 9:
				Rome.INSTANCE.modifierMecontentement(+2);
				break;
			case 8:
				Rome.INSTANCE.modifierMecontentement(+3);
				break;
			case 7:
				Rome.INSTANCE.modifierMecontentement(+3);
				// ri
				break;
			case 6:
				Rome.INSTANCE.modifierMecontentement(+4);
				break;
			case 5:
				Rome.INSTANCE.modifierMecontentement(+4);
				Rome.INSTANCE.augmenterRI();
				break;
			case 4:
				Rome.INSTANCE.modifierMecontentement(+5);
				break;
			case 3:
				Rome.INSTANCE.modifierMecontentement(+5);
				Rome.INSTANCE.augmenterRI();
				break;
			case 2:
				Rome.INSTANCE.modifierMecontentement(+5);
				Rome.INSTANCE.desactiverRecrutement();
				break;
			case 1:
				Rome.INSTANCE.modifierMecontentement(+5);
				Rome.INSTANCE.desactiverRecrutement();
				Rome.INSTANCE.emeute();
				break;
			case 0:
				Rome.INSTANCE.modifierMecontentement(+6);
				Rome.INSTANCE.desactiverRecrutement();
				Rome.INSTANCE.emeute();
				break;
			default:
				if (jet >= 18) {
					Rome.INSTANCE.modifierMecontentement(-3);
				} else if (jet < 0) {
					// TODO soulevement de la plebe
				}
				break;
		}
	}
}
