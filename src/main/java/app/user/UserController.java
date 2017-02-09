package app.user;

import app.db.DatabaseHelper;
import app.util.Message;
import app.util.ServerResponse;

import org.mongodb.morphia.Datastore;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import spark.Request;

import java.util.List;


/**
 * Created by winnerawan
 * on 2/9/17.
 */
public class UserController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String USER_SESSION_ID = "user";

    private static DatabaseHelper helper = new DatabaseHelper();
    private static Datastore datastore = helper.getDataStore();
    private static ServerResponse response = new ServerResponse();

    /************************* POST METHOD CONTROLLER ***********************/

    /**
     * insert user type
     * @param userType (user / penyedia jasa)
     * @return user type
     */
    public static ServerResponse setUserType(UserType userType) {
        datastore.save(userType);

        return new ServerResponse(200, Message.OK(), userType);
    }
    /**
     * register user
     * @param user (username, email, password, user_type)
     * @return server response & user info
     */
    public static ServerResponse registerUser(User user) {
        datastore.save(user);
        return new ServerResponse(200, Message.OK(), user);
    }

    /**
     * login
     * @param email user
     * @param password user
     * @return server response & user info
     */
    public static ServerResponse authUser(String email, String password) {
        List<User> userList = datastore.find(User.class).filter("email", email).asList();
        boolean match = BCrypt.checkpw(password, userList.get(0).getPassword());
        if (match) {
            User user = getUserByEmail(email);
            return new ServerResponse(200, Message.OK(), user);
        }
        return new ServerResponse(401, Message.GoAway());
    }

    /**
     * Adds the current user as follower of the given user.
     */
    public static ServerResponse insertFollower(String follower, String followee) {

        Follow follow = new Follow(follower, followee);
        datastore.save(follow);
        return new ServerResponse(200, Message.OK(), follow);
    }

    /**
     * set user session
     * @param request method
     * @param u = user
     */
    public static void addAuthenticatedUser(Request request, User u) {
        logger.info("LOG"+USER_SESSION_ID);
        request.session().attribute(USER_SESSION_ID, u);

    }

    /************************* GET METHOD CONTROLLER *************************/

    /**
     * get user type
     * @return user type
     */
    public static ServerResponse getUserType() {
        List<UserType> types = datastore.find(UserType.class).asList();
        if (types.size()>=1) {
            return new ServerResponse(200, Message.OK(), types);
        }
        return new ServerResponse(404, Message.NotFound(), null);
    }

    /**
     * get list all user
     * @return list user
     */
    public static ServerResponse getAllUser() {
        List<User> users = datastore.find(User.class).asList();
        if (users.size()>=1) {
            response.setStatus(200);
            response.setMessage(Message.OK());
            response.setResult(users);
            return response;
        }
        response.setStatus(401);
        response.setMessage(Message.GoAway());
        return response;
    }

    /**
     * get user by email
     * @param email user
     * @return user info
     */
    public static User getUserByEmail(String email) {
        List<User> userList = datastore.find(User.class).filter("email", email).limit(1).asList();
        if (userList.size()>=1) {
            return userList.get(0);
        }
        return null;
    }

    /**
     * get user by username
     * @param username of user
     * @return user info
     */
    public static User getUserByUsername(String username) {
        List<User> userList = datastore.find(User.class).filter("username", username).limit(1).asList();
        if (userList.size()>=1) {
            return userList.get(0);
        }
        return null;
    }

    /**
     * get user by username
     * @param username of user
     * @return user info
     */
    public static ServerResponse userByUsername(String username) {
        List<User> userList = datastore.find(User.class).filter("username", username).limit(1).asList();
        if (userList.size()>=1) {
            return new ServerResponse(200, Message.OK(), userList.get(0));
        }
        return new ServerResponse(404, Message.NotFound(), null);
    }

    /**
     * get user login (me)
     * @param request
     * use to follow people
     */
    public static User getAuthenticatedUser(Request request) {
        return request.session().attribute(USER_SESSION_ID);
    }


}
