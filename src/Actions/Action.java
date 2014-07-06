package Actions;

import ihm.EcranRejoindrePartie;
import ihm.EcranSalleAttente;
import ihm.Fenetre;
import main.Jeu;
import multiplayer.Serveur;

/**
 * Classe pour les actions des cartes Actions
 * 
 * @author Remynoschka
 * 
 */
public abstract class Action {
	/**
	 * Methode qui contient le code de l'action
	 */
	public abstract void actionPerformed();

	public static final Action	QUITTER		= new Action() {

												@Override
												public void actionPerformed() {
													Fenetre.FENETRE.exit();
												}
											};

	public static final Action	REJOINDRE	= new Action() {

												@Override
												public void actionPerformed() {
													Fenetre.FENETRE
															.changerVueActuelle(EcranRejoindrePartie.ID);
												}
											};

	public static final Action	HEBERGER	= new Action() {

												@Override
												public void actionPerformed() {
													Serveur.INSTANCE.start();
													((EcranSalleAttente) Jeu.INSTANCE
															.getState(EcranSalleAttente.ID))
															.setHost();
													Fenetre.FENETRE
															.changerVueActuelle(EcranSalleAttente.ID);
												}
											};

	public static final Action	CONNECTER	= new Action() {

												@Override
												public void actionPerformed() {
													Fenetre.FENETRE
															.changerVueActuelle(EcranSalleAttente.ID);
												}
											};
}
