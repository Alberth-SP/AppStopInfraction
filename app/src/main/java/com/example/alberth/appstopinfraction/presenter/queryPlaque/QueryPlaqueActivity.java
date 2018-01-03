package com.example.alberth.appstopinfraction.presenter.queryPlaque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alberth.appstopinfraction.NavigationUtils;
import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.bases.BaseActivity;
import com.example.alberth.appstopinfraction.presenter.home.HomeActivity;

import butterknife.OnClick;

public class QueryPlaqueActivity extends BaseActivity {



    @OnClick(R.id.btn_back3)
    public void cancelClicked(){
        NavigationUtils.startActivity(this, HomeActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_query_plaque;
    }
}
