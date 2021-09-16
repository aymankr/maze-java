/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import static java.lang.Math.abs;
import java.util.Collection;

/**
 *
 * @author aykachmar
 */
public class Salle implements ISalle {

    private int x;
    private int y;

    public Salle(int X, int Y) {
        x = X;
        y = Y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.x;
        hash = 79 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public boolean estAdjacente(ISalle autre) {
        int ecartX = abs(x-autre.getX());
        int ecartY = abs(y-autre.getY());
        
        return ecartX + ecartY <= 1;
    }

    public ISalle salleSuivante(int abs, int ord, Collection<ISalle> salles) {
        ISalle suivante = new Salle(x + abs, y + ord);
        for (ISalle s : salles) {
            if (suivante.getX() == s.getX() && suivante.getY() == s.getY()) {
                return s;
            }
        }
        return null;
    }
}
