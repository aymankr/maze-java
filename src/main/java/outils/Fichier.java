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

    public static boolean testValide(String nomFichier) throws ExceptionInvalidFile {
        ArrayList<Salle> salles = new ArrayList<>();
        HashSet<Salle> sallesUniques = new HashSet<>();

        Fichier fichier = new Fichier(nomFichier);
        boolean valide = true;
        int largeur = fichier.lireNombre();
        int hauteur = fichier.lireNombre();

        while (true) {
            int tmpX = fichier.lireNombre();
            int tmpY = fichier.lireNombre();
            if ((tmpX == -1 || tmpY == -1)) {
                break;
            }
            Salle s = new Salle(tmpX, tmpY);

            if (!(salles.size() == sallesUniques.size() && tmpX >= 0 && tmpX < largeur && tmpY >= 0 && tmpY < hauteur)) {
                throw new ExceptionInvalidFile();
            }
            salles.add(s);
            sallesUniques.add(s);
        }
        return valide;
    }
}
