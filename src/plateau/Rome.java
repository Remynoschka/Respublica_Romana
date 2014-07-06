package plateau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jeu.Ere;
import jeu.PhaseMortalite;
import jeu.Province;
import cartes.Senateur;

/**
 * Classe qui definit tout les parametre de Rome
 * 
 * @author Remynoschka
 * 
 */
public class Rome {
	public static Rome					INSTANCE			= null;
	public static final int				REVENU_ETAT_BASE	= 100;
	protected ArmeeReserve				armee;						// les
																	// armees
																	// que
																	// possede
																	// Rome
	protected int						coffre;					// le tresor
																	// de Rome
	protected int						mecontentement;			// le niveau
																	// d'agitation
																	// sociale
	protected boolean					recrutement;				// recrutement
																	// possible
	protected List<Province>			provinces;					// les
																	// provinces
																	// de Rome
	protected Guerres					guerres;					// les
																	// guerres
																	// de Rome
	protected int						multiplicateurRI;			// valeur du
																	// recrutement
																	// inefficace
	protected Forum						forum;						;// le
																		// forum,
																		// la ou
																		// les
																		// cartes
																		// vont
																		// etre
																		// mises
	protected LoiAgraires				loisAgraires;
	protected Curie						curie;						// La curie
	protected Map<Integer, Senateur>	senateursAvecTitre;
	protected int						effetsDisette;

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
		curie = new Curie();
		provinces = new ArrayList<Province>();
		senateursAvecTitre = new HashMap<Integer, Senateur>();

	}

	/**
	 * Creer une entite unique de Rome
	 * 
	 * @return l'entite rome
	 */
	public static Rome newRome(Ere scenar) {
		if (INSTANCE == null) {
			INSTANCE = new Rome(scenar);
			return INSTANCE;
		} else
			return INSTANCE;
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
	 * Augmente la valeur du recrutement inefficace
	 * 
	 * @return la nouvelle valeur de recrutement inefficace
	 */
	public int augmenterRI() {
		multiplicateurRI++;
		return multiplicateurRI;
	}

	/**
	 * Reinitialise la valeur de recrutement inefficace
	 */
	public void reinitRI() {
		multiplicateurRI = 0;
	}

	/**
	 * 
	 * @return true si le recrutement est possible
	 */
	public boolean peutRecruter() {
		return recrutement;
	}

	public void desactiverRecrutement() {
		recrutement = false;
	}

	public void activerRecrutement() {
		recrutement = true;
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
	 * Methode qui execute la phase de revenu de Rome : <br>
	 * 
	 * @return le nouvelle quantite de talents dans le tresor de Rome
	 */
	public int revenus() {
		ajouterArgent(REVENU_ETAT_BASE);
		for (Province p : provinces) {
			p.revenusEtat();
		}
		return coffre;
	}

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

	public void emeute() {
		PhaseMortalite.INSTANCE.piocheJetons(6);
	}

	// -------------------------------------------------------------------------
	/**
	 * Ajoute un senateur a la curie des senateurs
	 * 
	 * @param s
	 *            : Le senateur mort
	 */
	public void ajouterSenateurCurie(Senateur s) {
		curie.getReleveSenatoriale().ajouterSenateur(s);
	}

	public Curie getCurie() {
		return curie;
	}

	// -------------------------------------------------------------------------
	/**
	 * Augmente les effets de disette
	 */
	public void augmenterDisette() {
		effetsDisette++;
	}

	/**
	 * Remet les effets de disette a 0
	 */
	public void reinitDisette() {
		effetsDisette = 0;
	}

	public int getDisette() {
		return effetsDisette;
	}

	// -------------------------------------------------------------------------

	public ArmeeReserve getArmees() {
		return armee;
	}

	public Map<Integer, Senateur> getSenateursAvecTitre() {
		return senateursAvecTitre;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public Guerres getGuerres() {
		return guerres;
	}
}
