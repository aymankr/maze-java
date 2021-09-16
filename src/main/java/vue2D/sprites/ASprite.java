/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
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
    private int nbDecalages;
    private int decalageX;
    private int decalageY;
    private Salle posDepart;
    private Salle posChoisie;
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

        if (!enDeplacement) {
            posDepart = position;
            posChoisie = positionChoisie;
            enDeplacement = true;

            decalageX = positionChoisie.getX() - posDepart.getX();
            decalageY = positionChoisie.getY() - posDepart.getY();
        }

        if (enDeplacement) {
            nbDecalages++;
            int ajoutX = nbDecalages * decalageX;
            int ajoutY = nbDecalages * decalageY;
            g.drawImage(image, posDepart.getX() * unite + ajoutX, posDepart.getY() * unite + ajoutY, unite, unite);

            if (posDepart.getX() * unite + ajoutX == posChoisie.getX() * unite
                    && posDepart.getY() * unite + ajoutY == posChoisie.getY() * unite) {
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
