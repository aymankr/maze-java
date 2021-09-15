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
    Salle posGraphique;

    public ASprite(IPersonnage p, ILabyrinthe l) {
        x = 0;
        y = 0;
        IPerso = p;
        labyrinthe = l;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        int unite = 15;
        Salle positionChoisie = (Salle) IPerso.faitSonChoix(labyrinthe);
        Salle position = (Salle) IPerso.getPosition();

        int deplaceX = 0;
        int deplaceY = 0;

        if (positionChoisie != position && position.getX() > positionChoisie.getX()) {
            deplaceX = -1;
        } else if (positionChoisie != position && position.getX() < positionChoisie.getX()){
            deplaceX = 1;
        }

        if (positionChoisie != position && position.getY() > positionChoisie.getY()) {
            deplaceY = -1;
        } else if (positionChoisie != position && position.getY() < positionChoisie.getY()){
            deplaceY = 1;
        }

        posGraphique = new Salle(position.getX() * unite + x, position.getY() * unite + y);
        if (positionChoisie != posGraphique) {
            setCoordonnees(deplaceX, deplaceY);
        } else {
            x = 0;
            y = 0;
        }

        int X = posGraphique.getX() * unite + x;
        int Y = posGraphique.getY() * unite + y;
        System.out.println(X + ", " + Y);
        g.drawImage(image, posGraphique.getX(), posGraphique.getY(), unite, unite);
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        x += xpix;
        y += ypix;
    }
}
