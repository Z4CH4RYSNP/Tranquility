import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color; 
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import static javafx.application.Application.launch;
import javafx.scene.layout.HBox;

/**
 * This is the Main program in which everything runs and is drawn. Everything is controlled here.
 *
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Main extends Application {
    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setWidth(1920);
        stage.setHeight(1080);
        stage.setResizable(false);
        //stage.setMaximized(true);
        
        Canvas canvas = new Canvas(stage.getWidth(), stage.getHeight()); // Set canvas Size in Pixels
        GraphicsContext gc = canvas.getGraphicsContext2D();
        stage.setTitle("Tranquility2"); // Set window title
        
        SplashScreen splashScreen = new SplashScreen(canvas, gc);

        Thread splashThread = new Thread(() -> splashScreen.animate(gc));
        splashThread.start();
        
        root.getChildren().add(canvas);
        
        root.getChildren().add(splashScreen.splashText.iconView);
        root.getChildren().add(splashScreen.splashIcon.iconView);        
        
        stage.show();
    }
   
    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
    
     /**
     * Exits the app completely when the window is closed. This is necessary to
     * kill the animation thread.
     */
    @Override
    public void stop() {
        System.exit(0);
    }
}