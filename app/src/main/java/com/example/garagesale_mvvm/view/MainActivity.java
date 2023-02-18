package com.example.garagesale_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingComponent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.garagesale_mvvm.R;
import com.example.garagesale_mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
       ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
             //setContentView(R.layout.activity_main);
       // activityMainBinding.setMyvariable("Welcome to GarageSale");
    }
    @BindingAdapter({ "toastMessage" })
    public static void runMe(View view, String message) {
        if (message != null)
            Toast
                    .makeText(view.getContext(), message,
                            Toast.LENGTH_SHORT)
                    .show();

    }
//    public void EmailLogin(View view) {
//    }
//
//    public void Forgotpassword(View view) {
//    }
//
//    public void NewRegister(View view) {
//    }
}