import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.media.AudioClip;

/**
 * Displays the "Made with TranquilityLITE" splash screen, with the icon and text adjacent.
 * Plays any associated animations.
 *
 * @author      Zachary Sousa
 * @version     1.00
 */
public class SplashScreen
{
    private SplashIcon splashIcon;
    private SplashText splashText;
    private Canvas canvas;
    private Color backdrop;
    private AudioClip tranquility;
    
    /**
     * Constructor for SplashScreen
     */
    public SplashScreen(Canvas canvas, GraphicsContext gc) {
        tranquility     = new AudioClip(getClass().getResource("/Assets/Pgm/Splash/tranquility.mp3").toExternalForm());
        backdrop        = Color.rgb(51, 54, 59);
        splashIcon      = new SplashIcon(canvas);
        splashText      = new SplashText(canvas);
        this.canvas     = canvas;
        gc.setFill(backdrop);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        splashIcon.draw(gc);
    }
    
    /**
     * Animation thread. This is where you put your animation code.
     *
     * @param gc The drawing surface
     */
    public void animate(GraphicsContext gc) {
        Utilities.pause(5000);
        double movementRate = 15;
        while(movementRate > 0.1) {
            splashIcon.setX(splashIcon.getX() - movementRate);
            
            gc.setFill(backdrop);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            splashIcon.draw(gc);
            
            movementRate = movementRate*0.95;
            Utilities.pause(10);
        }
        splashText.draw(gc);
        tranquility.play();
        Utilities.pause(4000);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        movementRate = -15;
        while(movementRate < -0.1) {
            splashIcon.setX(splashIcon.getX() - movementRate);
            
            gc.setFill(backdrop);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            splashIcon.draw(gc);
            
            movementRate = movementRate*0.95;
            Utilities.pause(10);
        }
    }
}
