
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import labyrinthe.Salle;
import org.junit.Test;
import outils.Fichier;

/**
 *
 * @author INFO Professors team
 */
public class TestFichiersLabyrinthe {

    private File[] getFiles(File repertoire) {
        if (!repertoire.isDirectory()) {
            fail("testCoordonneesSalles - les tests ne concernent pas un répertoire");
        }
        File[] fichiers = repertoire.listFiles();
        return fichiers;
    }

    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for (File f : fichiers) {
            assertTrue(testCoordonneesSallesFichier(f));
        }
    }

    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        ArrayList<Salle> salles = new ArrayList<>();

        for (File f : fichiers) {
            Fichier fichier = new Fichier(f.getPath());
            
            int tmpX = fichier.lireNombre();
            int tmpY = fichier.lireNombre();
            Salle s = new Salle(tmpX, tmpY);
            assertFalse(salles.contains(s));
            salles.add(s);
        }
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    public boolean testCoordonneesSallesFichier(File f) {
        Fichier fichier = new Fichier(f.getPath());
        int largeur = fichier.lireNombre();
        int hauteur = fichier.lireNombre();
        boolean arreter = false;
        boolean estValide = false;

        while (!arreter) {
            int tmpX = fichier.lireNombre();
            int tmpY = fichier.lireNombre();
            estValide = (tmpX >= 0 && tmpX < largeur && tmpY >= 0 && tmpY < hauteur);
            arreter = (tmpX == -1 || tmpY == -1);
        }
        return estValide;
    }
}
