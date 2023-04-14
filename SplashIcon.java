import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The icon to display on the splash screen.
 *
 * @author      Zachary Sousa
 * @version      1.00
 */
public class SplashIcon extends Icon
{   
    public SplashIcon(Canvas canvas) {
        super(canvas, "/Assets/Pgm/Splash/icon.png");
    }
}
