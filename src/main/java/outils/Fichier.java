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

    public static boolean testValide(String nomFichier) {
        ArrayList<Salle> salles = new ArrayList<>();

        Fichier fichier = new Fichier(nomFichier);
        boolean valide = true;
        int largeur = fichier.lireNombre();
        int hauteur = fichier.lireNombre();

        boolean continuer = true;
        while (continuer) {
            int tmpX = fichier.lireNombre();
            int tmpY = fichier.lireNombre();
            continuer = (tmpX != -1 || tmpY != -1);
            Salle s = new Salle(tmpX, tmpY);

            valide = (!salles.contains(s) && tmpX >= 0 && tmpX < largeur && tmpY >= 0 && tmpY < hauteur);
            salles.add(s);
        }
        return valide;
    }
}
