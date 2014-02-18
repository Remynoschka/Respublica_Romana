package plateau;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import main.Main;

import cartes.Senateur;

import jeu.Armee;
import jeu.Flotte;
import jeu.Legion;

/**
 * Classe qui definit les armees en garnison a Rome
 * 
 * @author Remynoschka
 * 
 */
public class ArmeeReserve {

	private Rome rome;
	private TreeMap<Integer, Legion> legions;
	private ArrayList<Flotte> flottes;
	private int dernierNumLegionUtilise;
	private int dernierNumFlotteUtilise;
	public static final int PRIX_RECRUTEMENT = 10;
	private ArrayList<Armee> armees; // les armees sur le terrain

	// ------------------------------------------------------------------------
	public ArmeeReserve(Rome rome, int nbLegion) {
		this.rome = rome;
		legions = new TreeMap<Integer, Legion>();
		flottes = new ArrayList<Flotte>();
		armees = new ArrayList<Armee>();
		dernierNumLegionUtilise = 0;
		dernierNumFlotteUtilise = 0;
		for (int i = 0; i < nbLegion; i++) {
			dernierNumLegionUtilise++;
			legions.put(dernierNumLegionUtilise, new Legion(
					dernierNumLegionUtilise));
		}
		System.out.println(legions);
		System.out.println(flottes);
	}

	// ------------------------------------------------------------------------
	/**
	 * Methode qui creer et ajoute des nouvelles legions a Rome
	 * 
	 * @param nb
	 *            : le nombre de legions
	 */
	public void recruterLegions(int nb) {
		if (rome.peutRecruter()) {
			// calcul du prix total de recrutement
			int prix = PRIX_RECRUTEMENT * nb * rome.valeurRI();
			if (prix > rome.getArgent()) {
				System.out
						.println("Rome n'a pas assez d'argent pour acheter autant de l�gions.");
			} else {
				// creer et ajouter les legions
				for (int i = 0; i < nb; i++) {
					dernierNumLegionUtilise++;
					legions.put(dernierNumLegionUtilise, new Legion(
							dernierNumLegionUtilise));
				}
				// retirer l'argent du coffre de Rome
				rome.retirerArgent(prix);
			}
		} else
			System.out.println("Rome ne peut pas recruter de troupes.");
		if (Main.debug) {
			System.out.println(legions.toString());
		}
	}

	/**
	 * Methode qui creer et ajoute des nouvelles flottes a Rome
	 * 
	 * @param nb
	 *            : le nombre de flottes
	 */
	public void recruterFlottes(int nb) {
		if (rome.peutRecruter()) {
			// calcul du prix total de recrutement
			int prix = PRIX_RECRUTEMENT * nb * rome.valeurRI();
			if (prix > rome.getArgent()) {
				System.out
						.println("Rome n'a pas assez d'argent pour acheter autant de flottes.");
			} else {
				// creer et ajouter les flottes
				for (int i = 0; i < nb; i++) {
					dernierNumFlotteUtilise++;
					flottes.add(new Flotte(dernierNumFlotteUtilise));
				}
				// retirer l'argent du coffre de Rome
				rome.retirerArgent(prix);
			}
		} else
			System.out.println("Rome ne peut pas recruter de troupes.");
		if (Main.debug) {
			System.out.println(flottes.toString());
		}
	}

	// ------------------------------------------------------------------------

	/**
	 * Methode qui permet d'assigner des troupes a un senateur
	 * 
	 * @param senateur
	 *            : le senateur qui controlera l'armee
	 * @return L'armee assignee au senateur
	 */
	public Armee assignerArmee(Senateur senateur) {

		// choix des legions
		boolean ok = false;
		ArrayList<Legion> legionsAssign = new ArrayList<Legion>();
		while (!ok) {
			System.out
					.println("Arreter de choisir des l�gions ? (1 : oui, 0 : non)");
			if (Main.scanDebug.nextInt() == 1)
				ok = true;
			if (Main.debug && !ok) {
				System.out.println("Choisir une l�gion :");
				int numLegion = Main.scanDebug.nextInt();
				if (!legions.containsKey(new Integer(numLegion))) {
					System.out.println("Rome n'a pas la l�gion indiqu�e");
				} else {
					// ajouter legions a la liste et la retirer des reserves
					legionsAssign.add(legions.get(new Integer(numLegion)));
					legions.remove(new Integer(numLegion));
				}
			} else if (!ok) {
				// TODO facon normale de choix de legions
			}

		}
		// TEST listes de legions-----------------------------------
		if (Main.debug) {
			System.out.println("TEST LISTE LEGIONS");
			for (Legion legion : legions.values())
				System.out.print(legion.getNumLegion() + " | ");
			System.out.println("");
			Iterator<Legion> it = legionsAssign.iterator();
			while (it.hasNext())
				System.out.print(it.next().getNumLegion() + " | ");
			System.out.println("");
		}
		// -----------------------------------------------------------

		// choix des flottes
		int nbFlottes = -1;
		ArrayList<Flotte> flottesAssign = new ArrayList<Flotte>();
		while (nbFlottes < 0) {
			if (Main.debug) {
				System.out.println("Nombre de flottes :");
				nbFlottes = Main.scanDebug.nextInt();
			} else {
				// TODO facon normale de choix de flottes
			}
			if (nbFlottes > flottes.size()) {
				System.out.println("Il n'y a pas assez de flottes � Rome.");
				nbFlottes = -1;
			}

		}
		// selectionner les flottes
		for (int i = 0; i < nbFlottes; i++) {
			flottesAssign.add(flottes.get(i));
			flottes.remove(i);
		}
		// TEST listes de flotte-----------------------------------
		if (Main.debug) {
			System.out.println("TEST LISTE FLOTTES");
			Iterator<Flotte> it = flottes.iterator();
			while (it.hasNext())
				System.out.print(it.next().getNumFlotte() + " | ");
			System.out.println("");
			it = flottesAssign.iterator();
			while (it.hasNext())
				System.out.print(it.next().getNumFlotte() + " | ");
			System.out.println("");
		}
		// -----------------------------------------------------------
		// Creation de l'armee
		Armee armee = new Armee(senateur, legionsAssign, flottesAssign);
		armees.add(armee);
		return armee;
	}

	// ------------------------------------------------------------------------
	/**
	 * Methode pour l'entretient des troupes alignes a Rome. Possibilite de
	 * defaite des joueurs
	 * 
	 * @return l'argent restant dans les caisses de Rome
	 * 
	 */
	public int entretient() {
		int prix = 0;
		prix += legions.size() * 2 + flottes.size() * 2;
		for (Armee armee : armees) {
			if (!armee.estRebelle()) {
				prix += armee.getLegions().size() * 2
						+ armee.getFlottes().size() * 2;
			}
		}
		// TODO legions relaches par un rebelle
		// TODO Si on peut pas payer
		rome.retirerArgent(prix);
		return rome.getArgent();
	}

	// ------------------------------------------------------------------------
	/**
	 * Methode pour le retour d'une armee a Rome. Desassigne l'armee au senateur
	 * et remet les legions et les flottes dans les reserves.
	 * 
	 * @param armee
	 *            : l'armee qui rentre a Rome.
	 */
	public void retourArmee(Armee armee) {
		for (Legion legion : armee.getLegions()) {
			legions.put(legion.getNumLegion(), legion);
		}
		flottes.addAll(armee.getFlottes());
		armee.getChef().desassignerArmee();
	}
	
	// -------------------------------------------------------------------------
	public int getNbLegionsDisponibles(){
		return legions.size();
	}
	
	public int getNbEscadresDisponibles(){
		return flottes.size();
	}
	
	public int getNbVeteransDisponibles(){
		List<Legion> veterans = new ArrayList<Legion>();
		for (Legion l : legions.values()){
			if (l.estVeteran()){
				veterans.add(l);
			}
		}
		return veterans.size();
	}
}
