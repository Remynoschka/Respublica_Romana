package plateau;

public class LoiAgraire1 extends LoiAgraire {

	public LoiAgraire1(){
		this.couts = 20;
		this.estActive = false;
	}
	
	@Override
	public int payerCout(){
		if (!estActive){
			Rome.rome.retirerArgent(couts);
		}
		return Rome.rome.getArgent();
	}

	@Override
	public void activer() {
		// TODO Auto-generated method stub
		if (!estActive){
			payerCout();
			estActive = true;
		}

	}

	@Override
	public void abroger() {
		// TODO Auto-generated method stub
		if (estActive){
			
		}

	}

}
