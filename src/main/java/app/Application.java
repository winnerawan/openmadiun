package app;

import app.bmkg.WeatherController;
import app.controller.IndexController;
import app.db.DatabaseHelper;
import app.place.*;
import app.user.User;
import app.user.UserController;
import app.user.UserType;
import app.util.JsonUtil;
import app.util.Path;
import app.util.ServerResponse;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import static app.util.JsonUtil.json;
import static spark.Spark.*;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class Application {

    private PasswordEncoder passwordEncoder;
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(Application.class);


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

        get(Path.Web.WEATHER, (request, response) -> WeatherController.getWeather(), json());

        get(Path.Web.USERS, (request, response) -> UserController.getAllUser(), json());

        get(Path.Web.USER_TYPE, (request, response) -> UserController.getUserType(), json());

        get(Path.Web.PLACE, (request, response) -> {
            String category = request.params(":category");
            ServerResponse result = PlaceController.getPlace(category);
            return JsonUtil.toJson(result);
        });

        get(Path.Web.USERBYNAME, (request, response) -> {
            String user = request.params(":username");
            ServerResponse result = UserController.userByUsername(user);
            return JsonUtil.toJson(result);
        });

        post(Path.Web.SIGNIN, (request, response) -> {
            String email = request.queryParams("email");
            String password = request.queryParams("password");
            ServerResponse result = UserController.authUser(email, password);
            User me = UserController.getUserByEmail(email);
            UserController.addAuthenticatedUser(request, me);
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

        post(Path.Web.ADD_KOST, (request, response) -> {
            String title = request.queryParams("title");
            String address = request.queryParams("address");
            long latitude = Long.parseLong(request.queryParams("latitude"));
            long longitude = Long.parseLong(request.queryParams("longitude"));
            String description = request.queryParams("description");
            String telephone = request.queryParams("telephone");
            String category = "kost";
            String opening_hours = request.queryParams("opening_hours");
            String price_range = request.queryParams("price_range");
            float rating = Float.parseFloat(request.queryParams("rating"));
            String img_url = request.queryParams("img_url");

            Location location = new Location(address, latitude, longitude);
            Place place = new Place(title, location, description, telephone, category, opening_hours, price_range, rating, img_url);

            return JsonUtil.toJson(PlaceController.insertPlace(place));
        });

        post(Path.Web.ADD_USER_TYPE, (request, response) -> {
            String userType = request.queryParams("type");
            UserType type = new UserType(userType);
            return JsonUtil.toJson(UserController.setUserType(type));
        });

        post(Path.Web.REGISTER, (request, response) -> {
            String username = request.queryParams("username");
            String email = request.queryParams("email");
            String password = request.queryParams("password");
            //String verifier = request.queryParams("verifier");
            //String token = request.queryParams("token");
            String type = request.queryParams("type");
            UserType userType = new UserType(type);
            String encodePassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
            User user = new User(username, email, encodePassword, userType);
            logger.info("log = " + JsonUtil.toJson(user));
            return JsonUtil.toJson(UserController.registerUser(user));
        });

        /*
		 * Adds the current user as follower of the given user.
		 */
        post(Path.Web.ADD_FOLLOWER, (request, response) -> {
            String username = request.params(":username");
            User me = UserController.getAuthenticatedUser(request);
            User follow = UserController.getUserByUsername(username);
            return JsonUtil.toJson(UserController.insertFollower(me.getId(), follow.getId()));
        });

        after(((request, response) -> response.type(JsonUtil.JSON())));

    }

    public static void main(String[] args) {
        new Application();
    }
}
