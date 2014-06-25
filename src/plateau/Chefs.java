package plateau;

import java.util.List;

import jeu.De;
import cartes.CarteChef;
import exception.NbDeException;

/**
 * Les chefs a la curie
 * 
 * @author Remynoschka
 * 
 */
public class Chefs {
	private List<CarteChef> chefs;

	/**
	 * Remets les concessions au Forum
	 * 
	 * @throws NbDeException
	 */
	public void mettreOrdre() throws NbDeException {
		for (CarteChef c : chefs) {
			if (De.jet(1) - De.getMauvaisPresage() >= 5) {
				// TODO defausser le chef
			}
		}
	}

	/**
	 * Ajoute une concession detruite
	 * 
	 * @param c
	 *            : la concession a ajouter
	 */
	public void ajouterConcession(CarteChef c) {
		chefs.add(c);
	}

}
