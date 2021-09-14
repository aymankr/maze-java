/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import labyrinthe.Direction;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 *
 * @author aykachmar
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {
    
    Heros heros;
    
    public HerosSprite(IPersonnage IPerso, ILabyrinthe l) {
        super(IPerso, l);
        heros = (Heros) IPerso;
        image = new Image("file:icons/link/LinkRunShieldL1.gif");
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return IPerso.faitSonChoix(sallesAccessibles);
    }

    @Override
    public ISalle getPosition() {
        return IPerso.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {
        IPerso.setPosition(s);
    }

    @Override
    public void handle(KeyEvent e) {
        KeyCode keyCode = e.getCode();
        Salle position = (Salle) IPerso.getPosition();

        switch (keyCode) {
            case LEFT:
                heros.salleChoisie = position.salleSuivante(Direction.OUEST, this.labyrinthe);
                break;
            case RIGHT:
                heros.salleChoisie = position.salleSuivante(Direction.EST, this.labyrinthe);
                break;
            case UP:
                heros.salleChoisie = position.salleSuivante(Direction.NORD, this.labyrinthe);
                break;
            case DOWN:
                heros.salleChoisie = position.salleSuivante(Direction.SUD, this.labyrinthe);
                break;
        }
    }
}
