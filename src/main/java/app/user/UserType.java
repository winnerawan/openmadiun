package app.user;

import org.mongodb.morphia.annotations.Id;

/**
 * Created by winnerawan
 * on 2/9/17.
 */
public class UserType {

    @Id
    private String id;
    private String type;

    public UserType() { }

    public UserType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
