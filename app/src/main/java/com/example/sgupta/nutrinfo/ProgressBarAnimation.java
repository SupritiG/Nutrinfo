package com.example.sgupta.nutrinfo;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

/**
 * Created by engsg on 4/26/2016.
 * Class to animate the progress bar displaying the percentage daily values of nutrients
 */
public class ProgressBarAnimation extends Animation {

    private ProgressBar mprogressBar;
    private float mstartVal;
    private float mfinalVal;

    public ProgressBarAnimation(ProgressBar progressBar, float from, float to) {
        super();
        mprogressBar = progressBar;
        mstartVal = from;
        mfinalVal = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = mstartVal + (mfinalVal - mstartVal) * interpolatedTime;
        mprogressBar.setProgress((int) value);
    }

}
