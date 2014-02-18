package joueurs;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;

import cartes.Carte;
import cartes.Senateur;

/**
 * Classe pour definir un joueur
 *
 * @author Remynoschka
 *
 */
public class Joueur {

    protected String nom; // Nom du joueur
    protected int talentsCoffre; // talents dans le coffre de faction	
    protected List<Senateur> senateurs; // les senateurs poses
    protected List<Carte> mainCarte; // les cartes en main
    protected Image imgFaction;

    public Joueur(String nom, ArrayList<Carte> mainDepart, Image img) {
        this.nom = nom;
        mainCarte = mainDepart;
        senateurs = new ArrayList<Senateur>();
        this.imgFaction = img;
    }

    // ------------------------------------------------------------------------
    public int getArgentCoffre() {
        return talentsCoffre;
    }

    public int getNbVoix() {
        int voix = 0;
        for (Senateur s : senateurs) {
            voix += s.getEloquance();
            voix += s.getNbChevaliers();
        }
        return voix;
    }

    public boolean addSenateurs(Senateur senateur) {
        // TODO modifier la methode d'ajout de senateurs en prenant en compte
        // certains parametres
        return this.senateurs.add(senateur);
    }
    
    public boolean perdSenateurs(Senateur senateur) {
        // TODO modifier la methode d'ajout de senateurs en prenant en compte
        // certains parametres
        return this.senateurs.remove(senateur);
    }

    public List<Senateur> getSenateurs() {
        return this.senateurs;
    }

    public int ajouterArgentCoffre(int nb) {
        talentsCoffre += nb;
        return talentsCoffre;
    }

    public void designerNouveauChef(Senateur senateur) {
        if (senateurs.contains(senateur)) {
            for (Senateur chef : senateurs) {
                if (chef.estChefFaction()) {
                    chef.perdreChefFaction();
                }
            }
            senateur.devientChefFaction();
        }
    }

    public String getNom() {
        return nom;
    }
    
    public Image getSymbole(){
        return imgFaction;
    }
}
