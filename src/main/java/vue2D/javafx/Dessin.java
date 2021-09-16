package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

/**
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    private Collection<ISprite> sprites;
    private ILabyrinthe labyrinthe;
    private int unite = 15;
    private GraphicsContext tampon;
    private Image solImage;
    private Image salleImage;

    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur() * unite);
        setHeight(labyrinthe.getHauteur() * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
        dessinSalles();
        dessinSprites();
    }

    public void chargementImages() {
        solImage = new Image("file:icons/pyramide.jpg");
        salleImage = new Image("file:icons/ground.gif");
    }

    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * labyrinthe.getLargeur(),
                unite * labyrinthe.getHauteur());
    }

    public void dessinSalles() {
        labyrinthe.forEach(s -> {
            tampon.drawImage(salleImage, s.getX()*unite, s.getY()*unite, unite, unite);
        });
    }
    
    public void dessinSprites() {
        sprites.forEach(s -> {
            s.dessiner(tampon);
        });
    }
}
