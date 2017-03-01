package com.example.joakin.chatdint;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.utad.chatsdk.data.ChatInstance;
import com.utad.chatsdk.data.ChatMessage;
import com.utad.chatsdk.data.ChatUser;
import com.utad.chatsdk.presenter.ChatPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> User;
    public ArrayList<String> imge;
    public ArrayList<String> message;
    EditText editText;
    Button button;
    ChatPresenter chatPresenter;
    public DataListAdapter data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.otf");
        chatPresenter = new ChatPresenter(getApplicationContext());
        chatPresenter.attach(new ChatPresenter.ChatPresenterListener() {
            @Override
            public void onSendSuccess(ChatMessage chatMessage) {
                message.add(chatMessage.getText());
                imge.add("URL2");
                User.add(chatMessage.getSender().getName());
                data.notifyDataSetChanged();
            }

            @Override
            public void onReceive(ChatMessage chatMessage) {

            }

            @Override
            public void onSendError(String s) {

            }
        });

        super.onCreate(savedInstanceState);
        User = new ArrayList<>();
        message = new ArrayList<>();
        imge = new ArrayList<>();
        setContentView(R.layout.activity_main);
        final ListView list = (ListView) findViewById(R.id.list);
        data = new DataListAdapter(User, imge, message, this.getBaseContext());
        editText = (EditText) findViewById(R.id.text);
        editText.setTypeface(custom_font);
        button = (Button) findViewById(R.id.boton);
        button.setText("ENVIAR");
        button.setTypeface(custom_font);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // data.notifyDataSetChanged();
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.setText(editText.getText().toString());
                chatMessage.setSender(ChatInstance.myUser);
                chatMessage.setReceiver(ChatInstance.chatWith);
                chatPresenter.sendMessage(chatMessage);
                editText.setText(" ");
            }
        });
        list.setAdapter(data);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("back");
        Intent intent = new Intent(MainActivity.this, General.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }


}
