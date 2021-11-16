package com.example.test23;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ImageView img = findViewById(R.id.imageView2);

        String thumbnail = "profile not set";
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            thumbnail = extras.getString("thumbnail");
        }

        img.setImageDrawable(Drawable.createFromPath(thumbnail));

    }
}
