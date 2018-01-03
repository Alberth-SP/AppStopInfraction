package com.example.alberth.appstopinfraction.presenter.typeInfractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.data.model.TypeInfraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alberth on 01/01/2018.
 */

public class AdapterTypeInfraction extends BaseAdapter implements Filterable {

    Context context;
    List<TypeInfraction> listPapeletas;
    CustomFilter filter;
    List<TypeInfraction> filterList;
    public AdapterTypeInfraction(Context context, List<TypeInfraction> listPapeletas) {

        this.context=context;
        this.listPapeletas=listPapeletas;
        this.filterList=listPapeletas;
    }

    @Override
    public int getCount() {

        return listPapeletas.size();
    }
    @Override
    public Object getItem(int pos) {

        return listPapeletas.get(pos);
    }
    @Override
    public long getItemId(int pos) {

        return listPapeletas.indexOf(getItem(pos));
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_of_type_infractions, parent, false);

        TextView txt_tituloPapeletaType = (TextView) rowView.findViewById(R.id.txt_tituloPapeletaType);
        TextView txt_detallePapeletaType = (TextView) rowView.findViewById(R.id.txt_detallePapeletaType);
        TextView txt_montoPapeleta = (TextView) rowView.findViewById(R.id.txt_montoPapeleta);

        txt_tituloPapeletaType.setText(listPapeletas.get(position).getCodigo());
        txt_detallePapeletaType.setText(listPapeletas.get(position).getDetalle());
        txt_montoPapeleta.setText("Monto: S/. "+listPapeletas.get(position).getMonto());

        return rowView;
    }
    @Override
    public Filter getFilter() {
        if(filter == null)
        {
            filter=new CustomFilter();
        }
        return filter;
    }







    class CustomFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results=new FilterResults();
            if(constraint != null && constraint.length()>0)
            {
                //CONSTARINT TO UPPER
                constraint=constraint.toString().toUpperCase();
                ArrayList<TypeInfraction> filters=new ArrayList<TypeInfraction>();
                //get specific items
                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getCodigo().toUpperCase().contains(constraint))
                    {
                        TypeInfraction p=new TypeInfraction(filterList.get(i).getCodigo(), filterList.get(i).getDetalle(), filterList.get(i).getMonto());
                        filters.add(p);
                    }
                }
                results.count=filters.size();
                results.values=filters;
            }else
            {
                results.count=filterList.size();
                results.values=filterList;
            }
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            listPapeletas=(ArrayList<TypeInfraction>) results.values;
            notifyDataSetChanged();
        }
    }
}
