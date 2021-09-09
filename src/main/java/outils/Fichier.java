package outils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import labyrinthe.Salle;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author INFO Professors team
 */
public class Fichier {

    Scanner sc = null;

    public Fichier(String nomFichier) {
        try {
            sc = new Scanner(new File(nomFichier));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // retourne le prochain entier dans le fichier
    // retourne -1 s'il n'y en a pas
    public int lireNombre() {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        }
        return -1;
    }

    public static boolean testPasDeDoublon(String nomFichier) {
        ArrayList<Salle> salles = new ArrayList<>();
        HashSet<Salle> sallesUniques = new HashSet<>();

        Fichier fichier = new Fichier(nomFichier);

        int tmpX = 0, tmpY = 0;
        while (tmpX != -1 && tmpY != -1) {
            tmpX = fichier.lireNombre();
            tmpY = fichier.lireNombre();

            Salle s = new Salle(tmpX, tmpY);
            salles.add(s);
            sallesUniques.add(s);
        }
        return salles.size() == sallesUniques.size();
    }

    public static boolean testCoordonneesSallesFichier(String nomFichier) {
        Fichier fichier = new Fichier(nomFichier);

        int tmpX = 0, tmpY = 0;
        int largeur = fichier.lireNombre();
        int hauteur = fichier.lireNombre();

        while (tmpX != -1 && tmpY != -1) {
            if (!(tmpX >= 0 && tmpX < largeur && tmpY >= 0 && tmpY < hauteur)) {
                return false;
            }
            
            tmpX = fichier.lireNombre();
            tmpY = fichier.lireNombre();
        }
        return true;
    }

    public static boolean testValide(String nomFichier) throws ExceptionInvalidFile {
        boolean valide = testPasDeDoublon(nomFichier) && testCoordonneesSallesFichier(nomFichier);
        if (!valide) {
            throw new ExceptionInvalidFile();
        }
        return valide;
    }
}
