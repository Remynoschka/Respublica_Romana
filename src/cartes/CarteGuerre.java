package cartes;

import java.util.List;

import jeu.Armee;
import jeu.Ere;

public class CarteGuerre extends Carte {
	protected List<CarteGuerre> guerresAffiliees; // Juste pour donnees
	protected List<CarteChef> chefsAffilies; // Juste pour donnees
	protected List<CarteChef> chefsActifs; // Les chefs actifs sur cette guerre
	protected int forceTerrestre;
	protected int soutientNaval;
	protected int batailleNavale;

	protected boolean disette; // poss�de un effet de disette
	protected int or; // or gagne avec la guerre

	protected int[] desastre = new int[2];
	protected int[] retraite = new int[2];

	public boolean active; // si la guerre est activee directement

	// ------------------------------------------------------------------------
	public CarteGuerre(String nom, Ere ere) {
		super(nom, ere);
		// TODO Auto-generated constructor stub
	}

	// ------------------------------------------------------------------------
	/**
	 * Combattre la carte guerre avec une ou plusieurs armees
	 * 
	 * @param armees
	 *            : la listes des armees qui combattent la guerre
	 * @return true si la guerre a ete gagnee par Rome
	 */
	public boolean combattre(List<Armee> armees) {
		return false;
	}

	/* (non-Javadoc)
	 * @see cartes.Carte#pioche()
	 */
	@Override
	public void pioche() {
		// TODO carte guerre piochee
		
	}
	
	
}
