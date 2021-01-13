package com.shakiba.spinnerwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.activity_main);
        mBinding= ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        List<String> gender = Arrays.asList(getResources().getStringArray(R.array.title_item));
        arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,gender);
        mBinding.Spinner.setAdapter(arrayAdapter);
        mBinding.Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                item = parent.getItemAtPosition(position).toString();
                mBinding.Spinner.setPrompt(item);
                mBinding.buttonSpinner.setOnClickListener(View->{
                    mBinding.textView.setText(item);
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
    }
}