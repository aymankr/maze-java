package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;

import outils.Fichier;
import personnages.IPersonnage;

/**
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree;
    protected ISalle sortie;
    private int largeur;
    private int hauteur;

    @Override
    public void creerLabyrinthe(String file) {
        Fichier f = new Fichier(file);
        // dimensions
        largeur=f.lireNombre();
        hauteur=f.lireNombre(); 
        
        int entreeX = f.lireNombre();
        int entreeY = f.lireNombre();
        Salle entree = new Salle(entreeX, entreeY);
        this.add(entree);
        
        int sortieX = f.lireNombre();
        int sortieY = f.lireNombre();
        Salle sortie = new Salle(sortieX, sortieY);
        
        while (true) {
            int tmpX = f.lireNombre();
            int tmpY = f.lireNombre();
            if (tmpX == -1 || tmpY == -1) {
                break;
            }
            Salle s = new Salle(tmpX, tmpY);
            this.add(s);
        }
        this.add(sortie);
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        return null;
    }

    @Override
    public ISalle getEntree() {
        return entree;
    }

    @Override
    public ISalle getSortie() {
        return sortie;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    @Override
    public int getLargeur() {
        return largeur;
    }

    @Override
    public int getHauteur() {
        return hauteur;
    }

}
