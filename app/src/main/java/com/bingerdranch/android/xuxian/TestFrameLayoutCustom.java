package com.bingerdranch.android.xuxian;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ToggleButton;

/**
 * Created by BugHunter on 15/10/14.
 */
public class TestFrameLayoutCustom extends FrameLayout implements View.OnClickListener{

    private ToggleButton button01;
    private ToggleButton button02;
    private ToggleButton button03;
    private ToggleButton selectedToggleButton;

    public TestFrameLayoutCustom(Context context) {
        this(context,null);
    }

    public TestFrameLayoutCustom(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public TestFrameLayoutCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.my_custom_component_view, this);

        button01 = (ToggleButton)findViewById(R.id.button01);
        button02 = (ToggleButton)findViewById(R.id.button02);
        button03 = (ToggleButton)findViewById(R.id.button03);

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);

        TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.MyCustomComponent,defStyleAttr,0);

        final int N = a.getIndexCount();
        for (int i = 0;i < N;i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.MyCustomComponent_defaultButtonIndex:
                    int index = a.getInt(attr,0);
                    switch (index){
                        case 1:
                            selectedToggleButton = button02;
                            break;
                        case 2:
                            selectedToggleButton = button03;
                            break;
                        default:
                            selectedToggleButton = button01;
                            break;
                    }
                    selectedToggleButton.setChecked(true);
                    break;
            }
        }
        a.recycle();
    }

    @Override
    public void onClick(View v) {
        selectedToggleButton.setChecked(false);
        selectedToggleButton = (ToggleButton)v;
        selectedToggleButton.setChecked(true);
    }
}
