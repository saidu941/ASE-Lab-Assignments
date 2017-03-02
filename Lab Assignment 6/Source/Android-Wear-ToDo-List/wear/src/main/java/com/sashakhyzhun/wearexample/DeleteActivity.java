package com.sashakhyzhun.wearexample;

/**
 * Created by Ramgopal on 2/5/2017.
 */

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;

public class DeleteActivity extends WearableActivity implements DelayedConfirmationView.DelayedConfirmationListener {

    DelayedConfirmationView delayedConfirmationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delayedConfirmationView = (DelayedConfirmationView)findViewById(R.id.delayed_confirm);

        delayedConfirmationView.setListener(this);
        delayedConfirmationView.setTotalTimeMs(2000);
        delayedConfirmationView.start();

    }

    @Override
    public void onTimerFinished(View view) {
        NoteHelper.displayConfirmation("Deleted", this);

        String id = getIntent().getStringExtra("id");
        NoteHelper.removeNote(id, this);

        finish();
    }

    @Override
    public void onTimerSelected(View view) {
        NoteHelper.displayConfirmation("Canceled", this);
        delayedConfirmationView.reset();
        finish();
    }
}
