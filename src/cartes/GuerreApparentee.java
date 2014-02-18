package cartes;

import java.util.List;

import jeu.Armee;
import jeu.Ere;

public class GuerreApparentee extends CarteGuerre {
	protected List<CarteGuerre> guerres;

	public GuerreApparentee(String nom, Ere ere) {
		super(nom, ere);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean combattre(List<Armee> armees){
		return false;
	}
	
	public boolean ajouterGuerre(CarteGuerre guerre){
		return guerres.add(guerre);
	}
}
