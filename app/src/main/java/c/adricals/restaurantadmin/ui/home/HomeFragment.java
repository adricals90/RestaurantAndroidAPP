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

import c.adricals.restaurantadmin.R;
import c.adricals.restaurantadmin.Adapters.RestaurantAdapter;
import c.adricals.restaurantadmin.Restaurant;
import c.adricals.restaurantadmin.ui.restaurant.RestaurantFragment;

public class HomeFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_home,container, false);
        addFragment();
        return root;
    }



    public void addFragment(){


        RestaurantListFragment restaurantListFragment = new RestaurantListFragment();

        Toast.makeText(getContext(), "list added ", Toast.LENGTH_LONG).show();

        FragmentManager fm = getChildFragmentManager();
            fm.beginTransaction().
                    replace(R.id.restaurant_list_frame_container, restaurantListFragment)
                    .setTransitionStyle(Fade.MODE_IN)
                    .commit();

    }










}