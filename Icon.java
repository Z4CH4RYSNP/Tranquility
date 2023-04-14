import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;

/**
 * A basic icon.
 *
 * @author      Zachary Sousa
 * @version      1.00
 */
public class Icon
{
    protected Image icon;
    protected double x;
    protected double y;
    
    public Icon(Canvas canvas, String path) {
        icon = new Image(path, 200, 200, true, true);
        x = canvas.getWidth()/2 - icon.getWidth()/2;
        y = canvas.getHeight()/2 - icon.getHeight()/2;
    }
    
    public Icon(Canvas canvas, String path, double w, double h) {
        icon = new Image(path, w, h, true, true);
        x = canvas.getWidth()/2 - icon.getWidth()/2;
        y = canvas.getHeight()/2 - icon.getWidth()/2;
    }
    
    public void draw(GraphicsContext gc) {
        gc.drawImage(icon, x, y);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double num) {
        x = num;
    }
    
    public void setY(double num) {
        y = num;
    }
    
    public double getH() {
        return icon.getHeight();
    }
    
    public double getW() {
        return icon.getWidth();
    }
}
