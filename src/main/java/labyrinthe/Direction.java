/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

/**
 *
 * @author aykachmar
 */
public enum Direction {
    NORD, SUD, EST, OUEST;
    
    public static Direction[] toutes() {
        Direction[] directions = {NORD, SUD, EST, OUEST};
        return directions;
    }
    
    public int mvtHoriz() {
        int dh = -2;
        switch (this) {
            case NORD:
            case SUD:
                dh = 0;
                break;
            case EST:
                dh = 1;
                break;
            case OUEST:
                dh = -1;
                break;
        }
        return dh;
    }
    
    public int mvtVertic() {
        int dv = -2;
        switch (this) {
            case EST:
            case OUEST:
                dv = 0;
                break;
            case NORD:
                dv = -1;
                break;
            case SUD:
                dv = 1;
                break;
        }
        return dv;
    }
}
