package com.example.alberth.appstopinfraction.presenter.listInfraction;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alberth.appstopinfraction.NavigationUtils;
import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.bases.BaseActivity;
import com.example.alberth.appstopinfraction.data.model.Papeleta;
import com.example.alberth.appstopinfraction.presenter.editInfraction.EditActivity;
import com.example.alberth.appstopinfraction.presenter.home.HomeActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ListInfractionActivity extends BaseActivity implements ListInfractionContract.View{


    @BindView(R.id.lv_listaRegistros)  ListView lv_listaRegistros;
    MyAdapterPapeleta myCustomAdapter = null;

    ListInfractionContract.Presenter presenter;
    ListInfractionPresenter listInfractionPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list_infraction;
    }

    @Override
    public void setPresenter(ListInfractionContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @OnClick(R.id.btn_back2)
    public void btnBack(){
        NavigationUtils.startActivity(this,
                HomeActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }

    @Override
    public void showListView(ArrayList<Papeleta> list) {
        myCustomAdapter = new MyAdapterPapeleta(this, R.layout.item_of_list, list);
        lv_listaRegistros.setAdapter(myCustomAdapter);

        lv_listaRegistros.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView v = (TextView) view.findViewById(R.id.itxt_idPapeleta);
                navigateTo(v.getText().toString());

            }
        });
    }

    @Override
    public void navigateTo(String papeleta) {
        NavigationUtils.startActivity(this,
                EditActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP,
                papeleta);
        finish();

    }

    @Override
    protected void onResume() {
        super.onResume();
        listInfractionPresenter = new ListInfractionPresenter(this, this);
        presenter.start();
        listInfractionPresenter.getAllPapeletas();
    }
}
