package vote;

import cartes.Senateur;

public abstract class ResultatVote {
	protected Senateur	votant;

	public ResultatVote(Senateur senateur) {
		this.votant = senateur;
	}

	/**
	 * Methode qui permet d'obtenir la valeur d'influence ajoutee lors d'un vote
	 * 
	 * @return la valeur du vote
	 */
	public abstract int getValue();
}
