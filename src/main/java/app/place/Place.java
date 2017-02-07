package app.place;

import org.mongodb.morphia.annotations.Id;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class Place {

    @Id
    private String id;
    private String title;
    private Location location;
    private String description;
    private String telephone;
    private String category;
    private String opening_hours;
    private String price_range;
    private float rating;
    private String img_url;

    public Place() { }

    public Place(String title, Location location, String description, String telephone, String category, String opening_hours, String price_range, float rating, String img_url) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.telephone = telephone;
        this.category = category;
        this.opening_hours = opening_hours;
        this.price_range = price_range;
        this.rating = rating;
        this.img_url = img_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
