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

    public ASprite(IPersonnage p, ILabyrinthe l) {
        IPerso = p;
        labyrinthe = l;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        int unite = 15;
        Salle positionChoisie = (Salle) IPerso.faitSonChoix(labyrinthe);
        Salle position = (Salle) IPerso.getPosition();

        int xpix = 0;
        int ypix = 0;

        int deplaceX = position.deplacementXPix(positionChoisie);
        int deplaceY = position.deplacementYPix(positionChoisie);

        while (abs(positionChoisie.getX() * unite - position.getX() * unite + xpix) < 1 || abs(positionChoisie.getY() * unite - position.getY() * unite + ypix) < 1) {
            g.drawImage(image, position.getX() * unite + xpix, position.getY() * unite + ypix, unite, unite);
            System.out.println(deplaceX +", " + deplaceY);
            xpix += deplaceX;
            ypix += deplaceY;
        }
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {

    }
}
