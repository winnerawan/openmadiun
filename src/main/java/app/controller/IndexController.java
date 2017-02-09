package app.controller;

import app.util.Message;
import app.util.ServerResponse;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class IndexController {

    /**
     * Show message on index
     * @return status & message
     */
    public static ServerResponse index() {
        ServerResponse response = new ServerResponse();
        response.setStatus(200);
        response.setMessage(Message.Congratulations());
        return response;
    }
}
