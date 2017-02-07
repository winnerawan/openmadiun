package app;

import app.controller.IndexController;
import app.db.DatabaseHelper;
import app.place.Category;
import app.place.Place;
import app.place.PlaceController;
import app.place.ZipCode;
import app.util.JsonUtil;
import app.util.Path;
import app.util.ServerResponse;
import com.google.gson.Gson;

import static app.util.JsonUtil.json;
import static spark.Spark.*;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class Application {

    private Application() {

        new DatabaseHelper();

        get(Path.Web.INDEX, (request, response) -> IndexController.index(), json());

        get(Path.Web.ZIPCODE, (request, response) -> PlaceController.getAllZipCode(), json());

        get(Path.Web.ZIP_CODE, (request, response) -> {
            String kelurahan = request.params(":kelurahan");
            ServerResponse result = PlaceController.zipCode(kelurahan);

            return JsonUtil.toJson(result);
        });

        get(Path.Web.PLACE_CATEGORY, (request, response) -> PlaceController.getPlaceCategory(), json());

        get(Path.Web.PLACES, (request, response) -> PlaceController.getAllPlace(), json());

        get(Path.Web.PLACE, (request, response) -> {
            String category = request.params(":category");
            ServerResponse result = PlaceController.getPlace(category);
            return JsonUtil.toJson(result);
        });

        post(Path.Web.REGZIP, (request, response) -> {
            Gson gson = new Gson();
            ZipCode zipCode = gson.fromJson(request.body(), ZipCode.class);
            return JsonUtil.toJson(PlaceController.insertZipCode(zipCode));
        });

        post(Path.Web.RESERVED_1, (request, response) -> {
            Gson gson = new Gson();
            Category category = gson.fromJson(request.body(), Category.class);
            return JsonUtil.toJson(PlaceController.insertPlaceCategory(category));
        });

        post(Path.Web.RESERVED_2, (request, response) -> {
            Gson gson = new Gson();
            Place place = gson.fromJson(request.body(), Place.class);
            return JsonUtil.toJson(PlaceController.insertPlace(place));
        });

        after(((request, response) -> response.type(JsonUtil.JSON())));

    }

    public static void main(String[] args) {
        new Application();
    }
}
