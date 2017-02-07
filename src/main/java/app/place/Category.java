package app.place;

import org.mongodb.morphia.annotations.Id;

import java.util.UUID;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class Category {

    @Id
    private String id;
    private String category;

    public Category() { }
/*
    public Category(String category) {
        this.category = category;
    }
*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
