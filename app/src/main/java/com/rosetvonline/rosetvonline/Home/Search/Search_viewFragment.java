package com.rosetvonline.rosetvonline.Home.Search;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rosetvonline.rosetvonline.Home.Search.Category.CategoryClickViewActivity;
import com.rosetvonline.rosetvonline.Home.Search.Category.Item;
import com.rosetvonline.rosetvonline.Home.Search.Category.ItemAdapter;
import com.rosetvonline.rosetvonline.Home.Search.Category.SelectdeCataItemFragment;
import com.rosetvonline.rosetvonline.R;
import com.rosetvonline.rosetvonline.Youtube.YoutubeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Search_viewFragment extends Fragment implements ItemAdapter.OnCataClickListener {
    private SearchView searchView;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private LinearLayoutManager llm;
    private GridLayoutManager glm;
    public static ArrayList<Item> items;

    public Search_viewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_view, container, false);
            searchView = view.findViewById(R.id.searchView);
            recyclerView = view.findViewById(R.id.categoryRecyclerView);

        /*if (searchView != null) {
            searchView.setQuery("", false);
            searchView.clearFocus();
            //searchView.onActionViewCollapsed();
        }*/


        items = Item.genetateCategory();
        itemAdapter = new ItemAdapter(items,getContext());
        llm = new LinearLayoutManager(getContext());
        glm = new GridLayoutManager(getContext(),2);
        llm.setOrientation(RecyclerView.VERTICAL);
        //recyclerView.setLayoutManager(llm);
        recyclerView.setLayoutManager(glm);
        itemAdapter.setOnCataClickListener(Search_viewFragment.this);
        recyclerView.setAdapter(itemAdapter);




        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                itemAdapter.getFilter().filter(newText);
                //Toast.makeText(getContext(), newText, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        return view;
    }

    @Override
    public void catagoryClick(int position,String itemCataName) {
        Intent intent = new Intent(getContext(), CategoryClickViewActivity.class);
        intent.putExtra("cataName",itemCataName);
        startActivity(intent);
        searchView.setFocusable(true);
        //Toast.makeText(getContext(), "passValue:"+items.get(position).getItemCategoryName(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(getContext(), "CataName:"+itemCataName, Toast.LENGTH_SHORT).show();


       /* SelectdeCataItemFragment s = new SelectdeCataItemFragment();
        Bundle b = new Bundle();
        b.putCharSequenceArrayList(items);
        s.setArguments(items);*/
    }

}
