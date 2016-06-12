package com.legendmohe.rippledrawable;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private View mRippleContent;
    private Button mStartButton;
    private Button mStopButton;
    private RippleDrawable mRippleDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartButton = (Button) findViewById(R.id.start_button);
        mStopButton = (Button) findViewById(R.id.stop_button);
        mRippleContent = findViewById(R.id.ripple_content);


        mRippleContent.post(new Runnable() {
            @Override
            public void run() {
                int radius = mRippleContent.getWidth()/2;
                mRippleDrawable = new RippleDrawable(radius + 300, 0, 5, 2000, false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mRippleContent.setBackground(mRippleDrawable);
                } else {
                    mRippleContent.setBackgroundDrawable(mRippleDrawable);
                }
            }
        });

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRippleDrawable.startAnimation();
            }
        });
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRippleDrawable.stopAnimation();
            }
        });
    }
}
