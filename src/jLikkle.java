
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
public class jLikkle {

    public static final String HTTP_LK2IN_URL = "http://lk2.in/";
    public static final String HTTP_LK2IN_WS_PATH = "api/vi/";

    /**
     * Object storage for the web service response.
     */
    private String response = null;

    /**
     * Store the request method.
     */
    private String request_method = null;

    /**
     * Generate the request URL to be used in the web service request.
     *
     * @return
     */
    protected String generateRequestUri() {
        return jLikkle.HTTP_LK2IN_URL + jLikkle.HTTP_LK2IN_WS_PATH + this.request_method;
    }

    /**
     * Returns the raw web service response (JSON)
     *
     * @return
     */
    public String getRawResponse() {
        return this.response;
    }

    /**
     * Set the raw response.
     *
     * @param response
     */
    private void setResponse(String response) {
        this.response = response;
    }

    /**
     * Set the request method.
     *
     * @param method
     */
    private void setRequestMethod(String method) {
        this.request_method = method;
    }

}
