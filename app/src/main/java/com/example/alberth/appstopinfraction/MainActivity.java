package com.example.alberth.appstopinfraction;

import android.view.View;
import android.widget.TextView;

import com.example.alberth.appstopinfraction.bases.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text2)    TextView text;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }




}

