package com.example.medplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ArrayList<Model> datalist = new ArrayList<Model>();
    //RecyclerView myRv;
    //String URL = "https://script.google.com/macros/s/AKfycbyt8031eKwwSmiNIhPnDih84__z9y_kN-j34Y0PrDWa1adwBcbwSCqp8qMjIEujoLCb/exec"


    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById(R.id.myRv);

        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if(user == null)
        {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

     /*public void parseApidata()
    {
        Adapter adapter = new Adapter(datalist,this);
        myRv.setLayoutManager(new LinearLayoutManager(this,Recyclerview.VERTICAL,false);
        myRv.setAdapter(adapter);

        StringRequest stringRequest
    }
    */
}