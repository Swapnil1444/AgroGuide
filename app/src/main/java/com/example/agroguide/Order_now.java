package com.example.agroguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Order_now extends AppCompatActivity {

    Toolbar toolbar;
    FirebaseDatabase database;
    DatabaseReference reference;
    EditText name,number,email,street,city,state,pincode,card_number,mm_yy,cvv;
    Button canfom;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_now);

        toolbar=findViewById(R.id.toolbar1);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        name=findViewById(R.id.Name);
        email=findViewById(R.id.Email);
        number=findViewById(R.id.Number);
        state=findViewById(R.id.State);
        street=findViewById(R.id.Street);
        city=findViewById(R.id.City);
        pincode=findViewById(R.id.pincode);
        card_number=findViewById(R.id.Credit_card_number);
        mm_yy=findViewById(R.id.mm_yy);
        cvv=findViewById(R.id.cvv);

        canfom=findViewById(R.id.confirm);

        Intent intent=getIntent();
        String prodect_nameIN=intent.getStringExtra("prodect_name");
        String priceIN=intent.getStringExtra("price");
        Dialog dialog;
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_castam_dailog_box);
        // dialog.setCancelable(false);
        Button btnok=dialog.findViewById(R.id.okbtn);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                dialog.dismiss();
            }
        });
        canfom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                database=FirebaseDatabase.getInstance();
                reference=database.getReference("pyment details");
                String sname=name.getText().toString();
                String semail=email.getText().toString();
                String snumber=number.getText().toString();
                String scity=city.getText().toString();
                String sstate=state.getText().toString();
                String sstreet=street.getText().toString();
                String spin=pincode.getText().toString();
                String scard=card_number.getText().toString();
                String smm=mm_yy.getText().toString();
                String scvv=cvv.getText().toString();
                String prodect_name=prodect_nameIN;
                String price=priceIN;

                if(!validusername()|!validemail()|validnumber()|!validStreet()|!validcity()|!validcity()|!valistate()|!validpin()|!validcard()|!validmm()|!validcvv()) {

                    if(!sname.isEmpty())
                    {
                        dialog.show();
                        pymentAdaptar adaptar = new pymentAdaptar(sname, semail, snumber, scity, sstate, spin, scard, smm, scvv,prodect_name,price);
                        reference.child(sname).setValue(adaptar);

                    }
                }
                else
                {
                    name.setError("Error");
                }
            }
        });
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

    public boolean validusername() {
        String val = name.getText().toString();
        if (val.isEmpty()) {
            name.setError("Name cannot be empty");
            return false;
        } else {
            name.setError(null);
            return true;
        }
    }
    public boolean validemail() {
            String val = email.getText().toString();
            if (val.isEmpty()) {
                email.setError("Email cannot be empty");
                return false;
            } else {
                email.setError(null);
                return true;
            }
        }
    public boolean validnumber() {
        String val = number.getText().toString();
        if (val.isEmpty()) {
            number.setError("Number cannot be empty");
            return false;
        } else {
            number.setError(null);
            return true;
        }
    }
    public boolean validStreet() {
        String val = street.getText().toString();
        if (val.isEmpty()) {
            street.setError("Street cannot be empty");
            return false;
        } else {
            street.setError(null);
            return true;
        }
    }
    public boolean validcity() {
        String val = city.getText().toString();
        if (val.isEmpty()) {
            city.setError("city cannot be empty");
            return false;
        } else {
            city.setError(null);
            return true;
        }
    }
    public boolean valistate() {
        String val = state.getText().toString();
        if (val.isEmpty()) {
            state.setError("State cannot be empty");
            return false;
        } else {
            state.setError(null);
            return true;
        }
    }
    public boolean validpin() {
        String val = pincode.getText().toString();
        if (val.isEmpty()) {
            pincode.setError("Pin code cannot be empty");
            return false;
        } else {
            pincode.setError(null);
            return true;
        }
    }
    public boolean validcard() {
        String val =card_number .getText().toString();
        if (val.isEmpty()) {
            card_number.setError("Card_number cannot be empty");
            return false;
        } else {
            card_number.setError(null);
            return true;
        }
    }
    public boolean validmm() {
        String val =mm_yy.getText().toString();
        if (val.isEmpty()) {
            mm_yy.setError("MM/YY cannot be empty");
            return false;
        } else {
            mm_yy.setError(null);
            return true;
        }
    }
    public boolean validcvv() {
        String val =cvv.getText().toString();
        if (val.isEmpty()) {
            cvv.setError("CVV cannot be empty");
            return false;
        } else {
            cvv.setError(null);
            return true;
        }
    }
}