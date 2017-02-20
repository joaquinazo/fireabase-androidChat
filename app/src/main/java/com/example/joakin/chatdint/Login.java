package com.example.joakin.chatdint;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;



public class Login extends AppCompatActivity{
    LoginC loginC;
    Button BTNSignUp;
    Button BTNSignIn;
    EditText ETNUser;
    EditText ETNPassword;
    FragmentSignUp fragmentSignUp;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Quicksand-Bold.otf");

        //tx.setTypeface(custom_font);

        LoginC loginC = new LoginC(this);
        BTNSignUp = (Button) findViewById(R.id.BTNSIGNUP);
        BTNSignIn = (Button) findViewById(R.id.BTNSIGNIN);
        BTNSignIn.setTypeface(custom_font);
        BTNSignUp.setTypeface(custom_font);
        ETNUser = (EditText) findViewById(R.id.ETUSER);
        ETNUser.setTypeface(custom_font);
        ETNPassword = (EditText) findViewById(R.id.ETPASSWORD);
        BTNSignIn.setOnClickListener(loginC);
        BTNSignUp.setOnClickListener(loginC);

        fragmentSignUp=(FragmentSignUp)getSupportFragmentManager().findFragmentById(R.id.fragmentSignUp);
        fragmentSignUp.getView().setBackgroundColor(Color.WHITE);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction trns= fm.beginTransaction();
        trns.hide(fragmentSignUp);
        trns.commit();
    }


}
