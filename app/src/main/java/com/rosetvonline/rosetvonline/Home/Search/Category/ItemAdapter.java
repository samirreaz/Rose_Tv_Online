package com.rosetvonline.rosetvonline.Home.Search.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rosetvonline.rosetvonline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> implements Filterable {
    private List<Item> items;
    private List<Item> filteredItems;
    private Context context;
    private OnCataClickListener cataClickListener;

    public ItemAdapter(List<Item> items, Context context) {
        this.items = items;
        this.filteredItems = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder (LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        //holder.imageView.setImageResource(filteredItems.get(position).getItemImage());
        holder.title.setText (filteredItems.get (position).getItemName ());
        holder.description.setText (filteredItems.get (position).getItemDescription ());
        Picasso.get ()
                //.with(context)
                .load (filteredItems.get (position).getItemImage ())
                .fit ()
                .centerCrop ()
                .into (holder.imageView);
    }

    @Override
    public int getItemCount() {
        return filteredItems.size ();
    }

    @Override
    public Filter getFilter() {

        return new Filter () {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String query = constraint.toString ();
                if (query.isEmpty ()) {
                    filteredItems = items;
                    //Toast.makeText (context, "isEmpty", Toast.LENGTH_SHORT).show ();
                } else {
                    List<Item> temptItem = new ArrayList<> ();
                    for (Item i : items) {
                        if (i.getItemName ().contains (query) || i.getItemCategoryName ().toLowerCase ().contains (query.toLowerCase ())) {
                            temptItem.add (i);
                        }
                    }
                    filteredItems = temptItem;
                }
                FilterResults results = new FilterResults ();
                results.values = filteredItems;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredItems = (List<Item>) results.values;
                notifyDataSetChanged ();
            }
        };
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title, description;


        public ItemViewHolder(@NonNull View itemView) {
            super (itemView);
            imageView = itemView.findViewById (R.id.cata_image);
            title = itemView.findViewById (R.id.textView_Mawlana);
            description = itemView.findViewById (R.id.cata_description);

            itemView.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {

                    //Toast.makeText(context, filteredItems.get(getAdapterPosition()).getItemName(), Toast.LENGTH_SHORT).show();

                    if (cataClickListener != null) {
                        int position = getAdapterPosition ();
                        if (position != RecyclerView.NO_POSITION) {
                            cataClickListener.catagoryClick (position, filteredItems.get (position).getItemCategoryName ());
                            Toast.makeText (context, filteredItems.get (position).getItemName (), Toast.LENGTH_SHORT).show ();
                        }
                    }

                }
            });
        }

    }

    public interface OnCataClickListener {
        void catagoryClick(int position, String cataName);
    }

    public void setOnCataClickListener(OnCataClickListener listener) {
        cataClickListener = listener;
    }
}
