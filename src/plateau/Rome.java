package plateau;

import java.util.ArrayList;
import java.util.List;

import jeu.Ere;
import jeu.Province;
import cartes.Senateur;

/**
 * Classe qui definit tout les parametre de Rome
 * 
 * @author Remynoschka
 * 
 */
public class Rome {
	public static Rome rome = null;
	public static final int REVENU_ETAT_BASE = 100;
	private ArmeeReserve armee; // les armees que possede Rome
	private int coffre; // le tresor de Rome
	private int mecontentement; // le niveau d'agitation sociale
	private boolean recrutement; // recrutement possible
	private List<Province> provinces; // les provinces de Rome
	private Guerres guerres; // les guerres de Rome
	private int multiplicateurRI; // valeur du recrutement inefficace
	private Forum forum;;// le forum, la ou les cartes vont etre mises
	private LoiAgraires loisAgraires;
	private ReleveSenatoriale releveSenatoriale; // Les senateurs morts

	// -------------------------------------------------------------------------

	private Rome(Ere scenar) {
		coffre = 100;
		// HAUTE REPUBLIQUE
		if (scenar.getVal() == Ere.HAUTE_REPUBLIQUE.getVal()
				|| scenar.getVal() == (Ere.HAUTE_REPUBLIQUE.getVal() | Ere.MOYENNE_REPUBLIQUE
						.getVal())
				| scenar.getVal() == (Ere.HAUTE_REPUBLIQUE.getVal()
						| Ere.MOYENNE_REPUBLIQUE.getVal() | Ere.BASSE_REPUBLIQUE
							.getVal())) {
			armee = new ArmeeReserve(this, 4);
			// MOYENNE REPUBLIQUE
		} else if (scenar.getVal() == Ere.MOYENNE_REPUBLIQUE.getVal()
				|| scenar.getVal() == (Ere.MOYENNE_REPUBLIQUE.getVal() | Ere.BASSE_REPUBLIQUE
						.getVal())) {
			armee = new ArmeeReserve(this, 6);
		}
		// BASSE REPUBLIQUE
		else {
			armee = new ArmeeReserve(this, 8);
		}
		loisAgraires = new LoiAgraires();
		guerres = new Guerres();
		recrutement = true;
		multiplicateurRI = 1;
		mecontentement = 0;
		releveSenatoriale = new ReleveSenatoriale();
		provinces = new ArrayList<Province>();

	}

	/**
	 * Creer une entite unique de Rome
	 * 
	 * @return l'entite rome
	 */
	public static Rome newRome(Ere scenar) {
		if (rome == null) {
			rome = new Rome(scenar);
			return rome;
		} else
			return rome;
	}

	// -------------------------------------------------------------------------
	/**
	 * 
	 * @return la valeur du recrutement inefficace
	 */
	public int valeurRI() {
		return multiplicateurRI;

	}

	/**
	 * 
	 * @return true si le recrutement est possible
	 */
	public boolean peutRecruter() {
		return recrutement;
	}

	// -------------------------------------------------------------------------
	/**
	 * 
	 * @return l'argent dans le coffre de Rome
	 */
	public int getArgent() {
		return coffre;
	}

	/**
	 * 
	 * @param nb
	 *            : le nombre de talents a retirer
	 * @return la nouvelle quantite de talents en reserve
	 */
	public int retirerArgent(int nb) {
		coffre -= nb;
		return coffre;
	}

	/**
	 * 
	 * @param nb
	 *            : le nombre de talents a ajouter
	 * @return la nouvelle quantite de talents en reserve
	 */
	public int ajouterArgent(int nb) {
		coffre += nb;
		return coffre;
	}

	// -------------------------------------------------------------------------
	/**
	 * Methode qui execute la phase de dettes de Rome : <br>
	 * - Guerres Actives <br>
	 * - Loi Agraires <br>
	 * - Entretien des troupes
	 * 
	 * @return la nouvelles quantite de talents dans le tresor de Rome
	 */
	public int dettes() {
		// guerres
		retirerArgent(guerres.getDettes());
		// loi agraires
		loisAgraires.payerCouts();
		// entretien des troupes
		armee.entretient();

		return coffre;
	}

	// -------------------------------------------------------------------------
	/**
	 * Modifie la valeur d'agitation sociale
	 * 
	 * @param val
	 *            : la valeur de modification d'agitation sociale
	 * @return la nouvelle valeur d'agitation sociale
	 */
	public int modifierMecontentement(int val) {
		mecontentement += val;
		return mecontentement;
	}

	public int getAgitationSociale() {
		return mecontentement;
	}

	// -------------------------------------------------------------------------
	/**
	 * Ajoute un senateur a la curie des senateurs
	 * 
	 * @param s
	 *            : Le senateur mort
	 */
	public void ajouterSenateurCurie(Senateur s) {
		releveSenatoriale.ajouterSenateur(s);
	}

	// -------------------------------------------------------------------------

	public ArmeeReserve getArmees() {
		return armee;
	}

}
