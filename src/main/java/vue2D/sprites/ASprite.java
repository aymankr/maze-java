/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
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
    boolean enDeplacement;
    private int nbDecalages;
    private int decalageX;
    private int decalageY;
    private Salle posDepart;
    private Salle posChoisie;

    public ASprite(IPersonnage p, ILabyrinthe l) {
        nbDecalages = decalageX = decalageY = 0;
        IPerso = p;
        labyrinthe = l;
        enDeplacement = false;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        int unite = 15;

        if (!enDeplacement) {
            enDeplacement = true;
            posDepart = (Salle) IPerso.getPosition();
           

            decalageX = posChoisie.getX() - posDepart.getX();
            decalageY = posChoisie.getY() - posDepart.getY();
        }

        if (enDeplacement) {
            nbDecalages++;
            int ajoutX = nbDecalages * decalageX;
            int ajoutY = nbDecalages * decalageY;
            g.drawImage(image, posDepart.getX() * unite + ajoutX, posDepart.getY() * unite + ajoutY, unite, unite);
            
            System.out.println("pos graphique : " + (posDepart.getX() * unite + ajoutX) + ", " + (posDepart.getY() * unite + ajoutY));
            System.out.println("pos destination : " + (posChoisie.getX() * unite) + ", " + (posChoisie.getY() * unite));

            if (posDepart.getX() * unite + ajoutX == posChoisie.getX() * unite
                    && posDepart.getY() * unite + ajoutY == posChoisie.getY() * unite) {
                nbDecalages = decalageX = decalageY = 0;
                enDeplacement = false;
            }
        } else {
            g.drawImage(image, posDepart.getX() * unite, posDepart.getY() * unite, unite, unite);
        }
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (!enDeplacement) {
            ISalle s  = IPerso.faitSonChoix(sallesAccessibles);
            enDeplacement = (s != this.getPosition());
            return s;
        }
        return IPerso.getPosition();
    }
    
    @Override
    public void setPosition(ISalle autre) {
        posChoisie = (Salle) IPerso.getPosition();
    }
    
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        x +=
    }
}
