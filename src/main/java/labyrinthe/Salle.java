/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

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
        for (Direction d : Direction.toutes()) {
            ISalle tmp = new Salle(x + d.mvtHoriz(), y + d.mvtVertic());
            if (tmp.getX() == autre.getX() && tmp.getY() == autre.getY()) {
                return true;
            }
        }
        return false;
    }

    public ISalle salleSuivante(Direction d, Collection<ISalle> salles) {
        ISalle suivante = new Salle(x + d.mvtHoriz(), y + d.mvtVertic());
        for (ISalle s : salles) {
            if (suivante.getX() == s.getX() && suivante.getY() == s.getY()) {
                return s;
            }
        }
        return null;
    }
    
    public int deplacementXPix(ISalle suivante) {
        if (x < suivante.getX()) {
            return 1;
        }
        return -1;
    }
    
    public int deplacementYPix(ISalle suivante) {
        if (y < suivante.getY()) {
            return 1;
        }
        return -1;
    }
}
