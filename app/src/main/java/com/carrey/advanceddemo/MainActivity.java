package com.carrey.advanceddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.carrey.advanceddemo.dragview.DragGridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DragGridView mDragGridView;
    private ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDragGridView = (DragGridView) findViewById(R.id.dgv);
        for (int i = 0; i < 10; i++) {
            names.add("标题" + i);
        }
        mDragGridView.setAdapter(new MyDragGridAdapter(this,names));

//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

    }
}
