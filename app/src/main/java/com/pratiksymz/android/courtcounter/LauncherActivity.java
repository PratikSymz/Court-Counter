package com.pratiksymz.android.courtcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LauncherActivity extends AppCompatActivity {

    private EditText mNameTeamA, mNameTeamB;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        mNameTeamA = (EditText) findViewById(R.id.input_team_A);
        mNameTeamB = (EditText) findViewById(R.id.input_team_B);

        mSubmitButton = (Button) findViewById(R.id.button_submit_team_names);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LauncherActivity.this, MainFragmentActivity.class);
                intent.putExtra("nameTeamA", mNameTeamA.getText().toString().trim());
                intent.putExtra("nameTeamB", mNameTeamB.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}
