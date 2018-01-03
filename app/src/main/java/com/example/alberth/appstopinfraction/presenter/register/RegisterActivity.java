package com.example.alberth.appstopinfraction.presenter.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alberth.appstopinfraction.NavigationUtils;
import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.bases.BaseActivity;
import com.example.alberth.appstopinfraction.presenter.home.HomeActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
;
public class RegisterActivity extends BaseActivity implements RegisterContract.View{


    @BindView(R.id.reg_fname)    EditText reg_fname;
    @BindView(R.id.reg_lname)    EditText reg_lname;
    @BindView(R.id.reg_name_infraction)  EditText reg_name_infraction;
    @BindView(R.id.reg_matricula)    EditText reg_matricula;
    @BindView(R.id.reg_type_vehicle)    EditText reg_type_vehicle;
    @BindView(R.id.reg_color_vehicle)    EditText reg_color_vehicle;
    @BindView(R.id.reg_monto)    EditText reg_monto;
    @BindView(R.id.reg_place)    EditText reg_place;

    RegisterContract.Presenter mPresenter;
    RegisterPresenter registerPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @OnClick(R.id.btn_submit)
    public void submitClicked(){
        mPresenter.validateRegisterFields(new EditText[]{reg_fname, reg_lname,
                reg_name_infraction, reg_matricula, reg_type_vehicle, reg_color_vehicle, reg_monto, reg_place });

    }

    @OnClick(R.id.btn_cancel)
    public void cancelClicked(){
        navigateTo();
    }


    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        assert(presenter!=null);
        this.mPresenter = presenter;
    }

    @Override
    public void showSuccessfulRegister(String message) {
        showMessageToast(message);
        navigateTo();
    }

    @Override
    public void showErrorRegister(String message) {
        showMessageToast(message);
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }


    @Override
    public void navigateTo() {
        NavigationUtils.startActivity(this, HomeActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerPresenter = new RegisterPresenter(this, this);
        mPresenter.start();
    }
}
