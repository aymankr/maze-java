/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import java.util.Random;
import labyrinthe.ISalle;

/**
 *
 * @author aykachmar
 */
public class Monstre extends APersonnage {

    public Monstre(ISalle position) {
        super.position = position;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        Random r = new Random();
        int index = r.nextInt(sallesAccessibles.size());
        
        ISalle choix = (ISalle) sallesAccessibles.toArray()[index];
        super.position = choix;
        return choix;
    }
}
