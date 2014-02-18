package vote;

import cartes.Senateur;

public class Non extends ResultatVote {

	public Non(Senateur senateur) {
		super(senateur);
	}

	@Override
	public int getValue() {
		return -this.votant.getVoix();
	}

}
