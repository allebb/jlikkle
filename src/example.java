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
        
        String resp = Lk2client.getRawResponse();
        System.out.println(resp);
    }

}
