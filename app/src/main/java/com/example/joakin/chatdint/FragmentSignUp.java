package com.example.joakin.chatdint;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.utad.chatsdk.presenter.RegisterPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignUp extends Fragment implements View.OnClickListener {
    RegisterPresenter registerPresenter;
    Button BTNSignUp;
    Button BTNBack;
    EditText ETEmail;
    EditText ETPassword;
    EditText ETName;
    Login vista;

    public FragmentSignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment_sign_up, container, false);
        v.findViewById(R.id.fragmentSignUp);
        ETEmail = (EditText) v.findViewById(R.id.Email);
        ETPassword = (EditText) v.findViewById(R.id.Password);
        BTNSignUp = (Button) v.findViewById(R.id.BTNSIGNUPFRAG);
        BTNBack = (Button) v.findViewById(R.id.BTNBACKFRAG);
        BTNBack.setOnClickListener(this);
        BTNSignUp.setOnClickListener(this);
        registerPresenter = new RegisterPresenter(getContext());
        registerPresenter.attach(new RegisterPresenter.RegisterPresenterListener() {
            @Override
            public void onSuccess() {

                System.out.println("nuevo user");
            }

            @Override
            public void onError(String s) {

            }
        });

        return v;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.BTNBACKFRAG) {


            FragmentManager fm = getFragmentManager();
            FragmentTransaction trns = fm.beginTransaction();
            trns.hide(this);
            trns.commit();

        } else if (v.getId() == R.id.BTNSIGNUPFRAG) {

            registerPresenter.doRegister(ETEmail.getText().toString(),"joako",ETPassword.getText().toString());

        }
    }


}
