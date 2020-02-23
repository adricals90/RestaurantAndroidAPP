package c.adricals.restaurantadmin;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Parser {

    List<Restaurant> restaurants;

    Parser(){

    }


    List<Restaurant> getData(JSONArray array){

        int franchise_id;
        int restaurant_id;
        String name;
        String location;

        for(int i = 0; i < array.length(); i++){

            try{
                JSONObject temp =array.getJSONObject(i);

                franchise_id =  temp.getInt("franchise id");
                restaurant_id =  temp.getInt("restaurant id");
                name = temp.getString("name");
                location = temp.getString("location");

                Restaurant restaurant = new Restaurant(franchise_id,restaurant_id,name,location);
                restaurants.add(restaurant);

            }catch (JSONException e){

                Log.d("jason parsing"," error parsing");

            }

        }

        return restaurants;
    }



}
