package app.place;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class Location {

    private String address;
    private double latitude;
    private double longitude;

    public Location() { }

    public Location(String address, long latitude, long longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
