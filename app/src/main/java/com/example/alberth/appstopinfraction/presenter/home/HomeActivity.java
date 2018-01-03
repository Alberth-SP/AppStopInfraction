package com.example.alberth.appstopinfraction.presenter.home;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alberth.appstopinfraction.NavigationUtils;
import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.bases.BaseActivity;
import com.example.alberth.appstopinfraction.presenter.listInfraction.ListInfractionActivity;
import com.example.alberth.appstopinfraction.presenter.typeInfractions.TypeInfractionsActivity;
import com.example.alberth.appstopinfraction.presenter.queryPlaque.QueryPlaqueActivity;
import com.example.alberth.appstopinfraction.presenter.register.RegisterActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @BindView(R.id.btn_registrar) Button btn_registrar;
    @BindView(R.id.btn_listar) Button btn_listar;
    @BindView(R.id.btn_consultar_infraccion) Button btn_consultar_infraccion;
    @BindView(R.id.btn_list_des_infraction) Button btn_list_des_infraction;

    public static String PACKAGE_NAME;
    public static Resources RESOURCES;

    HomeContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateTo() {

    }

    @OnClick({R.id.btn_registrar, R.id.btn_listar, R.id.btn_consultar_infraccion, R.id.btn_list_des_infraction})
    public void buttonClicked(View v){
        switch (v.getId()){

            case R.id.btn_registrar:
                NavigationUtils.startActivity(this, RegisterActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.btn_listar:
                NavigationUtils.startActivity(this,ListInfractionActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.btn_consultar_infraccion:
                NavigationUtils.startActivity(this,QueryPlaqueActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.btn_list_des_infraction:
                NavigationUtils.startActivity(this, TypeInfractionsActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        PACKAGE_NAME = this.getPackageName();
        RESOURCES = this.getResources();

    }
}
