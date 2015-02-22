package com.pabloaraya.materialdesign;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by pablo on 2/21/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapterHolder> {

    private Context context;
    private List<ItemModel> items;
    private OnTapListener onTapListener;

    /* Typeface */
    private Typeface robotoLight;

    public MyAdapter(Context context, List<ItemModel> items) {
        this.context    = context;
        this.items      = items;
        robotoLight     = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
    }

    @Override
    public MyAdapterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);
        MyAdapterHolder mh = new MyAdapterHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(MyAdapterHolder myAdapterHolder, final int i) {

        /* Activity model */
        ItemModel item = items.get(i);

        /* Set elements */
        myAdapterHolder.textView.setText(item.getText());
        myAdapterHolder.imageView.setImageResource(item.getImage());

        /* Set typeface */
        myAdapterHolder.textView.setTypeface(robotoLight);

        /* Listener */
        myAdapterHolder.rippleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            onTapListener.onTapView(i);
                        }
                    }, 500);
                }
            }

            ;
        });
    };

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnTapListener(OnTapListener onTapListener){
        this.onTapListener = onTapListener;
    }
}