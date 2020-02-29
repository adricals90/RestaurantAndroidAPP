package c.adricals.restaurantadmin.ui.restaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import c.adricals.restaurantadmin.R;

public class AddMenuFragment extends Fragment {

    private static String RESTID= "restaunrant_id-res";

    TextInputEditText mEnterMenuName;
    TextInputEditText mEnterDetails;
    TextInputEditText mEnterCategory;
    TextInputEditText mEnterPrice;

    public static AddMenuFragment newInstance(int restaurantId) {

        Bundle args = new Bundle();
        args.putInt(RESTID,restaurantId);
        AddMenuFragment fragment = new AddMenuFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.menu_add_fragment,container,false);
/*
        mEnterMenuName = root.findViewById(R.id.enter_menu_name_text_edit);
        mEnterDetails = root.findViewById(R.id.enter_details_text_edit);
        mEnterCategory = root.findViewById(R.id.enter_category_text_edit);
        mEnterPrice = root.findViewById(R.id.enter_price_text_edit);*/


        return root;



    }
}
