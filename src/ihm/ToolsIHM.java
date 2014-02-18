/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.Component;
import java.awt.Image;

/**
 * Classe contenant plusieurs fonctions utiles
 *
 * @author Remynoschka
 */
public class ToolsIHM {

    /**
     * Redimensionne une image.
     *
     * @param source Image à redimensionner.
     * @param w Largeur de l'image cible.
     * @param h Hauteur de l'image cible.
     * @return Image redimensionnée.
     */
    public static Image redimmensionnerImage(Image i, int w, int h) {
        i = i.getScaledInstance(w, h, Image.SCALE_DEFAULT);        
        
        return i;
    }

    /**
     * Methode qui permet de placée une fenetre au centre de l'écran
     *
     * @param fenetre : la fenêtre à placer
     */
    public static void mettreAuCentre(Component fenetre) {
        fenetre.setLocation(ConfigMonitors.getGraphicsDevice().getDisplayMode().getWidth()
                / 2 - fenetre.getWidth() / 2, ConfigMonitors.getGraphicsDevice().getDisplayMode().getHeight()
                / 2 - fenetre.getHeight() / 2);
    }
}
