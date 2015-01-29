
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

    private jLikkle Lk2client = new jLikkle();

    public static void main(String[] args) {
        
        // Create a new instance of our example class (to enable us to call our example methods below)
        example instance = new example();
        
        // Execute and output the gather link statistics example...
        instance.statisticsOutputExample();
        
        // Execute and output the generation of a new short URL example...
        instance.generateNewShortCodeExample();
    }

    private void statisticsOutputExample() {
        // Example URL hash to lookkup the total number of visits for.
        String hash = "cU";

        // Lets request the total number of visits via. the web API.
        String visits = this.Lk2client.getStats(hash);

        // Lets now output the result to our user!
        System.out.println("The link http://lk2.in/" + hash + " has been visited " + visits + " times.");
    }

    private void generateNewShortCodeExample() {

        // Lets add a URL that we want to shorten...
        String my_test_url = "http://thestack.com/erwin-borfink-data-center-germany-290115";

        // We now make the web API request and get the 'hash' (The last part of the URL)
        String generated_short_hash = this.Lk2client.getShortUrl(my_test_url, true);

        // Now we'll output some example text and concatenate the generated hash with the LK2 base URL...
        System.out.println("Your URL (" + my_test_url + ") has now been shortened and can be accessed here: http://lk2.in/" + generated_short_hash);
    }

}
