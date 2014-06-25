/**
 * 
 */
package jeu;

import exception.NbDeException;
import plateau.Rome;
import plateau.TableEtatRepublique;

/**
 * Classe simulant la phase de plebe
 * @author Remynoschka
 * 
 */
public class PhasePlebe implements PhaseJeu {
	public static final PhasePlebe INSTANCE = new PhasePlebe();

	private PhasePlebe() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jeu.PhaseJeu#jouer()
	 */
	@Override
	public void jouer() {
		Rome.INSTANCE.modifierMecontentement(Rome.INSTANCE.getGuerres()
				.getGuerresNonEntreprises().size());
		Rome.INSTANCE.modifierMecontentement(Rome.INSTANCE.getDisette());
		// Etat de la Republique
		try {
			int de = De.jet(3) - De.getMauvaisPresage();
			de -= Rome.INSTANCE.getAgitationSociale();
			de += Partie.PARTIE_EN_COURS.getSPHR().getPopularite();
			TableEtatRepublique.doEffects(de);
		} catch (NbDeException e) {
		}
	}
}
