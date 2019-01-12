package com.ani.liga;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {
    ImageView imageView;
            TextView tvidLeague, tvstrLeague, tvintFormedYear;

     private Liga liga;
     @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.imgstrTeamLogo);
        tvidLeague = findViewById(R.id.idLeague);
        tvintFormedYear = findViewById(R.id.tvintFormedYear);
        tvstrLeague = findViewById(R.id.strLeague);


        liga = getIntent().getParcelableExtra("liga");

        Glide.with(this).load(liga.getStrTeamLogo()).into(imageView);
        tvidLeague.setText(liga.getIdLeague());
        tvstrLeague.setText(liga.getStrLeague());
        tvintFormedYear.setText(liga.getIntFormedYear());

    }


}
