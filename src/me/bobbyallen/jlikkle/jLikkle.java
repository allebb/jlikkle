package me.bobbyallen.jlikkle;

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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class jLikkle {

    private final String HTTP_LK2IN_URL = "http://lk2.in/";
    private final String HTTP_LK2IN_WS_PATH = "api/v1/";
    private final String USER_AGENT = "jLikkle/1.0";

    /**
     * Object storage for the web service response.
     */
    private String response = null;

    /**
     * Store the request method.
     */
    private String request_method = null;
    
    /**
     * Stores the last HTTP response code following the API request.
     */
    private int response_code = 0;

    /**
     * Generate the request URL to be used in the web service request.
     *
     * @return
     */
    protected String generateRequestUri() {
        return HTTP_LK2IN_URL + HTTP_LK2IN_WS_PATH + this.request_method;
    }

    private void sendRequest() {
        String url = this.generateRequestUri();

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            this.response_code = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            this.response = response.toString();
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }
    }

    /**
     * Returns the raw web service response (JSON)
     *
     * @return
     */
    public String getRawResponse() {
        this.setRequestMethod("stats?hash=cU");
        this.sendRequest();
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
