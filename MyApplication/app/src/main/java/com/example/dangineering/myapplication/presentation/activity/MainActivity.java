package com.example.dangineering.myapplication.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dangineering.myapplication.R;
import com.example.dangineering.myapplication.presentation.adapter.ModelAdapter;
import com.example.dangineering.myapplication.presentation.presenter.GettyPresenter;
import com.example.dangineering.myapplication.presentation.presenter.impl.GettyPresenterImpl;
import com.example.dangineering.myapplication.presentation.viewmodel.ImageViewModel;
import com.example.dangineering.myapplication.presentation.viewmodel.SampleViewModel;
import com.example.dangineering.myapplication.presentation.views.ModelListView;


import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ModelListView {

    GettyPresenter gettyPresenter;

    RecyclerView recyclerView;
    ModelAdapter modelAdapter;
    EditText searchBox;
    Button searchBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initModelListAdapter();

        initPresenter();

        initSearchBox();

    }

    private void initPresenter() {
        gettyPresenter = new GettyPresenterImpl();
        gettyPresenter.initialize();
        gettyPresenter.setView(this);
    }

    private void initModelListAdapter() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        modelAdapter = new ModelAdapter();

        // use good old linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(modelAdapter);

        // no need for default animator
    }

    private void initSearchBox() {
        searchBox = (EditText) findViewById(R.id.search_text);
        searchBtn = (Button) findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettyPresenter.onSearch(searchBox.getText().toString());
            }
        });
    }


    @Override
    public void add(ImageViewModel sampleViewModel) {

    }

    @Override
    public void add(List<ImageViewModel> sampleViewModelList) {
        modelAdapter.setData(sampleViewModelList);
    }

    @Override
    public void remove(ImageViewModel sampleViewModel) {

    }
}
