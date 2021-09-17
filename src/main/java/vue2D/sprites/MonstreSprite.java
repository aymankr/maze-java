/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import personnages.IPersonnage;

/**
 *
 * @author aykachmar
 */
public class MonstreSprite extends ASprite {

    public MonstreSprite(IPersonnage p, ILabyrinthe l) {
        super(p, l);
        image = new Image("file:icons/monstre0.gif");
    }
}
