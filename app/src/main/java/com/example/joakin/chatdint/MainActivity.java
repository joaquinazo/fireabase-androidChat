package com.example.joakin.chatdint;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.utad.chatsdk.presenter.ChatPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> User;
    public ArrayList<String> imge;
    public ArrayList<String> message;
    EditText editText;
    Button button;
    ChatPresenter chatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.otf");
        chatPresenter = new ChatPresenter(getApplicationContext());
        chatPresenter.attach(new ChatPresenter.ChatPresenterListener() {
            @Override
            public void onSendSuccess(String s) {
                System.out.println(s);
            }

            @Override
            public void onReceive(String s, String s1) {

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
        final DataListAdapter data = new DataListAdapter(User, imge, message, this.getBaseContext());
        editText = (EditText) findViewById(R.id.text);
        editText.setTypeface(custom_font);
        button = (Button) findViewById(R.id.boton);
        button.setText("ENVIAR");
        button.setTypeface(custom_font);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.add(Dataholder.instance.User);
                message.add(editText.getText().toString());
                imge.add("URL2");
                data.notifyDataSetChanged();
                chatPresenter.sendMessage(message.toString());
            }
        });
        list.setAdapter(data);

    }
}
