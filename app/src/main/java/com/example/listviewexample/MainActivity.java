package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

import Model.Pet;

public class MainActivity extends AppCompatActivity {


    ListView petListWidget;
    ArrayList<Pet> pets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random ran = new Random();
        pets = new ArrayList<>();
        pets.add(new Pet(14, "Husky", "Kenny"));
        pets.add(new Pet(22, "Chezklosokovian wolf dog", "Roe"));
        pets.add(new Pet(14, "Husky", "Zachary"));
        pets.add(new Pet(14, "Husky", "Vincenzo"));
        pets.add(new Pet(ran.netxtInt(), "Husky", "Josua"));


        petListWidget = findViewById(R.id.ListViewWidget);

        int selection = 1;
        populateListView(selection);
    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String [] contents = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contents);
        petListWidget.setAdapter(adapter);

    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pets);
        petListWidget.setAdapter(adapter);



    }


}