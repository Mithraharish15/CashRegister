package com.example.cashregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListDataAdapter extends BaseAdapter {
    ArrayList<Product> list;
    Context context;

    //input(list of products, the view (i.e. MainActivity.this) )
    public ListDataAdapter(ArrayList<Product> list, Context context){
        this.list = list;
        this.context = context; //not a syntax error
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //access LayoutInflater and access to context
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //convert the layout into view object 'view'
        //select layout view, viewGroup, false (garbage collector)
         view = inflater.inflate(R.layout.list_row, null, false);

        TextView productType = view.findViewById(R.id.list_type);
        TextView productPrice = view.findViewById(R.id.list_price);
        TextView productQty = view.findViewById(R.id.list_quantity);

        productType.setText(list.get(i).type);
        productPrice.setText(String.valueOf(list.get(i).price));
        productQty.setText(String.valueOf(list.get(i).quantity));
        return view;
    }
}
