package plateau;

import java.util.List;

import jeu.De;
import cartes.Concession;
import exception.NbDeException;

/**
 * Les concessions a la curie
 * 
 * @author Remynoschka
 * 
 */
public class ConcessionsDetruites {

	private List<Concession>	concessions;

	/**
	 * Remets les concessions au Forum
	 * 
	 * @throws NbDeException
	 */
	public void mettreOrdre() throws NbDeException {
		for (Concession c : concessions) {
			if (De.jet(1) - De.getMauvaisPresage() >= 5) {
				// TODO remettre la concessions au forum
			}
		}
	}

	/**
	 * Ajoute une concession detruite
	 * 
	 * @param c
	 *            : la concession a ajouter
	 */
	public void ajouterConcession(Concession c) {
		concessions.add(c);
	}

}
