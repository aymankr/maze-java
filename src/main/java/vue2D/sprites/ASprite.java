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
    int xpix, ypix;

    public ASprite(IPersonnage p, ILabyrinthe l) {
        int xpix = 0;
        int ypix = 0;
        IPerso = p;
        labyrinthe = l;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        int unite = 15;
        Salle positionChoisie = (Salle) IPerso.faitSonChoix(labyrinthe);
        Salle position = (Salle) IPerso.getPosition();

        int deplaceX = 1;
        int deplaceY = 1;

        if (position.getX() * unite > positionChoisie.getX() * unite) {
            deplaceX *= -1;
        }

        if (position.getY() * unite > positionChoisie.getY() * unite) {
            deplaceY *= -1;
        }

        if (positionChoisie != position) {
            xpix += deplaceX;
            ypix += deplaceY;
        }

        g.drawImage(image, IPerso.getPosition().getX() * unite + xpix, IPerso.getPosition().getY() * unite + ypix, unite, unite);
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {

    }
}
