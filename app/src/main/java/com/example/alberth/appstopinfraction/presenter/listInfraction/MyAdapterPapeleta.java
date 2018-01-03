package com.example.alberth.appstopinfraction.presenter.listInfraction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.data.model.Papeleta;

import java.util.ArrayList;

/**
 * Created by alberth on 30/12/2017.
 */

public class MyAdapterPapeleta extends ArrayAdapter<Papeleta> {

    private  Context context;
    private  ArrayList<Papeleta> listPapeletas = new ArrayList<>();

    public MyAdapterPapeleta(Context context, int txtViewRecursedID, ArrayList<Papeleta> objects) {
        super(context, txtViewRecursedID, objects);
        this.context = context;
        this.listPapeletas = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_of_list, parent, false);

        TextView itxt_idPapeleta = (TextView) rowView.findViewById(R.id.itxt_idPapeleta);
        TextView itxt_fullname = (TextView) rowView.findViewById(R.id.itxt_fullname);
        TextView itxt_matricula = (TextView) rowView.findViewById(R.id.itxt_matricula);
        TextView itxt_date = (TextView) rowView.findViewById(R.id.itxt_date);

        itxt_idPapeleta.setText(listPapeletas.get(position).getIdPapeleta().toString());
        itxt_fullname.setText(listPapeletas.get(position).getFname_conductor() + " "+listPapeletas.get(position).getLname_conductor());
        itxt_matricula.setText(listPapeletas.get(position).getMatricula());
        itxt_date.setText(listPapeletas.get(position).getDate());
        return rowView;
    }

    @Override
    public int getCount(){
        return super.getCount();
    }


}
