package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    EditText addCityField;

    Button addButton, deleteButton, confirmButton;

    int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize Views
        addButton     = findViewById(R.id.add_button);
        deleteButton  = findViewById(R.id.delete_button);
        cityList      = findViewById(R.id.city_list);
        addCityField  = findViewById(R.id.add_city_field);
        confirmButton = findViewById(R.id.confirm_button);

        // Initialize Data
        String [] cities = {"Islamabad", "Peshawar", "Lahore", "Karachi", "Quetta", "Gilgit"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        // Add Item
        addButton.setOnClickListener(v -> {
            addCityField.setVisibility(View.VISIBLE);
            confirmButton.setVisibility(View.VISIBLE);
        });

        confirmButton.setOnClickListener(v -> {
            String cityName = addCityField.getText().toString();
            if (!cityName.isEmpty()) {
                dataList.add(cityName);
                cityAdapter.notifyDataSetChanged();
                addCityField.setText("");
                addCityField.setVisibility(View.GONE);
                confirmButton.setVisibility(View.GONE);
            }
        });

        // Delete Item
        cityList.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition = position;
        });
        deleteButton.setOnClickListener(v -> {
            if (selectedPosition != -1 && !dataList.isEmpty()) {
                dataList.remove(selectedPosition);
                cityAdapter.notifyDataSetChanged();
                selectedPosition = -1;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
