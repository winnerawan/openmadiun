package app.controller;

import app.util.Message;
import app.util.ServerResponse;

import java.util.List;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class IndexController {

    public static ServerResponse index() {
        ServerResponse response = new ServerResponse();
        response.setStatus(200);
        response.setMessage(Message.Congratulations());
        return response;
    }
}
