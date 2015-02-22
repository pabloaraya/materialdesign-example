package com.pabloaraya.materialdesign;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gc.materialdesign.views.ButtonFlat;
import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.widgets.Dialog;
import com.gc.materialdesign.widgets.SnackBar;


public class MyActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private ButtonFlat buttonFlat;
    private ButtonRectangle buttonRectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        /* Set actionbar */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        buttonFlat = (ButtonFlat)findViewById(R.id.buttonflat);
        buttonRectangle = (ButtonRectangle)findViewById(R.id.button);

        buttonFlat.setOnClickListener(btnListener);
        buttonRectangle.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SnackBar snackbar = new SnackBar(MyActivity.this,
                    getString(R.string.title_dialog_action),
                    getString(R.string.button_widget),
                    btnYesListener);
            snackbar.show();
        }
    };

    View.OnClickListener btnYesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Dialog actionDialog =
                    new Dialog(MyActivity.this,
                            getString(R.string.title_dialog_action),
                            getString(R.string.dialog_content_action));
            actionDialog.show();
        }
    };
}
