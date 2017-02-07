package app.place;

import app.db.DatabaseHelper;
import app.util.Message;
import app.util.ServerResponse;
import org.mongodb.morphia.Datastore;

import java.util.List;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class PlaceController {

    static DatabaseHelper helper = new DatabaseHelper();
    static Datastore datastore = helper.getDataStore();
    static ServerResponse response = new ServerResponse();

// Dummy insert
    public static ServerResponse insertZipCode(ZipCode zipCode) {
        datastore.save(zipCode);
        response.setStatus(200);
        response.setMessage(Message.OK());
        response.setResult(zipCode);
        return response;
    }
// Dumm insert place category
    public static ServerResponse insertPlaceCategory(Category category) {
        datastore.save(category);
        response.setStatus(200);
        response.setMessage(Message.OK());
        response.setResult(category);
        return response;
    }
    // Dumm insert place category
    public static ServerResponse insertPlace(Place place) {
        datastore.save(place);
        response.setStatus(200);
        response.setMessage(Message.OK());
        response.setResult(place);
        return response;
    }

    /**
     * get all list zipcode @madiun
     */
    public static ServerResponse getAllZipCode() {
        List<ZipCode> zipcodes = datastore.find(ZipCode.class).asList();
        response.setStatus(200);
        response.setMessage(Message.OK());
        response.setResult(zipcodes);
        return response;
    }

    /**
     * get zipcode by kelurahan
     * @param kelurahan
     */
    public static ServerResponse zipCode(String kelurahan) {
        List<ZipCode> zipcode = datastore.find(ZipCode.class).filter("kelurahan",kelurahan).asList();
        if (zipcode.size()>=1) {
            response.setStatus(200);
            response.setMessage(Message.OK());
            response.setResult(zipcode);
        } else {
            response.setStatus(404);
            response.setMessage(Message.NotFound());
            response.setResult(null);
        }

        return response;
    }

    /**
     * get all place category
     * @return id & title place category
     */

    public static ServerResponse getPlaceCategory() {
        List<Category> categories = datastore.find(Category.class).asList();
        if (categories.size()>=1) {
            response.setStatus(200);
            response.setMessage(Message.OK());
            response.setResult(categories);
        } else {
            response.setStatus(404);
            response.setMessage(Message.NotFound());
            response.setResult(null);
        }
        return response;
    }

    /**
     * get all place
     * @return all place with detail
     */

    public static ServerResponse getAllPlace() {
        List<Place> tour_place = datastore.find(Place.class).asList();
        if (tour_place.size()>=1) {
            response.setStatus(200);
            response.setMessage(Message.OK());
            response.setResult(tour_place);
        } else if (tour_place.size()<=1){
            response.setStatus(404);
            response.setMessage(Message.NotFound());
            response.setResult(null);
        }
        return response;
    }

    /**
     * get place detail by category
     * @param category
     * @return place detail
     */

    public static ServerResponse getPlace(String category) {
        List<Place> _place = datastore.find(Place.class).filter("category", category).asList();
        if (_place.size()>=1) {
            response.setStatus(200);
            response.setMessage(Message.OK());
            response.setResult(_place);
        } else if (_place.size()<=1){
            response.setStatus(404);
            response.setMessage(Message.NotFound());
            response.setResult(null);
        }
        return response;
    }



}
