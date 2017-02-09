package app.util;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class Path {

    public static class Web {
        public static final String INDEX = "/";
        public static final String ZIPCODE = "/zipcodes";
        public static final String ZIP_CODE = "/zipcode/:kelurahan";
        public static final String REGZIP = "/reg/kodepos";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout/";
        public static final String PLACE_CATEGORY = "/place/categories";
        public static final String RESERVED_1 = "/place/category/add";
        public static final String RESERVED_2 = "/place/add";
        public static final String ADD_KOST = "/place/kost/add";
        public static final String PLACES = "/places";
        public static final String WEATHER = "/weather";
        public static final String PLACE = "/place/:category";
        public static final String REGISTER = "/signup";
        public static final String SIGNIN = "/signin";
        public static final String USERS = "/users";
        public static final String USERBYNAME = "/user/:username";
        public static final String USERBYEMAIL = "/username/:email";
        public static final String ADD_USER_TYPE = "/usertype";
        public static final String USER_TYPE = "/usertypes";
        public static final String ADD_FOLLOWER = "/follow/:username";

    }
}
