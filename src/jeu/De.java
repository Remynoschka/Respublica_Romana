package jeu;

import java.util.Random;

import exception.NbDeException;

/**
 * Classe qui s'occupe de tout les lancers de de
 * 
 * @author Remynoschka
 * 
 */
public class De {
	private static int mauvaisPresage = 0;

	/**
	 * Methodes qui execute un jet de des
	 * 
	 * @param nbDe
	 *            le nombre de des
	 * @return la valeur du lance
	 * @throws NbDeException
	 */
	public static int jet(int nbDe) throws NbDeException {
		Random de = new Random();
		if (nbDe < 1)
			throw new NbDeException();
		int result = 0;
		for (int i = 0; i < nbDe; i++) {
			result += de.nextInt(6) + 1;
		}
		return result;
	}

	/**
	 * Methode qui augmente de 1 la valeur de mauvais presage
	 */
	public static void mauvaisPresage() {
		mauvaisPresage++;
	}

	/**
	 * 
	 * @return la valeur actuelle de mauvais pr�sage
	 */
	public static int getMauvaisPresage() {
		return mauvaisPresage;
	}

	/**
	 * Methode qui reinitialise la valeur de mauvais presage a 0
	 */
	public static void reinit() {
		mauvaisPresage = 0;
	}
}
