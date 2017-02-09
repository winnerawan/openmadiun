package app.user;

/**
 * Created by winnerawan
 * on 2/9/17.
 */
public class Follow {

    private String id;
    private String follower_id;
    private String followee_id;

    public Follow() { }

    public Follow(String follower_id, String followee_id) {
        this.follower_id = follower_id;
        this.followee_id = followee_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(String follower_id) {
        this.follower_id = follower_id;
    }

    public String getFollowee_id() {
        return followee_id;
    }

    public void setFollowee_id(String followee_id) {
        this.followee_id = followee_id;
    }
}
