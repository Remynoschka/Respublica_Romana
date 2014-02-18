package jeu;

public enum Ere {
	HAUTE_REPUBLIQUE(0), MOYENNE_REPUBLIQUE(1), BASSE_REPUBLIQUE(2);

	private Ere(int val) {
		this.val = val;
	}

	private int val;

	public int getVal() {
		return val;
	}
}
