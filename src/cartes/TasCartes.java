package cartes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jeu.Ere;

/**
 * Classe representant le tas de carte
 * 
 * @author Remynoschka
 * 
 */
public class TasCartes {
	private List<Carte> cartes;
	private Iterator<Carte> iterator;

	/**
	 * Creation d'un nouveau tas de cartes
	 * 
	 * @param ere
	 *            : l'ere utilisee pour la partie
	 */
	public TasCartes(Ere ere) {
		cartes = new ArrayList<Carte>();
		iterator = cartes.iterator();
		// TODO creer le paquet de carte
		// TODO faire le melange de tas de 2 eres differentes
		// TODO ajouter la fin d'une ere
	}

	/**
	 * Retourne la prochaine carte du paquet
	 */
	public Carte piocher() {
		return iterator.next();
	}

	/**
	 * Melange le tas de carte
	 * 
	 * @param tas
	 *            : le tas a melanger
	 */
	public void melanger(TasCartes tas) {
		// TODO methode de melange des cartes
	}

	/**
	 * 
	 * @return le nombre de cartes restantes dans le tas
	 */
	public int getNbCartes() {
		return cartes.size();
	}
}
