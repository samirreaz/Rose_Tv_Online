package com.rosetvonline.rosetvonline.Home.Search.Category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.rosetvonline.rosetvonline.Home.Search.Search_viewFragment;
import com.rosetvonline.rosetvonline.R;
import com.rosetvonline.rosetvonline.Youtube.YoutubeActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryClickViewActivity extends AppCompatActivity {
    private TextView textView;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_click_view);
        textView = findViewById(R.id.txt_view);

        String categoryName = getIntent().getExtras().getString("cataName");
        textView.setText(categoryName);

        fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("cata_name",categoryName);

        FragmentTransaction ft = fm.beginTransaction();
        SelectdeCataItemFragment selectdeCataItemFragment = new SelectdeCataItemFragment();
        selectdeCataItemFragment.setArguments(bundle);
        ft.add(R.id.catagoryClickedItemContainer,selectdeCataItemFragment);
        ft.commit();


       /* ArrayList<Item> i= Search_viewFragment.items;
        for (Item j:i){
            //System.out.println(j.getItemName());
            Toast.makeText(this, j.getItemName(), Toast.LENGTH_SHORT).show();
        }*/

        /*Bundle b = new Bundle();
        b.putCharSequenceArrayList(b);*/
    }
}
