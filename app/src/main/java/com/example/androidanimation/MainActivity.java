package com.example.androidanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImage;
    private TextView mName, mDescription, mClickText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mClickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair(mImage, "imageTransition");
                pairs[1] = new Pair(mName, "nameTransition");
                pairs[2] = new Pair(mDescription, "descriptionTransition");

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(secondActivity, activityOptions.toBundle());
            }
        });
    }

    private void init()
    {
        mImage = findViewById(R.id.myImage);
        mName = findViewById(R.id.name);
        mDescription = findViewById(R.id.description);
        mClickText = findViewById(R.id.clicktext);
    }
}