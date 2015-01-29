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
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    /**
     * Sends the API request to the LK2 web service.
     *
     * @return void
     */
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
     * Decodes the JSON string to a usable JSONObject
     *
     * @return JSONObject
     * @throws ParseException
     */
    private JSONObject responseDecode() throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(this.response); // Complete response.
        JSONObject dataObject = (JSONObject) jsonParser.parse(jsonObject.get("data").toString()); // The 'data' section.
        JSONObject statsObject = (JSONObject) jsonParser.parse(dataObject.get("stats").toString()); // The 'data.stats' section.
        return statsObject;
    }

    /**
     * Return statistics for the shortcode
     *
     * @param shortcode String
     * @return String
     */
    public String getStats(String shortcode) {
        this.setRequestMethod("stats?hash=" + shortcode);
        this.sendRequest();
        try {
            return this.responseDecode().get("total_visits").toString();
        } catch (ParseException ex) {
            return "Not found!";
        }
    }

    /**
     * Set the plaintext response.
     *
     * @param response The plaintext response from the web API request.
     * @return void
     */
    private void setResponse(String response) {
        this.response = response;
    }

    /**
     * Get the plaintext response from the object.
     *
     * @return String
     */
    public String getRawResponse() {
        return this.response;
    }

    /**
     * Set the API request method/API endpoint
     *
     * @param String method
     */
    private void setRequestMethod(String method) {
        this.request_method = method;
    }

}
