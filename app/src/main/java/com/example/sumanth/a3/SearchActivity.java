package com.example.sumanth.a3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
SearchView searchView;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchView  = (SearchView)findViewById(R.id.search);
        listView = (ListView)findViewById(R.id.list_view);
        ArrayList<String> array = new ArrayList<String>();
        array.add("Sumanth");
        array.add("Nishnath");
        array.add("Achutha");
        array.add("Vamsi");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SearchActivity.this,android.R.layout.simple_list_item_1,array);
        listView.setAdapter(arrayAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
