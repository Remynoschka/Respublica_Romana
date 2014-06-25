package plateau;

public class LoiAgraire1 extends LoiAgraire {

	public LoiAgraire1() {
		super(20, 1, 2, 1, -1);
	}

	@Override
	public int payerCout() {
		if (!estActive) {
			Rome.INSTANCE.retirerArgent(couts);
		}
		abroger();
		return Rome.INSTANCE.getArgent();
	}

	@Override
	public void abroger() {
		this.estActive = false;
	}

}
