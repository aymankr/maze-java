package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;
import outils.ExceptionInvalidFile;

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
    public void creerLabyrinthe(String file) throws ExceptionInvalidFile {
        Fichier f = new Fichier(file);
        try {
            Fichier.testValide(file);
        }
        catch (ExceptionInvalidFile ex) {
            f = new Fichier("labys/level7.txt");
        }
        
        // dimensions
        largeur = f.lireNombre();
        hauteur = f.lireNombre();

        int entreeX = f.lireNombre();
        int entreeY = f.lireNombre();
        Salle entr = new Salle(entreeX, entreeY);
        entree = entr;
        this.add(entr);

        int sortieX = f.lireNombre();
        int sortieY = f.lireNombre();
        Salle sort = new Salle(sortieX, sortieY);
        sortie = sort;

        while (true) {
            int tmpX = f.lireNombre();
            int tmpY = f.lireNombre();
            if (tmpX == -1 || tmpY == -1) {
                break;
            }
            Salle s = new Salle(tmpX, tmpY);
            this.add(s);
        }
        this.add(sort);
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
