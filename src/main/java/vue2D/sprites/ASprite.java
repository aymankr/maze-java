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
    private final int unite = 15;
    boolean enDeplacement;
    private int x;
    private int y;
    private Salle posInitiale;
    private Salle posChoisie;

    public ASprite(IPersonnage p, ILabyrinthe l) {
        IPerso = p;
        labyrinthe = l;
        enDeplacement = false;
    }

    @Override
    public void dessiner(GraphicsContext g) {

        int ajoutX = 0;
        int ajoutY = 0;
        if (enDeplacement) {
            ajoutX = posChoisie.getX() - posInitiale.getX();
            ajoutY = posChoisie.getY() - posInitiale.getY();

            setCoordonnees(ajoutX, ajoutY);
            enDeplacement = !(x == posChoisie.getX() * unite && y == posChoisie.getY() * unite);
        }

        g.drawImage(image, x + ajoutX, y + ajoutY, unite, unite);
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (!enDeplacement) {
            ISalle s = IPerso.faitSonChoix(sallesAccessibles);
            enDeplacement = (s != this.getPosition());
            posInitiale = this.getPosition();
            x = posInitiale.getX()*unite;
            y = posInitiale.getY()*unite;
            posChoisie = (Salle) s;
            return s;
        }
        return IPerso.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {
        IPerso.setPosition(s);
    }

    @Override
    public Salle getPosition() {
        return (Salle) IPerso.getPosition();
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        x += xpix;
        y += ypix;
    }
}
