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
    
    @Override
    public ISalle getPosition() {
        return null;
    }
    
    @Override
    public void setPosition(ISalle s) {

    }
}
