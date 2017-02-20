package com.example.joakin.chatdint;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.utad.chatsdk.presenter.LoginPresenter;

/**
 * Created by joaquinlopezamador on 15/11/2016.
 */

public class LoginC implements View.OnClickListener{
    LoginPresenter loginPresenter;
    Login vista;


    public LoginC(Login vista) {
        loginPresenter = new LoginPresenter(vista.getApplicationContext());
        loginPresenter.attach(new LoginPresenter.LoginPresenterListener() {
            @Override
            public void onSuccess() {
                System.out.println("Logged");
            }

            @Override
            public void onError(String s) {

            }
        });
        this.vista = vista;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.BTNSIGNIN){
            String pass = vista.ETNPassword.getText().toString();
            String email = vista.ETNUser.getText().toString();
            loginPresenter.doLogin(email,pass);


            Intent intent = new Intent(vista,General.class);
            vista.startActivity(intent);
            vista.finish();
           /* Dataholder.mAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(vista, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                            if (task.isSuccessful()){
                                Intent intent = new Intent(vista,MainActivity.class);
                                vista.startActivity(intent);
                                vista.finish();
                            }

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Log.w(TAG, "signInWithEmail", task.getException());

                            }

                            // ...
                        }
                    });*/
        }else {
            FragmentManager fm=vista.getSupportFragmentManager();
            FragmentTransaction trns= fm.beginTransaction();

            trns.show(vista.fragmentSignUp);
            trns.commit();
        }



    }
}
