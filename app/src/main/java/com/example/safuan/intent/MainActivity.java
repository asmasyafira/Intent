package com.example.safuan.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMoveWithDataActivity, btnMoveWithObjectActivity, btnDialPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveWithDataActivity = findViewById(R.id.btn_move_with_data);
        btnMoveWithObjectActivity = findViewById(R.id.btn_move_with_object);
        btnDialPhone = findViewById(R.id.btn_dial_number);
        btnMoveWithDataActivity.setOnClickListener(this); //alt enter make
        btnMoveWithObjectActivity.setOnClickListener(this);
        btnDialPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_with_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"IDN AKHWAT");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,3);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_with_object:
                Person person = new Person();
                person.setName("Asma Syafira");
                person.setAge(16);
                person.setEmail("syafirasma@gmail.com");
                person.setAlamat("Bekasi");

                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person); //person nya yg dikirim
                startActivity(moveWithObjectIntent);
                break;
            case R.id.btn_dial_number: //kalo case pake titik dua
                String phoneNumber = "081293928240";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}
