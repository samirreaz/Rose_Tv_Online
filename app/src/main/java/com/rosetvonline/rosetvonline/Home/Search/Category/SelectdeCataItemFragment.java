package com.rosetvonline.rosetvonline.Home.Search.Category;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rosetvonline.rosetvonline.Home.Post.Post_adapter;
import com.rosetvonline.rosetvonline.Home.Post.Post_viewFragment;
import com.rosetvonline.rosetvonline.Home.Post_item;
import com.rosetvonline.rosetvonline.Home.Search.Search_viewFragment;
import com.rosetvonline.rosetvonline.R;
import com.rosetvonline.rosetvonline.Youtube.YoutubeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectdeCataItemFragment extends Fragment implements Post_adapter.MyOnClickListener {
    private Context context;
    private RecyclerView recyclerView;
    private Post_adapter post_adapter;
    List<Post_item> post_items;
    List<Post_item> catagoryBasedItems = new ArrayList<>();
    public SelectdeCataItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selectde_cata_item, container, false);
        post_items = Post_viewFragment.post_items;

        Bundle bundle = this.getArguments();
        String cataName = bundle.getString("cata_name");
        Toast.makeText (context, "CetaClick:"+cataName, Toast.LENGTH_SHORT).show ();
        /*for (Post_item p: post_items) {
            Toast.makeText(context, p.getPostTitle(), Toast.LENGTH_SHORT).show();
        }*/
        recyclerView = view.findViewById(R.id.cateItemRecyclerView);
        for (Post_item p:post_items){
            //if (p.getPostCategory().toLowerCase().equals(cataName.toLowerCase ()))
            if (p.getPostCategory().toLowerCase().equals(cataName.toLowerCase())|| p.getMawlanaName ().toLowerCase ().equals (cataName.toLowerCase ())){
                catagoryBasedItems.add(p);
            }
        }
        post_adapter = new Post_adapter(catagoryBasedItems,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        post_adapter.mySetOnItemClickListener(SelectdeCataItemFragment.this);
        recyclerView.setAdapter(post_adapter);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void myOnItemClick(int position) {
        Toast.makeText(getContext(), "Posintin"+position, Toast.LENGTH_SHORT).show();
        Intent i =new Intent(getContext(), YoutubeActivity.class);
        //i.putExtra("videoURL",post_items.get(position).getYoutubeURL());
        i.putExtra("videoURL",catagoryBasedItems.get(position).getYoutubeURL());
        i.putExtra("videoTitle",catagoryBasedItems.get(position).getPostTitle());
        i.putExtra("videoDescription",catagoryBasedItems.get(position).getPostDescription());
        startActivity(i);
    }

    @Override
    public void myOnWhatEventClick(int position) {

    }

    @Override
    public void myOnDeleteClick(int position) {

    }
}
