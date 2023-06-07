package com.hoangdai.lab5_ph36944;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StudentListViewAdapter extends BaseAdapter implements Filterable {
    private final Context context;
    private List<Student> list;
    private final List<Student> listOld;

    public StudentListViewAdapter(Context context, ArrayList<Student> list){
        this.context = context;
        this.list = list;
        this.listOld = list;
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
        view = inflater.inflate(R.layout.item_listview, viewGroud, false);

        TextView txt_coso = view.findViewById(R.id.txtcoso);
        TextView txt_name = view.findViewById(R.id.txtname);
        TextView txt_address = view.findViewById(R.id.txtaddress);
        Button btndelete=view.findViewById(R.id.btndelete);
        Button btnupdate=view.findViewById(R.id.btnupdate);


        txt_coso.setText("FPoly "+ list.get(i).getBranch());
        txt_name.setText("Họ tên: "+ list.get(i).getName());
        txt_address.setText("Địa chỉ: "+ list.get(i).getAddress());

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;

    }
    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String s = charSequence.toString();
                if (s.isEmpty()){
                    list = listOld;
                } else {
                    List<Student> listS = new ArrayList<>();
                    for(Student st:listOld){
                        if (st.getName().toLowerCase().contains(s.toLowerCase())){
                            listS.add(st);
                        }
                    }
                    list = listS;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values=list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                list = (List<Student>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
