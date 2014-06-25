/**
 * 
 */
package multiplayer;

/**
 * @author Remynoschka
 * 
 */
public class PaquetJoueur extends PaquetReseau {
	private int ID;
	private String name;
	private String symboleName;
	private int talentsCoffre;

	/**
	 * @return the ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param ID
	 *            the id to set
	 */
	public void setID(int id) {
		this.ID = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the symboleName
	 */
	public String getSymboleName() {
		return symboleName;
	}

	/**
	 * @param symboleName
	 *            the symboleName to set
	 */
	public void setSymboleName(String symboleName) {
		this.symboleName = symboleName;
	}

	/**
	 * @return the talentsCoffre
	 */
	public int getTalentsCoffre() {
		return talentsCoffre;
	}

	/**
	 * @param talentsCoffre
	 *            the talentsCoffre to set
	 */
	public void setTalentsCoffre(int talentsCoffre) {
		this.talentsCoffre = talentsCoffre;
	}
}
