package com.pabloaraya.materialdesign;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;

/**
 * Created by pablo on 2/21/15.
 */
public class MyAdapterHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected TextView textView;
    protected RippleView rippleView;

    public MyAdapterHolder(View view) {
        super(view);
        this.imageView  = (ImageView)view.findViewById(R.id.imageView);
        this.textView   = (TextView)view.findViewById(R.id.textView);
        this.rippleView = (RippleView)view.findViewById(R.id.clickRippleView);
    }
}