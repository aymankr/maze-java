/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import personnages.IPersonnage;

/**
 *
 * @author aykachmar
 */
public abstract class ASprite implements ISprite {

    IPersonnage IPerso;
    Image image;

    public ASprite(IPersonnage p) {
        IPerso = p;
    }
    
    @Override
    public void dessiner(GraphicsContext g) {
        int unite = 15;
        g.drawImage(image, IPerso.getPosition().getX()*unite, IPerso.getPosition().getY()*unite, unite, unite);
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        
    }
}