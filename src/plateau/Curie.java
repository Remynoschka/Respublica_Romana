package plateau;

import exception.NbDeException;

/**
 * La curie comprenant les concessions detruites, les senateurs decedes et les
 * chefs sans guerre
 * 
 * @author Remynoschka
 * 
 */
public class Curie {
	private ReleveSenatoriale		senateurs;
	private ConcessionsDetruites	concessions;
	private Chefs					chefs;

	public Curie() {
		senateurs = new ReleveSenatoriale();
		concessions = new ConcessionsDetruites();
		chefs = new Chefs();
	}

	/**
	 * Fin de phase de Forum pour la curie
	 * 
	 * @throws NbDeException
	 */
	public void mettreOrdre() {
		try {
			chefs.mettreOrdre();
			senateurs.mettreOrdre();
			concessions.mettreOrdre();
		} catch (NbDeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param chefs
	 *            the chefs to set
	 */
	public void setChefs(Chefs chefs) {
		this.chefs = chefs;
	}

	/**
	 * @return the chefs
	 */
	public Chefs getChefs() {
		return chefs;
	}

	/**
	 * @param concessions
	 *            the concessions to set
	 */
	public void setConcessionsDetruites(ConcessionsDetruites concessions) {
		this.concessions = concessions;
	}

	/**
	 * @return the concessions
	 */
	public ConcessionsDetruites getConcessionsDetruites() {
		return concessions;
	}

	/**
	 * @param senateurs
	 *            the senateurs to set
	 */
	public void setReleveSenatoriale(ReleveSenatoriale senateurs) {
		this.senateurs = senateurs;
	}

	/**
	 * @return the senateurs
	 */
	public ReleveSenatoriale getReleveSenatoriale() {
		return senateurs;
	}

}
