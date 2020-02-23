package c.adricals.restaurantadmin;

import java.util.List;

public class Menu {

    private int menuId;
    private int restaurantid;
    private List<List<Dish>> dishes;

    public Menu(int menuId, int restaurantid, String name, List<List<Dish>> dishes) {
        this.menuId = menuId;
        this.restaurantid = restaurantid;
        this.dishes = dishes;

    }


    public List<List<Dish>> getDishes() {
        return dishes;
    }

    public int getMenuId() {
        return menuId;
    }

    public int getRestaurantid() {
        return restaurantid;
    }



    public void setDishes(List<List<Dish>> dishes) {
        this.dishes = dishes;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

}
