package vote;

import cartes.Senateur;

public class Oui extends ResultatVote {

	public Oui(Senateur senateur) {
		super(senateur);
	}

	@Override
	public int getValue() {

		return this.votant.getVoix();
	}

}
