package com.example.arqdsis.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.arqdsis.activitylifecycle.util.StatusTracker;
import com.example.arqdsis.activitylifecycle.util.Utils;

public class ActivityB extends Activity {

    private String mActivityName;
    private TextView mStatusView;
    private TextView mStatusAllView;
    private StatusTracker mStatusTracker = StatusTracker.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mActivityName = getString(R.string.activity_a);
        mStatusView = (TextView)findViewById(R.id.status_view_a);
        mStatusAllView = (TextView)findViewById(R.id.status_view_all_a);
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create));
        Utils.printStatus(mStatusView, mStatusAllView);
    }
    @Override
    protected void onStart() {
        super.onStart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_start));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy));
        mStatusTracker.clear();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityB.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityA(View v) {
        Intent intent = new Intent(ActivityB.this, ActivityA.class);
        startActivity(intent);
    }

    public void startActivityC(View v) {
        Intent intent = new Intent(ActivityB.this, ActivityC.class);
        startActivity(intent);
    }

    public void finishActivityB(View v) {
        ActivityB.this.finish();
    }

}

