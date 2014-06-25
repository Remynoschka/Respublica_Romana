package plateau;

import java.util.ArrayList;
import java.util.List;

import jeu.De;
import cartes.Senateur;
import exception.NbDeException;

/**
 * La releve senatoriale
 * 
 * @author Remynoschka
 * 
 */
public class ReleveSenatoriale {

	private List<Senateur> senateurs;

	public ReleveSenatoriale() {
		senateurs = new ArrayList<Senateur>();
	}

	/**
	 * Fais le rappel des senateurs decedes
	 * 
	 * @throws NbDeException
	 */
	public void mettreOrdre() throws NbDeException {
		for (Senateur s : senateurs) {
			if (De.jet(1) - De.getMauvaisPresage() >= 5) {
				// TODO remettre le senateur au forum
			}
		}
	}

	/**
	 * Ajoute un senateur a la releve senatoriale
	 * 
	 * @param s
	 *            : le senateur a ajouter
	 */
	public void ajouterSenateur(Senateur s) {
		senateurs.add(s);
	}
}
