package com.geovanni.starwars.app.Views.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geovanni.starwars.app.R;

import butterknife.ButterKnife;

/**
 * Created by gabri on 17/07/2017.
 */

public class ProgressLayout extends LinearLayout {

    private TextView txtMessage;

    public ProgressLayout(Context context) {
        super(context);
        init();
    }

    public ProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.progress_layout, this, true);
        txtMessage = ButterKnife.findById(this, R.id.txtMessage);
    }

    public void setTextMessage(String message) {
        txtMessage.setText(message);
    }

}
