
/**
 * Various functions that are used throughout the pgm.
 *
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Utilities
{
    public static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch(Exception e) {
            //do nothing
        }
    }
}
