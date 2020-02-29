package c.adricals.restaurantadmin.ui.restaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import c.adricals.restaurantadmin.Adapters.MenuAdapter;
import c.adricals.restaurantadmin.Dish;
import c.adricals.restaurantadmin.Menu;
import c.adricals.restaurantadmin.R;


public class MenuFragment extends Fragment {

    RecyclerView mMenuRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    MenuAdapter menuAdapter;
    List<Dish> dishes;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle bundle){

        View root = inflater.inflate(R.layout.fragment_menu_list,container,false);

        List<Menu> menuList = new LinkedList<>();

         dishes= new LinkedList<>();


        for(int i = 0; i < 15; i++){

            Dish dish = new Dish("BigMac", 6.3,"1000","Fast Food","lunch");
            dishes.add(dish);

        }


        initRecyclerView(root, dishes);


        return root;
    }

    public void initRecyclerView(View view, List<Dish> dishCategory ){

        mMenuRecyclerView = view.findViewById(R.id.menu_recyclerView);
        mMenuRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(view.getContext());
        mMenuRecyclerView.setLayoutManager(mLayoutManager);

        menuAdapter = new MenuAdapter(view.getContext(), dishCategory);
        mMenuRecyclerView.setAdapter(menuAdapter);
    }

}
