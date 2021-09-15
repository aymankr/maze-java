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
    int x;
    int y;
    Salle posPrecedent;
    boolean enDeplacement;

    public ASprite(IPersonnage p, ILabyrinthe l) {
        x = 0;
        y = 0;
        IPerso = p;
        labyrinthe = l;
        enDeplacement = false;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        int unite = 15;
        Salle position = (Salle) IPerso.getPosition();
        Salle positionChoisie = (Salle) IPerso.faitSonChoix(labyrinthe);

        if (position != positionChoisie) {
            posPrecedent = position;
        }

        int deplaceX = 0;
        int deplaceY = 0;
        if (posPrecedent != null) {
            if (posPrecedent.getX() > positionChoisie.getX()) {
                deplaceX = -1;
            } else if (posPrecedent.getX() < positionChoisie.getX()) {
                deplaceX = 1;
            }

            if (posPrecedent.getY() > positionChoisie.getY()) {
                deplaceY = -1;
            } else if (posPrecedent.getY() < positionChoisie.getY()) {
                deplaceY = 1;
            }
        }

        if (posPrecedent != null) {
            enDeplacement = true;
            setCoordonnees(deplaceX, deplaceY);
            g.drawImage(image, posPrecedent.getX() * unite + x, posPrecedent.getY() * unite + y, unite, unite);
            if (posPrecedent.getX() * unite + x == positionChoisie.getX() * unite && posPrecedent.getY() * unite + y == positionChoisie.getY() * unite) {
                posPrecedent = null;
                x = y = 0;
                enDeplacement = false;
            }
        } else {
            g.drawImage(image, position.getX() * unite, position.getY() * unite, unite, unite);
        }
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        x += xpix;
        y += ypix;
    }
}
