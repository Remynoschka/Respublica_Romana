/**
 * 
 */
package jeu;

import cartes.Senateur;
import plateau.Rome;
import evenements.Evenement;

/**
 * Classe simulant la phase de forum
 * 
 * @author Remynoschka
 * 
 */
public class PhaseForum implements PhaseJeu {
	public static final PhaseForum INSTANCE = new PhaseForum();

	@Override
	public void jouer() {
		// Passage du temps
		for (Evenement e : Partie.PARTIE_EN_COURS.getEvenementsActifs()) {
			e.reinit();
		}
		// Initiative
		
		// Mettre de l'ordre
		for (Senateur s : Rome.INSTANCE.getSenateursAvecTitre().values()){
			s.setMajeur();
		}
		// jets de concessions detruites
		
		// mettre l'ordre a la curie
		Rome.INSTANCE.getCurie().mettreOrdre();
	}

}
