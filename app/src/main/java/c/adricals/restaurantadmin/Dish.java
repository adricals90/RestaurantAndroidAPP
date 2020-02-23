package c.adricals.restaurantadmin;

public class Dish {

    private String dishName;
    private double price;
    private String calories;
    private String details;
    private String category; // Breakfast - lunch - dinner;

    public Dish(String dishName, double price, String details ,String calories, String category) {
        this.dishName = dishName;
        this.price = price;
        this.calories = calories;
        this.category = category;
        this.details = details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public String getDishName() {
        return dishName;
    }

    public double getPrice() {
        return price;
    }

    public String getCalories() {
        return calories;
    }

    public String getCategory() {
        return category;
    }



}
