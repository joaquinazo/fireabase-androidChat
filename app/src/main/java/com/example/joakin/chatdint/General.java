package com.example.joakin.chatdint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.utad.chatsdk.data.UserDetails;
import com.utad.chatsdk.presenter.UsersPresenter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class General extends AppCompatActivity {
    UsersPresenter usersPresenter;
    ArrayList<String> usuarios;
     ChatListAdapter data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        usersPresenter = new UsersPresenter(getApplicationContext());

        usersPresenter.attach(new UsersPresenter.UsersPresenterListener() {

            @Override
            public void onSuccess(int i, ArrayList<String> arrayList) {
                usuarios = arrayList;
                for (int j = 0; j < usuarios.size() ; j++) {
                    System.out.println(usuarios.get(j));
                }
                data.setUsuarios(usuarios);
                data.notifyDataSetChanged();

            }

            @Override
            public void onError(String s) {

            }
        });
        usersPresenter.getUsers();

        ArrayList<String> imagenes = new ArrayList<>(Arrays.asList("im1", "imusuario2", "imusuario3", "imusuario4", "imusuario5", "imusuario6"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        final ListView list = (ListView) findViewById(R.id.listchats);
        System.out.println("usaurios " + usuarios);
        usuarios = new ArrayList<>();
        data = new ChatListAdapter(usuarios, imagenes, this.getBaseContext());
        list.setAdapter(data);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(data.getItem(i));
                UserDetails.chatWith = data.getItem(i);
                Intent intent = new Intent(General.this,MainActivity.class);
                startActivity(intent);
                finish();



            }
        });

    }
}
