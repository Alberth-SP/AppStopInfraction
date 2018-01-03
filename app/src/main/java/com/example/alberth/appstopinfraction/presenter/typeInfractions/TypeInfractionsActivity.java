package com.example.alberth.appstopinfraction.presenter.typeInfractions;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alberth.appstopinfraction.NavigationUtils;
import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.bases.BaseActivity;
import com.example.alberth.appstopinfraction.data.model.TypeInfraction;
import com.example.alberth.appstopinfraction.presenter.home.HomeActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TypeInfractionsActivity extends BaseActivity implements TypeInfractionsContract.View{

    TypeInfractionsContract.Presenter presenter;
    TypeInfractionsPresenter listInfractionPresenter;

    @BindView(R.id.lv_typesInfractions) ListView lv_typesInfractions;
    @BindView(R.id.fiterData)  EditText fiterData;
    AdapterTypeInfraction myCustomAdapter = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_type_infractions;
    }

    @Override
    public void setPresenter(TypeInfractionsContract.Presenter presenter) {
        this.presenter = presenter;

    }


    @OnClick(R.id.btn_back)
    public void btnBack(){
        navigateTo();
    }

    @Override
    public void showListTypesInfractions(List<TypeInfraction> list){
        myCustomAdapter = new AdapterTypeInfraction(this,  list);

        lv_typesInfractions.setAdapter(myCustomAdapter);

        fiterData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myCustomAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void navigateTo() {
        NavigationUtils.startActivity(this, HomeActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

    }

    @Override
    protected void onResume() {
        super.onResume();
        listInfractionPresenter = new TypeInfractionsPresenter(this, this);
        presenter.start();
        presenter.getAllTypesInfractions();
    }
}
