package c.adricals.restaurantadmin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import c.adricals.restaurantadmin.Dish;
import c.adricals.restaurantadmin.R;


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder>  {

    Context context;
    List<Dish> dishes;
    OnItemMenuListener listener;



    public MenuAdapter(Context context, List<Dish> dishList){
        this.context = context;
        this.dishes = dishList;

    }

    public void setOnMenuItemClickListener(OnItemMenuListener listener){
        this.listener = listener;
    }




    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        MenuHolder menuHolder = new MenuHolder(itemView, listener);


        return menuHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {


            Dish dish =  dishes.get(position);
            holder.mImageView.setImageResource(R.drawable.sample);
            holder.mDishTitle.setText(dish.getDishName());
            holder.mDetails.setText(dish.getDetails());
            holder.mCalories.setText(dish.getCalories());
            holder.mPrice.setText(""+dish.getPrice());
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }


    public Dish getItem(int position){
        return dishes.get(position);
    }

    protected class MenuHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mDishTitle;
        TextView mDetails;
        TextView mCalories;
        TextView mPrice;



        public MenuHolder(@NonNull View itemView, final OnItemMenuListener listener) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.dish_image_view);
            mDishTitle = itemView.findViewById(R.id.menu_title);
            mDetails = itemView.findViewById(R.id.details_view);
            mCalories = itemView.findViewById(R.id.calories_view);
            mPrice = itemView.findViewById(R.id.price_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.getItemNum(position);
                        }
                    }
                }
            });

        }
    }

    protected interface OnItemMenuListener{

        int getItemNum(int position);
    }
}
