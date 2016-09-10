package com.kunalmadan.android.comiclover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.kunalmadan.android.comiclover.asyncTask.FetchComicData;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

public class HeroComicDetail extends AppCompatActivity {

    public ArrayList<Comic> newlist = new ArrayList<Comic>(); ;
    RecyclerView recyclerView =null;

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(HeroComicDetail.this);
        super.onStop();
    }
    public void onEvent(DataEvent event){
        // your implementation

        newlist = event.getmList();
        Log.v("oneventlist","oneventlist"+newlist);
        recyclerView.setAdapter(new ComicsAdapter(getApplicationContext(),newlist));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(HeroComicDetail.this);
        setContentView(R.layout.activity_hero_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String id = intent.getStringExtra("HERO_ID");

        Log.v("heroidis","heroidis"+id);


        FetchComicData fetchComicData = new FetchComicData(this);

        fetchComicData.execute(id);


       recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
       // EventBus.getDefault().register(HeroComicDetail.this);



        Log.v("newlist","newlist"+newlist);



        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
