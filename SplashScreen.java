import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.media.AudioClip;
import java.util.Random;

/**
 * Displays the "TRANQUILITY" splash screen, with the icon and text adjacent.
 * Plays any associated animations and sounds.
 *
 * @author      Zachary Sousa
 * @version     1.00
 */
public class SplashScreen
{
    protected SplashIcon splashIcon;
    protected SplashText splashText;
    private Canvas canvas;
    private Color backdrop;
    private AudioClip tranquility;
    private AudioClip opening;
    private AudioClip start;
    
    /**
     * Constructor for SplashScreen
     */
    public SplashScreen(Canvas canvas, GraphicsContext gc) {  
        tranquility     = new AudioClip(getClass().getResource("/Assets/Pgm/Splash/tranquility.mp3").toExternalForm());
        start           = new AudioClip(getClass().getResource("/Assets/Pgm/Splash/start.mp3").toExternalForm());
        if(new Random().nextInt(3) == 0) {
            opening = new AudioClip(getClass().getResource("/Assets/Pgm/Splash/openingAlt.mp3").toExternalForm());
        } else {
            opening = new AudioClip(getClass().getResource("/Assets/Pgm/Splash/opening.mp3").toExternalForm());
        }
        backdrop        = Color.rgb(51, 54, 59);
        splashIcon      = new SplashIcon(canvas);
        splashText      = new SplashText(canvas);
        this.canvas     = canvas;
        gc.setFill(backdrop);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //splashIcon.draw(gc);
    }
    
    /**
     * Animation thread. This is where you put your animation code.
     *
     * @param gc The drawing surface
     */
    public void animate(GraphicsContext gc) {
        opening.play();
        splashText.visibility(false);
        gc.setFill(backdrop);
        Utilities.pause(5000);
        double movementRate = 15;
        while(movementRate > 0.1) {
            splashIcon.setX(splashIcon.getX() - movementRate);
            
            gc.setFill(backdrop);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            //splashIcon.draw(gc);
            
            movementRate = movementRate*0.95;
            Utilities.pause(10);
        }
        //splashText.draw(gc);
        splashText.visibility(true);
        tranquility.play();
        Utilities.pause(4000);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        movementRate = -15;
        splashText.visibility(false);
        while(movementRate < -0.1) {
            splashIcon.setX(splashIcon.getX() - movementRate);
            
            gc.setFill(backdrop);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            //splashIcon.draw(gc);
            
            movementRate = movementRate*0.95;
            Utilities.pause(10);
        }
        Utilities.pause(1000);
        start.play();
    }
}
