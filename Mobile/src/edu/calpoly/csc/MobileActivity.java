package edu.calpoly.csc;

import com.actionbarsherlock.app.SherlockActivity;

import android.os.Bundle;

public class MobileActivity extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}