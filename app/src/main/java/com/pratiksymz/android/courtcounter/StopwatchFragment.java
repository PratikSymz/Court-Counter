package com.pratiksymz.android.courtcounter;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;

import java.util.Timer;
import java.util.TimerTask;

import at.grabner.circleprogress.CircleProgressView;
import at.grabner.circleprogress.TextMode;
import at.markushi.ui.CircleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment {

    private CircleButton mButtonStart, mButtonStop;
    private Chronometer mChronometer;
    private CircleProgressView mCircleProgressView;
    private Stopwatch mStopwatch;

    private long mTime = 0;

    public StopwatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stopwatch, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mButtonStart = (CircleButton) view.findViewById(R.id.button_start);
        mButtonStop = (CircleButton) view.findViewById(R.id.button_stop);
        mChronometer = (Chronometer) view.findViewById(R.id.stopwatch_chronometer);
        mCircleProgressView = (CircleProgressView) view.findViewById(R.id.circle_progress_view);

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStopwatch = new Stopwatch();
                mChronometer.setBase(SystemClock.elapsedRealtime() + mTime);
                mChronometer.start();
                mStopwatch.startCount();
            }
        });

        mCircleProgressView.setTextMode(TextMode.VALUE);

        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTime = mChronometer.getBase() - SystemClock.elapsedRealtime();
                mChronometer.stop();
                mStopwatch.stopCount();
            }
        });
    }

    public class Stopwatch {
        private Timer mTimer;
        private int progressValue = -1;

        private void startCount() {
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    progressValue++;
                    mCircleProgressView.setValue(progressValue);
                    if (progressValue == 59) {
                        progressValue = -1;
                    }
                }
            }, 0, 1000);        // 1 Second
        }

        private void stopCount() {
            mTimer.cancel();
        }
    }
}