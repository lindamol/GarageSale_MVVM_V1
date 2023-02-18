package com.example.garagesale_mvvm.viemodel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.garagesale_mvvm.model.LoginModel;

public class LoginViewModel extends BaseObservable {
    //Creating object of Model class
    private LoginModel loginmodel;

    //String variable for toast messages
    private String successMessage = "Login successful";
    private String errorMessage = "Email or Password is not valid";

    @Bindable
    //String variable for toast message
    private String toastMessage = null;

    // Getter/Setter methods for toast message

    public String getToastMessage(){
        return toastMessage;
    }

    private void setToastMessage(String toastMessage){
        this.toastMessage = toastMessage;
       // notifyPropertyChanged(BR.toastMessage);
    }
    // Getter/Setter methods for Email

    @Bindable
    public String getUserEmail(){
        return loginmodel.getEmail();
    }
    public void setUserEmail(String email){
        loginmodel.setEmail(email);
        notifyPropertyChanged(BR._all);
        //notifyPropertyChanged(BR,userPassword);
    }
    public void setUserPassword(String password){
        loginmodel.setPassword(password);
        notifyPropertyChanged(BR._all);
    }
    public String getUserPassword()
    {
        return loginmodel.getPassword();
    }
    //Constructor of LoginViewmodel
    public LoginViewModel(){
        //instantiate object of loginmodel class
        loginmodel = new LoginModel("","");
    }
    //Actions to be performed when user clicks the Login button
    public void onButtonClicked(){
        if (isValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }
    //Method to keep a check that variable fields must not be kept empty by user
    public boolean isValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }

    }
