package com.example.joakin.chatdint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.utad.chatsdk.data.ChatUser;
import com.utad.chatsdk.presenter.UsersPresenter;

import java.util.ArrayList;

public class General extends AppCompatActivity {
    UsersPresenter usersPresenter;
    ArrayList<ChatUser> usuarios;
    ChatListAdapter data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        usersPresenter = new UsersPresenter(getApplicationContext());
        usersPresenter.attach(new UsersPresenter.UsersPresenterListener() {
            @Override
            public void onSuccess(ArrayList<ChatUser> arrayList) {
                usuarios = arrayList;
                for (int j = 0; j < usuarios.size(); j++) {
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        final ListView list = (ListView) findViewById(R.id.listchats);
        System.out.println("usaurios " + usuarios);
        usuarios = new ArrayList<>();
        data = new ChatListAdapter(usuarios, this.getBaseContext());
        list.setAdapter(data);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(data.getItem(i));
                usersPresenter.initializeChat(usuarios.get(i));
                Intent intent = new Intent(General.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        });

    }
}
