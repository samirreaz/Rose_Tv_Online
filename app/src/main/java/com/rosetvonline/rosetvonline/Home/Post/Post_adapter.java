package com.rosetvonline.rosetvonline.Home.Post;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;


import com.rosetvonline.rosetvonline.Home.Post_item;
import com.rosetvonline.rosetvonline.R;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Post_adapter extends RecyclerView.Adapter <Post_adapter.PostHolder> {
    private List<Post_item> post_items;
    private Context context;
    private MyOnClickListener mListener;

    public Post_adapter(List<Post_item> post_items, Context context) {
        this.post_items = post_items;
        this.context = context;

    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view_row,parent,false);
        //return null;
        return new PostHolder(itemView);*/
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.post_view_row,parent,false);
        PostHolder ph = new PostHolder(view);
        return ph;
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        //holder.imageView.setImageResource(Integer.parseInt(post_items.get(position).getImageURL()));
//        holder.title.setText(post_items.get(position).getPostTitle());
//        holder.mowlana.setText(post_items.get(position).getMawlanaName());
//        holder.description.setText(post_items.get(position).getPostDescription());


        Post_item item = post_items.get(position);
        holder.title.setText(item.getPostTitle());
        holder.mowlana.setText(item.getMawlanaName());
        holder.description.setText(item.getPostDescription());
        Picasso.get ()
                //.with(context)
                //.load(post_items.get(position).getImageURL())
                .load(item.getImageURL())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        //return 0;
        return post_items.size();
    }


    public class PostHolder extends RecyclerView.ViewHolder{
        private AppCompatImageView imageView;
        private TextView title, mowlana, description;

        public PostHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.tv_postTitle);
            mowlana = itemView.findViewById(R.id.tv_mawlanaName);
            description = itemView.findViewById(R.id.tv_postDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    int posi = getAdapterPosition();
//                    Toast.makeText(v.getContext(), post_items.get(posi).getPostTitle(), Toast.LENGTH_SHORT).show();
//                    Intent n = new Intent(v.getContext(), YoutubeActivity.class);
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.myOnItemClick(position);
                        }
                    }

                }
            });
        }
    }

    public interface MyOnClickListener{
        void myOnItemClick(int position);
        void myOnWhatEventClick(int position);
        void myOnDeleteClick(int position);
    }

    public void mySetOnItemClickListener(MyOnClickListener listener){
        mListener = listener;
    }
}
