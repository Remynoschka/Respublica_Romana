/**
 * 
 */
package evenements;

import java.util.HashMap;
import java.util.Map;

import jeu.Ere;

/**
 * Table des evenements
 * 
 * @author Remynoschka
 * 
 */
public class TableEvents {
	public static final TableEvents HAUTE_REPUBLIQUE = constructTableHR();
	public static final TableEvents MOYENNE_REPUBLIQUE = constructTableMR();
	public static final TableEvents BASSE_REPUBLIQUE = constructTableBR();

	private Map<Integer, Evenement> table;

	public TableEvents() {
		table = new HashMap<Integer, Evenement>();
	}

	private static TableEvents constructTableHR() {
		TableEvents table = new TableEvents();
		// TODO ajouter les evenements
		return table;
	}

	private static TableEvents constructTableMR() {
		TableEvents table = new TableEvents();
		// TODO ajouter les evenements
		return table;
	}

	private static TableEvents constructTableBR() {
		TableEvents table = new TableEvents();
		// TODO ajouter les evenements
		return table;
	}

	public static Evenement getEvent(int de, Ere ere) {
		Evenement evt = null;
		switch (ere) {
		case HAUTE_REPUBLIQUE:
			evt = HAUTE_REPUBLIQUE.table.get(de);
			break;
		case MOYENNE_REPUBLIQUE:
			evt = MOYENNE_REPUBLIQUE.table.get(de);
			break;
		case BASSE_REPUBLIQUE:
			evt = BASSE_REPUBLIQUE.table.get(de);
			break;
		}
		return evt;
	}
}
