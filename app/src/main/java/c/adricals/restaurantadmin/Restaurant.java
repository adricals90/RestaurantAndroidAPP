package c.adricals.restaurantadmin;

public class Restaurant {

    int franchise_id;
    int restaurant_id;
    String name;
    String location;

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Restaurant(int franchise_id, int restaurant_id, String name, String location){
        this.franchise_id = franchise_id;
        this.restaurant_id = restaurant_id;
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
