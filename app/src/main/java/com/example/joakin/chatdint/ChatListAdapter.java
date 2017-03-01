package com.example.joakin.chatdint;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.utad.chatsdk.data.ChatUser;

import java.util.ArrayList;

/**
 * Created by Joakin on 25/01/2017.
 */

public class ChatListAdapter extends ArrayAdapter {

    ArrayList<ChatUser> usuarios;
    Context context;

    public ChatListAdapter(ArrayList<ChatUser> usuarios, Context context) {
        super(context, 0);
        this.usuarios = usuarios;
        this.context = context;
    }


    @Override
    public int getCount() {
        return usuarios.size();
    }

    public String getItem(int arg0) {
        // TODO Auto-generated method stub
        return usuarios.get(arg0).getName();
    }

    public void setUsuarios(ArrayList<ChatUser> usuarios) {

        this.usuarios = usuarios;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = null;
        row = inflater.inflate(R.layout.celdachats, viewGroup, false);
        TextView title;
        ImageView i1;
        title = (TextView) row.findViewById(R.id.contact);
        i1 = (ImageView) row.findViewById(R.id.imgchat);
        title.setText(usuarios.get(i).getName());
        i1.setImageResource(R.drawable.userxxxhdpi);
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/Quicksand-Bold.otf");
        title.setTypeface(custom_font);
        return row;
    }
}