package com.shakiba.spinnerwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.shakiba.spinnerwork.databinding.ActivityPlanetDetailsBinding;

public class PlanetDetailsActivity extends AppCompatActivity {
    ActivityPlanetDetailsBinding mBinding;
    public static String PLANET = "planet";
    String s;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_planet_details);
        mBinding = ActivityPlanetDetailsBinding.inflate(getLayoutInflater());
        view = mBinding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        s = intent.getStringExtra(PLANET);
        checkPlanet(s);
        mBinding.toolbar.arrow.setOnClickListener(View -> {
            finish();
            onBackPressed();
        });
    }
    private void checkPlanet(String planet) {
        switch (planet) {
            case "Mercury":
                setResource(R.drawable.mercury, R.string.mercury, R.string.mercury_description);
                break;
            case "Venus":
                setResource(R.drawable.venus, R.string.venus, R.string.venus_description);
                break;
            case "Earth":
                setResource(R.drawable.earth, R.string.earth, R.string.earth_description);
                break;
            case "Mars":
                setResource(R.drawable.mars, R.string.mars, R.string.mars_description);
                break;
            case "Jupiter":
                setResource(R.drawable.jupitor, R.string.jupiter, R.string.jupiter_description);
                break;
            case "Saturn":
                setResource(R.drawable.saturn, R.string.saturn, R.string.saturn_description);
                break;
            case "Neptune":
                setResource(R.drawable.neptune, R.string.neptune, R.string.neptune_description);
                break;
            case "Pluto":
                setResource(R.drawable.pluto, R.string.pluto, R.string.pluto_description);
                break;
            default:
                break;
        }
    }
    private void setResource(int image, int name, int description) {
        mBinding.imageViewPlanet.setBackgroundResource(image);
        mBinding.toolbar.textPlanetName.setText(getString(name));
        mBinding.textPlanetName.setText(getString(name));
        mBinding.textPlanetDetails.setText(getString(description));
    }
}