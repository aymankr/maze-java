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
import personnages.IPersonnage;

/**
 *
 * @author aykachmar
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    public HerosSprite(IPersonnage IPerso, ILabyrinthe l) {
        super(IPerso, l);
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
        ISalle position = this.IPerso.getPosition();

        switch (keyCode) {
            case LEFT:
                setPosition(position.salleSuivante(Direction.OUEST));
                break;
            case RIGHT:
                setPosition(position.salleSuivante(Direction.EST));
                break;
            case UP:
                setPosition(position.salleSuivante(Direction.NORD));
                break;
            case DOWN:
                setPosition(position.salleSuivante(Direction.SUD));
                break;
        }
    }
}
