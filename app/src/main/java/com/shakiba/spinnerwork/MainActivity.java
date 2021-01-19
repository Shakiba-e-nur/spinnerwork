package com.shakiba.spinnerwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.shakiba.spinnerwork.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    ArrayAdapter<String> arrayAdapter;
    private String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mBinding= ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        setSpinner();
        onSubmit();
    }
    private void setSpinner()
    {
        mBinding.toolbar.arrow.setVisibility(View.GONE);
        mBinding.toolbar.textPlanetName.setText(R.string.app_name);
        List<String> gender = Arrays.asList(getResources().getStringArray(R.array.planet_item));
        arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,gender);
        mBinding.Spinner.setAdapter(arrayAdapter);
        mBinding.Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                item = parent.getItemAtPosition(position).toString();
                mBinding.Spinner.setPrompt(item);
                mBinding.textView.setText(item);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
    }
    private void onSubmit()
    {
        mBinding.buttonSpinner.setOnClickListener(View->{
            Intent intent=new Intent(this,PlanetDetailsActivity.class);
            intent.putExtra(PlanetDetailsActivity.PLANET,item);
            startActivity(intent);
        });
    }
}