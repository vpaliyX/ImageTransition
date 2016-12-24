package com.example.vasya.phototransition;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DynamicImage extends ImageView {

    private float heightRation=1.f;

    public DynamicImage(Context context) {
        super(context);
    }

    public DynamicImage(Context context, @NonNull AttributeSet attrs) {
        super(context,attrs);
    }

    public void setHeightRation(float heightRation) {
        this.heightRation = heightRation;
    }

    public float getHeightRation() {
        return heightRation;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (heightMeasureSpec > 0.0 && heightRation>0.0f) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = (int) (width * heightRation);
            setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
