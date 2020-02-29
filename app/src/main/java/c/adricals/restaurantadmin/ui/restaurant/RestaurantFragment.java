package c.adricals.restaurantadmin.ui.restaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import c.adricals.restaurantadmin.MainActivity;
import c.adricals.restaurantadmin.R;
import c.adricals.restaurantadmin.Restaurant;

public class RestaurantFragment extends Fragment {

    static final String RESTAURANT_ID = "restaurant_id";

    private RestaurantViewModel restaurantViewModel;
   // Fragment menuFragment;
   // Fragment addMenuFragment;

    ImageView restaurantImage;
    TextView textView;
    FloatingActionButton addMenus;


    public static RestaurantFragment newInstance(int restId, String restName) {

        Bundle args = new Bundle();
        args.putInt(RESTAURANT_ID, restId);
        args.putString(RESTAURANT_ID,restName);

        RestaurantFragment fragment = new RestaurantFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        restaurantViewModel = ViewModelProviders.of(this).get(RestaurantViewModel.class);
        View root = inflater.inflate(R.layout.restaurant_fragment_layout, container, false);

        textView = root.findViewById(R.id.restaurant_name_view);
        addMenus= root.findViewById(R.id.fab_add_menu);
        restaurantImage = root.findViewById(R.id.restaurant_picture_view);


        restaurantViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


                textView.setText(s);


            }
        });

        final Bundle args = getArguments();

        if(args != null){
            Toast.makeText(getContext(), "hh "+args.getString(RESTAURANT_ID),Toast.LENGTH_LONG).show();

            restaurantViewModel.getText().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    String t = args.getString(RESTAURANT_ID);
                    textView.setText(t);
                }
            });


        }


        Fragment menuFragment = getFragmentManager().findFragmentById(R.id.menu_fragment_container);


        if(menuFragment == null){

            menuFragment = new MenuFragment();
            getChildFragmentManager().
                    beginTransaction().add(R.id.menu_fragment_container, menuFragment)
                    .commit();
        }



        addMenus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addFragment();

            }
        });



        return root;
    }





    public void addFragment(){

        if(addMenus.isShown()){
             addMenus.hide();
            restaurantImage.setMaxWidth(30);
        }else{
            addMenus.show();
        }

        Fragment addMenuFragment;

            Toast.makeText(getContext(),"Is null",Toast.LENGTH_LONG ).show();

            addMenuFragment  = new AddMenuFragment();


            getParentFragment().getChildFragmentManager()
            .beginTransaction()
                    .replace(R.id.menu_fragment_container, addMenuFragment)
                    .addToBackStack(null)
                    .commit();

    }


}