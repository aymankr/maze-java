/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import personnages.IPersonnage;

/**
 *
 * @author aykachmar
 */
public abstract class ASprite implements ISprite {

    IPersonnage IPerso;

    public ASprite(IPersonnage p) {
        IPerso = p;
    }
    
    @Override
    public void dessiner(GraphicsContext g) {
        
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        
    }
}
