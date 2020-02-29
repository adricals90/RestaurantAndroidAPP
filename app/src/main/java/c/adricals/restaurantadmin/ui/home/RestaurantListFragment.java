package c.adricals.restaurantadmin.ui.home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.LinkedList;
import java.util.List;

import c.adricals.restaurantadmin.Adapters.RestaurantAdapter;
import c.adricals.restaurantadmin.R;
import c.adricals.restaurantadmin.Restaurant;
import c.adricals.restaurantadmin.ui.restaurant.RestaurantFragment;

public class RestaurantListFragment extends Fragment {

    private static String FRAGMENT_TAG = "home";

    private HomeViewModel homeViewModel;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RestaurantAdapter mAdapter;
    EditText mEditText;
    ChipGroup mChipGroup;
    Chip chipByTitle;
    Chip chipByLocation;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);


        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.restaurant_list_fragment, container, false);


        final List<Restaurant> restaurants = new LinkedList<>();
        restaurants.add(new Restaurant("Burguer King","Queens"));
        restaurants.add(new Restaurant("White Castle","Queens"));
        restaurants.add(new Restaurant("Wendi's","Manhattan"));
        restaurants.add(new Restaurant("Chipotle","Queens"));
        restaurants.add(new Restaurant("chipotle","Queens"));
        restaurants.add(new Restaurant("Papay's","Queens"));
        restaurants.add(new Restaurant("Burguer King","Queens"));
        restaurants.add(new Restaurant("Burguer King","Queens"));



        for(int i = 0; i < 10; i++){
            Restaurant res= new Restaurant("MacDonald's","Manhattan"+i);
            restaurants.add(res);

        }

        mEditText = root.findViewById(R.id.search_text_edit);
        mChipGroup = root.findViewById(R.id.search_chips);
        chipByTitle = root.findViewById(R.id.chip_title);
        chipByLocation = root.findViewById(R.id.chip_location);
        chipByTitle.setChecked(true);




        chipByTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chipByLocation.isChecked()){
                    chipByLocation.setChecked(false);
                    chipByLocation.setChipIconVisible(false);
                }else if(!chipByLocation.isChecked()){
                    chipByTitle.setChecked(true);
                }

            }
        });

        chipByLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chipByTitle.isChecked()){
                    chipByTitle.setChecked(false);
                    chipByTitle.setChipIconVisible(false);
                }else if(!chipByLocation.isChecked()){
                    chipByLocation.setChecked(true);
                }

            }
        });


        initRecyclerView(root,restaurants);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(chipByTitle.isChecked()){

                    search(restaurants, s.toString().toLowerCase());

                }else if (chipByLocation.isChecked()){

                    searchByLocation(restaurants,s.toString().toLowerCase());
                }

            }
        });


        mAdapter.setOnRestaurantItemClickListener(new RestaurantAdapter.OnItemRestaurantListener() {
            @Override
            public void getItemNum(int position) {

                addFragment(position);
            }
        });




        return root;
    }


    public void addFragment(int position){

        Restaurant temRestaurant = mAdapter.getRestaurantItem(position);

        RestaurantFragment restaurantFragment = RestaurantFragment.newInstance(position,temRestaurant.getName());

        Toast.makeText(getContext(), "this is at position "+position, Toast.LENGTH_LONG).show();

        FragmentManager fm = getParentFragment().getChildFragmentManager();
        fm.beginTransaction().
                 replace(R.id.restaurant_list_frame_container, restaurantFragment)
                .addToBackStack(null).commit();


    }





    public void search(List<Restaurant> restaurants, String s){

        List<Restaurant> list = new LinkedList<>();

        for(Restaurant item: restaurants){

            if(item.getName().toLowerCase().contains(s)){
                list.add(item);
            }


        }
        mAdapter.setList(list);

    }

    public void searchByLocation(List<Restaurant> restaurants, String s){
        List<Restaurant> list = new LinkedList<>();

        for(Restaurant item: restaurants){

            if(item.getLocation().toLowerCase().contains(s)){
                list.add(item);
            }

        }
        mAdapter.setList(list);
    }

    public void initRecyclerView(View view, List<Restaurant>restaurants){

        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RestaurantAdapter(view.getContext(),restaurants);
        mRecyclerView.setAdapter(mAdapter);


    }




}
