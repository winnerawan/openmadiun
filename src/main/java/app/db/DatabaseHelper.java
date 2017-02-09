package app.db;

import app.place.ZipCode;
import app.user.User;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class DatabaseHelper {

    /**
     * Constructor
     * cloud contacts
     */
    private static Morphia morphia = new Morphia();
    private static Datastore datastore = null;

    private static Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);

    public DatabaseHelper() {
        if (!morphia.isMapped(User.class)) {
            morphia.map(User.class);
            initDatastore();
        } else {
            logger.info("Database Class Mapped Already!");
        }
    }

    void initDatastore() {

        MongoClient client = new MongoClient("localhost", 27017);
        datastore = morphia.createDatastore(client, "zonae");
    }

    public Datastore getDataStore() {
        if(datastore == null) {
            initDatastore();
        }

        return datastore;
    }
}
