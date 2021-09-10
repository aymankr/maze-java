/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author aykachmar
 */
public class Heros extends APersonnage {

    public Heros(ISalle entree) {
        super.position = entree;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (sallesAccessibles.contains(super.salleChoisie)) {
            position = super.salleChoisie;
            return super.salleChoisie;
        }
        return super.getPosition();
    }
}
