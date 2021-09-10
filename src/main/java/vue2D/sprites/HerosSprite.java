/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import static java.awt.event.KeyEvent.VK_UP;
import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import labyrinthe.Direction;
import labyrinthe.ISalle;
import personnages.IPersonnage;

/**
 *
 * @author aykachmar
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    Image image;

    public HerosSprite(IPersonnage IPerso, Image img) {
        super(IPerso);
        image = img;
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return null;
    }

    @Override
    public ISalle getPosition() {
        return IPerso.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {

    }

    @Override
    public void handle(KeyEvent e) {
        KeyCode keyCode = e.getCode();
        IPersonnage p = this.IPerso;

        switch (keyCode) {
            case LEFT:
                p.setPosition(p.getPosition().salleSuivante(Direction.OUEST));
                break;
            case RIGHT:
                p.setPosition(p.getPosition().salleSuivante(Direction.EST));
                break;
            case UP:
                p.setPosition(p.getPosition().salleSuivante(Direction.NORD));
                break;
            case DOWN:
                p.setPosition(p.getPosition().salleSuivante(Direction.SUD));
                break;
        }
    }
}
