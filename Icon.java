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
    public ImageView iconView;
    protected double x;
    protected double y;
    
    public Icon(Canvas canvas, String path) {
        iconView = new ImageView(new Image(path));
        iconView.setFitWidth(200);
        iconView.setFitHeight(200);
        iconView.setPreserveRatio(true);
        iconView.setSmooth(true);
        x = canvas.getWidth()/2 - iconView.getFitWidth()/2;
        y = canvas.getHeight()/2 - iconView.getFitHeight()/2;    
        iconView.setX(x);
        iconView.setY(y);
    }
    
    public Icon(Canvas canvas, String path, double w, double h) {
        iconView = new ImageView(path);
        iconView.setFitWidth(w);
        iconView.setFitHeight(h);
        iconView.setPreserveRatio(true);
        iconView.setSmooth(true);
        x = canvas.getWidth()/2 - iconView.getFitWidth()/2;
        y = canvas.getHeight()/2 - iconView.getFitHeight()/2;
        iconView.setX(x);
        iconView.setY(y);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double num) {
        x = num;
        iconView.setX(num);
    }
    
    public void setY(double num) {
        y = num;
        iconView.setY(num);
    }
    
    public double getFit() {
        return iconView.getFitWidth();
    }
    
    public void setFit(double w) {
        iconView.setFitWidth(w);
    }
    
    public void visibility(boolean b) {
        iconView.setVisible(b);
    }
}
