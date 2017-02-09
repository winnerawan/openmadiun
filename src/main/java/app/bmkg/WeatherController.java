package app.bmkg;

import app.util.JsonUtil;
import app.util.Message;
import app.util.ServerResponse;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by winnerawan
 * on 2/9/17.
 */
public class WeatherController {

    /**
     * get jawa timur weather info
     * scrape from ibachor api using my key
     */
    public static ServerResponse getWeather() {
        ServerResponse response = new ServerResponse();
        try {
            InputStream input = new URL("http://ibacor.com/api/bmkg?view=cuaca&id=P1Byb3Y9MTImTmFtYVByb3Y9SmF3YSBUaW11cg&k=4ba8823fcc9a21f434787019492ffb36").openStream();
            Reader reader = new InputStreamReader(input, "UTF-8");
            Object weather = new Gson().fromJson(reader, Object.class);
            response.setStatus(200);
            response.setMessage(Message.OK());
            response.setResult(weather);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
