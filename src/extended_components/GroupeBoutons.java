package extended_components;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de gérer un ensemble de bouton groupable.
 * 
 * @author Remynoschka
 * 
 */
public class GroupeBoutons {
	private List<BoutonGroupable> boutons;
	
	public GroupeBoutons(){
		boutons = new ArrayList<BoutonGroupable>();
	}
	
	public GroupeBoutons(List<BoutonGroupable> liste){
		this.boutons = liste;
	}

	/**
	 * Ajoute un bouton a ce groupe de bouton
	 * 
	 * @param bouton
	 *            : le bouton a ajouter
	 */
	public void add(BoutonGroupable bouton) {
		this.boutons.add(bouton);
		bouton.setGroupe(this);
	}

	/**
	 * Deselectionne tout les boutons sauf celui passe en parametre qui
	 * correspond a celui selectionne
	 * 
	 * @param selected
	 *            : le bouton selectionne
	 */
	public void deselectAll(BoutonGroupable selected) {
		for (BoutonGroupable bouton : boutons) {
			if (bouton != selected)
				bouton.deselectionner();
		}
	}
}
