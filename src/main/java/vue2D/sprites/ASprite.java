/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import static java.lang.Math.abs;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.IPersonnage;

/**
 *
 * @author aykachmar
 */
public abstract class ASprite implements ISprite {

    IPersonnage IPerso;
    Image image;
    ILabyrinthe labyrinthe;
    int nbDecalages;
    int decalageX;
    int decalageY;
    Salle posPrecedent;
    boolean enDeplacement;

    public ASprite(IPersonnage p, ILabyrinthe l) {
        nbDecalages = decalageX = decalageY = 0;
        IPerso = p;
        labyrinthe = l;
        enDeplacement = false;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        int unite = 15;
        Salle position = (Salle) IPerso.getPosition();
        Salle positionChoisie = (Salle) IPerso.faitSonChoix(labyrinthe.sallesAccessibles(IPerso));

        if (position != positionChoisie && !enDeplacement) {
            posPrecedent = position;
            enDeplacement = true;

            if (posPrecedent.getX() > positionChoisie.getX()) {
                decalageX = -1;
            } else if (posPrecedent.getX() < positionChoisie.getX()) {
                decalageX = 1;
            }

            if (posPrecedent.getY() > positionChoisie.getY()) {
                decalageY = -1;
            } else if (posPrecedent.getY() < positionChoisie.getY()) {
                decalageY = 1;
            }
        }

        if (enDeplacement) {
            nbDecalages++;
            int ajoutX = nbDecalages * decalageX;
            int ajoutY = nbDecalages * decalageY;
            g.drawImage(image, posPrecedent.getX() * unite + ajoutX, posPrecedent.getY() * unite + ajoutY, unite, unite);
            
            if (posPrecedent.getX() * unite + ajoutX == positionChoisie.getX() * unite
                    && posPrecedent.getY() * unite + ajoutY == positionChoisie.getY() * unite) {
                nbDecalages = decalageX = decalageY = 0;
                enDeplacement = false;
            }
        } else {
            g.drawImage(image, position.getX() * unite, position.getY() * unite, unite, unite);
        }
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        
    }
}
