package c.adricals.restaurantadmin.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.LinkedList;
import java.util.List;

import c.adricals.restaurantadmin.MainActivity;
import c.adricals.restaurantadmin.R;
import c.adricals.restaurantadmin.Adapters.RestaurantAdapter;
import c.adricals.restaurantadmin.Restaurant;
import c.adricals.restaurantadmin.ui.restaurant.RestaurantFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RestaurantAdapter mAdapter;
    EditText mEditText;
    ChipGroup mChipGroup;
    Chip chipByTitle;
    Chip chipByLocation;




    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.restaurant_activity, container, false);


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
                Restaurant temRestaurant = mAdapter.getRestaurantItem(position);

                RestaurantFragment restaurantFragment = RestaurantFragment.newInstance(position,temRestaurant.getName());



                Toast.makeText(getContext(), "this is at position "+position, Toast.LENGTH_LONG).show();
                ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().addToBackStack("old").commit();
                ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,restaurantFragment,"new fragment add").commit();

            }
        });




        return root;
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