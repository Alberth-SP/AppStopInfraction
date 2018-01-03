package com.example.alberth.appstopinfraction.presenter.editInfraction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.alberth.appstopinfraction.NavigationUtils;
import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.bases.BaseActivity;
import com.example.alberth.appstopinfraction.data.model.Papeleta;
import com.example.alberth.appstopinfraction.presenter.home.HomeActivity;
import com.example.alberth.appstopinfraction.presenter.listInfraction.ListInfractionActivity;
import com.example.alberth.appstopinfraction.presenter.listInfraction.ListInfractionContract;

import butterknife.BindView;
import butterknife.OnClick;

public class EditActivity extends BaseActivity implements EditContract.View {

    @BindView(R.id.edit_fname)   EditText edit_fname;
    @BindView(R.id.edit_lname)   EditText edit_lname;
    @BindView(R.id.edit_name_infraction)   EditText edit_name_infraction;
    @BindView(R.id.edit_matricula)    EditText edit_matricula;
    @BindView(R.id.edit_type_vehicle)    EditText edit_type_vehicle;
    @BindView(R.id.edit_monto)    EditText edit_monto;
    @BindView(R.id.edit_color_vehicle)    EditText edit_color_vehicle;
    @BindView(R.id.edit_place)    EditText edit_place;

    EditContract.Presenter mPresenter;
    EditPresenter editPresenter;
    int idPapeleta;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit;
    }

    @OnClick(R.id.btn_change)
    public void submitClicked(){
        mPresenter.validateRegisterToEdit(idPapeleta, new EditText[]{edit_fname, edit_lname,
                edit_name_infraction, edit_matricula, edit_type_vehicle, edit_color_vehicle, edit_monto, edit_place});

    }

    @OnClick(R.id.btn_cancelEdit)
    public void cancelEditClicked(){
        NavigationUtils.startActivity(this, HomeActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

    }

    @Override
    public void setPresenter(EditContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showSuccessfulToEdit(String message) {
        showMessageToast(message);
        navigateTo();
    }

    @Override
    public void showErrorToEdit(String message) {
        showMessageToast(message);
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }

    @Override
    public void navigateTo() {
        NavigationUtils.startActivity(this, ListInfractionActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

    }

    public void showPapeletaDetail(Papeleta papeleta){
        edit_fname.setText(papeleta.getFname_conductor());
        edit_lname.setText(papeleta.getLname_conductor());
        edit_name_infraction.setText(papeleta.getName_infraction());
        edit_matricula.setText(papeleta.getMatricula());
        edit_type_vehicle.setText(papeleta.getType_vehicle());
        edit_monto.setText(papeleta.getMonto().toString());
        edit_color_vehicle.setText(papeleta.getColor_vehicle());
        edit_place.setText(papeleta.getPlace());
    }

    @Override
    protected void onResume() {
        super.onResume();
        idPapeleta = Integer.parseInt(getIntent().getStringExtra("detailWrapper"));
        System.out.println("VALUE PAS: "+idPapeleta);
        editPresenter = new EditPresenter(this, this);
        mPresenter.start();

        showPapeletaDetail(editPresenter.getItemById(idPapeleta));
    }
}
