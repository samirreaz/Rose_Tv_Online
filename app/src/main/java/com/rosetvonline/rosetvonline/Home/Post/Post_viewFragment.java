package com.rosetvonline.rosetvonline.Home.Post;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rosetvonline.rosetvonline.Home.Post_item;
import com.rosetvonline.rosetvonline.Home.Search.Category.Item;
import com.rosetvonline.rosetvonline.R;
import com.rosetvonline.rosetvonline.Youtube.YoutubeActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Post_viewFragment extends Fragment implements Post_adapter.MyOnClickListener {
    private RecyclerView recyclerView;
    private Post_adapter post_adapter;

    private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private DatabaseReference eventRef;
    private FirebaseUser user;
    public static List<Post_item> post_items;


    public Post_viewFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_view, container, false);
            recyclerView = view.findViewById(R.id.postRecyclerView);
            post_items = new ArrayList<>();


            //post_items= Post_item.generatePostItem();
            post_adapter = new Post_adapter(post_items,getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            post_adapter.mySetOnItemClickListener(Post_viewFragment.this);
            recyclerView.setAdapter(post_adapter);

        user = FirebaseAuth.getInstance().getCurrentUser();
        rootRef = FirebaseDatabase.getInstance().getReference();
           /* userRef = rootRef.child(user.getUid());
            eventRef = userRef.child("Posts");*/
        eventRef = rootRef.child("Posts");

        eventRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                post_items.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    Post_item postItem = ds.getValue(Post_item.class);
                    post_items.add(postItem);
                }
                Collections.reverse (post_items);
                post_adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void myOnItemClick(int position) {
        Toast.makeText(getContext(), "Posintin"+position, Toast.LENGTH_SHORT).show();
        Intent i =new Intent(getContext(), YoutubeActivity.class);
        i.putExtra("videoURL",post_items.get(position).getYoutubeURL());
        i.putExtra("videoTitle",post_items.get(position).getPostTitle());
        i.putExtra("videoDescription",post_items.get(position).getPostDescription());
        startActivity(i);
    }

    @Override
    public void myOnWhatEventClick(int position) {

    }

    @Override
    public void myOnDeleteClick(int position) {

    }
}
