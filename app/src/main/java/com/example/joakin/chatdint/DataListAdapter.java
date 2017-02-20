package com.example.joakin.chatdint;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joakin on 18/01/2017.
 */

public class DataListAdapter extends BaseAdapter {
    Context context;


    ArrayList<String> User;
    ArrayList<String> imge;
    ArrayList<String> message;
    EditText editText ;
    Button button;
    DataListAdapter() {
        this.context = context;
        User = null;
        imge = null;
        message = null;

    }

    public DataListAdapter(ArrayList<String> text, ArrayList<String> text3, ArrayList<String> messages, Context context) {
        User = text;
        imge = text3;
        message = messages;
        this.context = context;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return User.size();
    }

    public String getItem(int arg0) {
        // TODO Auto-generated method stub
        return User.get(arg0);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = null;
        System.out.println("userrrr" + Dataholder.instance.User);
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/Quicksand-Bold.otf");

        if (Dataholder.instance.User == "user1") {
            row = inflater.inflate(R.layout.celdaderecha, parent, false);
            TextView title;
            ImageView i1;
            TextView mess;
            title = (TextView) row.findViewById(R.id.title);
            i1 = (ImageView) row.findViewById(R.id.img);
            mess = (TextView) row.findViewById(R.id.message);
            title.setText(Dataholder.instance.User);
            mess.setText(message.get(position));
            title.setTypeface(custom_font);
            mess.setTypeface(custom_font);
        } else{
            row = inflater.inflate(R.layout.celdaizq, parent, false);

            TextView title;
            ImageView i1;
            TextView mess;
            title = (TextView) row.findViewById(R.id.title);
            i1 = (ImageView) row.findViewById(R.id.img);
            mess = (TextView) row.findViewById(R.id.message);
            title.setText(Dataholder.instance.User);
            mess.setText(message.get(position));
            title.setTypeface(custom_font);
            mess.setTypeface(custom_font);

        }


        return (row);
    }
}