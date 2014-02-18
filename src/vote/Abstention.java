package vote;

import cartes.Senateur;

public class Abstention extends ResultatVote {

	public Abstention(Senateur senateur) {
		super(senateur);
	}

	@Override
	public int getValue() {
		return 0;
	}

}
