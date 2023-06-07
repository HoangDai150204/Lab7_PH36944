package com.hoangdai.lab5_ph36944;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class SchoolSpinnerAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<School> list;

    public SchoolSpinnerAdapter(Context context, ArrayList<School> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {return list.size();}
    @Override
    public Object getItem(int i) {return list.get(i);}
    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroud){
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        view = inflater.inflate(R.layout.item_spinner, viewGroud, false);

        ImageView ivlogo = view.findViewById(R.id.imgicon);
        TextView txtName = view.findViewById(R.id.txttencoso);

        ivlogo.setImageResource(list.get(i).getImage());
        txtName.setText("FPoly "+ list.get(i).getName());

        return view;
    }
}
