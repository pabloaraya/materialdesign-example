package com.pabloaraya.materialdesign;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFloat;
import com.gc.materialdesign.widgets.Dialog;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter activityAdapter;
    private ButtonFloat buttonAction;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ItemModel> items = new ArrayList<>();
        items.add(new ItemModel(R.drawable.image_girl, getString(R.string.content_girl)));
        items.add(new ItemModel(R.drawable.image_paris, getString(R.string.content_paris)));
        items.add(new ItemModel(R.drawable.image_water, getString(R.string.content_water)));
        items.add(new ItemModel(R.drawable.image_duck, getString(R.string.content_duck)));
        items.add(new ItemModel(R.drawable.image_fish, getString(R.string.content_fish)));
        items.add(new ItemModel(R.drawable.image_globos, getString(R.string.content_globos)));
        items.add(new ItemModel(R.drawable.image_lake, getString(R.string.content_lake)));

        /* Set actionbar */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        /* Initialize recycler view */
        mRecyclerView = (RecyclerView)findViewById(R.id.listItems);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        /* Set adapter */
        activityAdapter = new MyAdapter(this, items);
        activityAdapter.setOnTapListener(new OnTapListener() {
            @Override
            public void onTapView(int position) {
                Intent intent = new Intent(MainActivity.this, MyActivity.class);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(activityAdapter);

        /* Set action button */
        buttonAction = (ButtonFloat)findViewById(R.id.buttonAction);
        buttonAction.setBackgroundColor(getResources().getColor(R.color.material_purple));
        buttonAction.setDrawableIcon(getResources().getDrawable(R.drawable.ic_action_plus));
        buttonAction.setRippleSpeed(10);

        /* Listener Button Action */
        buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog actionDialog =
                        new Dialog(MainActivity.this,
                                getString(R.string.title_dialog_action),
                                getString(R.string.dialog_content_action));
                actionDialog.show();
            }
        });
    }
}
