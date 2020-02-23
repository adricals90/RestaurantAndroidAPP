package c.adricals.restaurantadmin.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import c.adricals.restaurantadmin.R;
import c.adricals.restaurantadmin.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>{
    Context context;
    private List<Restaurant> restaurantList;
    private OnItemRestaurantListener listener;



   public RestaurantAdapter(Context context, List<Restaurant> list){
        this.context = context;
        this.restaurantList = list;
    }

    public void setOnRestaurantItemClickListener(OnItemRestaurantListener listener){
       this.listener = listener;
    }



    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item,parent,false);
        RestaurantViewHolder  restaurantHolder= new RestaurantViewHolder(itemView, listener);
        return restaurantHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        //
        holder.mImageView.setImageResource(R.drawable.ic_restaurant_black_24dp);
        holder.mTittleView.setText(restaurantList.get(position).getName());
        holder.mDistance.setText(restaurantList.get(position).getLocation());
        holder.mPrice.setText("$$");
        holder.mDetails.setText("Fast Food");
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public void setList(List<Restaurant> list){
       restaurantList = list;
       notifyDataSetChanged();
    }

    public Restaurant getRestaurantItem(int position){
       return restaurantList.get(position);

    }
    protected class RestaurantViewHolder extends RecyclerView.ViewHolder {

        TextView mTittleView;
        ImageView mImageView;
        TextView mDetails;
        TextView mPrice;
        TextView mDistance;


        public RestaurantViewHolder(@NonNull final View itemView, final OnItemRestaurantListener listener) {
            super(itemView);

            mTittleView = itemView.findViewById(R.id.menu_tittle_view);
            mImageView = itemView.findViewById(R.id.restaurant_image);
            mDetails = itemView.findViewById(R.id.details_view);
            mPrice = itemView.findViewById(R.id.price_view);
            mDistance = itemView.findViewById(R.id.distance);

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

    public interface OnItemRestaurantListener{
       void getItemNum(int position);
    }


}
