
import me.bobbyallen.jlikkle.jLikkle;

/**
 * jLikkle is a JAVA client library for the lk2.in URL shortener service
 * (http://lk2.in).
 *
 * @author Bobby Allen <ballen@bobbyallen.me>
 * @version 1.0.0
 * @license http://opensource.org/licenses/MIT
 * @link https://github.com/bobsta63/jlikkle
 * @link http://bobbyallen.me
 *
 */
public class example {

    public static void main(String[] args) {

        jLikkle Lk2client = new jLikkle();

        // Example URL hash to lookkup the total number of visits for.
        String hash = "cU";

        // Lets request the total number of visits via. the web API.
        String visits = Lk2client.getStats(hash);
        
        // Lets now output the result to our user!
        System.out.println("The link http://lk2.in/" + hash + " has been visited " + visits + " times.");
    }

}
