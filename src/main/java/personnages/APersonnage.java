/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import labyrinthe.ISalle;

/**
 *
 * @author aykachmar
 */
public abstract class APersonnage implements IPersonnage {
    
    protected ISalle salleChoisie;
    ISalle position;
    
    @Override
    public ISalle getPosition() {
        return position;
    }
    
    @Override
    public void setPosition(ISalle s) {
        salleChoisie = s;
    }
}
