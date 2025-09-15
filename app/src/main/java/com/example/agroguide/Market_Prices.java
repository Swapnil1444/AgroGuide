package com.example.agroguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Market_Prices extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    private RecyclerView recyclerView;
    Spinner spinner1;
    private VegetableAdapter adapter1, adapter2,adapter3;
    String[] option1={"Select Option","Vagetabales","Cereals and Millets"};
     ArrayList<spineerlist> vegetables = new ArrayList<>();
    ArrayList<spineerlist> all = new ArrayList<>();
    SimpleDateFormat sdf=new SimpleDateFormat ("dd-MM-yyyy");
    String currentDate=sdf.format ( new Date() );
    ArrayList<spineerlist> Cereals=new ArrayList<> ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_prices);

        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        recyclerView = findViewById(R.id.recycler_view);
        spinner1=findViewById ( R.id.spinner1 );

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,option1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter ( adapter );
        spinner1.setOnItemSelectedListener(this);
        String selection = " Select Option";
        int spinnerPosition = adapter.getPosition(selection);
        spinner1.setSelection(spinnerPosition);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.backbutton,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int otpId= item.getItemId();
        if (otpId == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // on below line we are displaying toast message for selected item

        int i= position;
        if (i==0)
        {
           // all.add(new spineerlist("Carrot", "Pune", currentDate, "₹ 1700/Q"));
            adapter1 = new VegetableAdapter(all);
            recyclerView.setAdapter(adapter1);
            Toast.makeText(this, "Please Select Option...", Toast.LENGTH_SHORT).show();
        }
        if (i==1){
            vegetables.add(new spineerlist("Tomato", "Pune", currentDate, "₹ 1500/Q"));
            vegetables.add(new spineerlist("Onion", "Pune", currentDate, "₹ 1600/Q"));
            vegetables.add(new spineerlist("Potato", "Pune", currentDate, "₹ 1200/Q"));
            vegetables.add(new spineerlist("Green Chilli", "Pune", currentDate, "₹ 1100/Q"));
            vegetables.add(new spineerlist("Cabbage", "Pune", currentDate, "₹ 1200/Q"));
            vegetables.add(new spineerlist("Ginger", "Pune", currentDate, "₹ 1300/Q"));
            vegetables.add(new spineerlist("Brinjal", "Pune", currentDate, "₹ 1400/Q"));
            vegetables.add(new spineerlist("Garlic", "Pune", currentDate, "₹ 1600/Q"));
            vegetables.add(new spineerlist("Okra", "Pune", currentDate, "₹ 1200/Q"));
            vegetables.add(new spineerlist("Carrot", "Pune", currentDate, "₹ 1700/Q"));
            adapter2 = new VegetableAdapter(vegetables);
            recyclerView.setAdapter(adapter2);
            Toast.makeText(Market_Prices.this, " Vagetabales Selected..", Toast.LENGTH_SHORT).show();

        }
        else if (i==2){
            Cereals.add(new spineerlist("Wheat", "Pune", currentDate, "₹ 1500/Q"));
            Cereals.add(new spineerlist("Maize", "Pune", currentDate, "₹ 1400/Q"));
            Cereals.add(new spineerlist("Paddy", "Pune", currentDate, "₹ 1600/Q"));
            Cereals.add(new spineerlist("Pearl Millet", "Pune", currentDate, "₹ 1300/Q"));
            Cereals.add(new spineerlist("Sorghum", "Pune", currentDate, "₹ 1600/Q"));
            Cereals.add(new spineerlist("Barley", "Pune", currentDate, "₹ 1200/Q"));
            Cereals.add(new spineerlist("Finger Millet", "Pune", currentDate, "₹ 1700/Q"));
            Cereals.add(new spineerlist("Oat", "Pune", currentDate, "₹ 1400/Q"));
            Cereals.add(new spineerlist("Quinoa", "Pune", currentDate, "₹ 1600/Q"));
            Cereals.add(new spineerlist("Foxtail Millet", "Pune", currentDate, "₹ 1800/Q"));
            adapter3 = new VegetableAdapter(Cereals);
            recyclerView.setAdapter(adapter3);
            Toast.makeText(Market_Prices.this, "Cereals and Millets Selected..", Toast.LENGTH_SHORT).show();
        }
    }


    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged ( hasCapture );
    }
}