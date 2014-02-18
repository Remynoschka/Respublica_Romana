package Actions;

import ihm.EcranPrincipal;
import ihm.Fenetre;

/**
 * Classe pour les actions des cartes Actions
 * 
 * @author Remynoschka
 * 
 */
public abstract class Action {
	/**
	 * Methode qui contient le code de l'action
	 */
	public abstract void actionPerformed();

	public static final Action REJOINDRE = new Action() {

		@Override
		public void actionPerformed() {
			// TODO Faire l'ecran pour rejoindre
			Fenetre.FENETRE.changerVueActuelle(EcranPrincipal.ID);
		}
	};

	public static final Action HEBERGER = new Action() {

		@Override
		public void actionPerformed() {
			// TODO passer a l'ecran heberger partie
			System.out.println("Heberger");
		}
	};
}
