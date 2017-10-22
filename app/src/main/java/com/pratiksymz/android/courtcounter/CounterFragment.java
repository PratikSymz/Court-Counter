package com.pratiksymz.android.courtcounter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CounterFragment extends Fragment {

    private int scoreTeamA = 0; // Tracks Score For Team A
    private int foulTeamA = 0; // Tracks Foul For Team A

    private int scoreTeamB = 0; // Tracks Score For Team B
    private int foulTeamB = 0; // Tracks Foul For Team B

    private TextView mTeamAScoreView, mTeamAFoulView;
    private TextView mTeamBScoreView, mTeamBFoulView;

    private Button mAdd3ForA, mAdd2ForA, mAddFreeForA, mFoulForA;
    private Button mAdd3ForB, mAdd2ForB, mAddFreeForB, mFoulForB;
    private Button mResetButton;

    public CounterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTeamAScoreView = (TextView) view.findViewById(R.id.team_A_Score);
        mTeamAFoulView = (TextView) view.findViewById(R.id.team_A_Foul);

        mTeamBScoreView = (TextView) view.findViewById(R.id.team_B_Score);
        mTeamBFoulView = (TextView) view.findViewById(R.id.team_B_Foul);

        mAdd3ForA = (Button) view.findViewById(R.id.button_add_3_for_A);
        mAdd2ForA = (Button) view.findViewById(R.id.button_add_2_for_A);
        mAddFreeForA = (Button) view.findViewById(R.id.button_add_free_for_A);
        mFoulForA = (Button) view.findViewById(R.id.button_foul_for_A);

        mAdd3ForA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add3ForA();
            }
        });
        mAdd2ForA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add2ForA();
            }
        });
        mAddFreeForA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFreeForA();
            }
        });
        mFoulForA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFoulForA();
            }
        });

        mAdd3ForB = (Button) view.findViewById(R.id.button_add_3_for_B);
        mAdd2ForB = (Button) view.findViewById(R.id.button_add_2_for_B);
        mAddFreeForB = (Button) view.findViewById(R.id.button_add_free_for_B);
        mFoulForB = (Button) view.findViewById(R.id.button_foul_for_B);

        mAdd3ForB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add3ForB();
            }
        });
        mAdd2ForB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add2ForB();
            }
        });
        mAddFreeForB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFreeForB();
            }
        });
        mFoulForB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFoulForB();
            }
        });

        mResetButton = (Button) view.findViewById(R.id.button_reset_score);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetScore();
            }
        });
    }

    /**
     * Increase in Score for Team A
     */
    /* This method is called when the 3 Pointer Button is clicked */
    public void add3ForA() {
        scoreTeamA += 3;
        displayScoreForTeamA(scoreTeamA);
    }

    /* This method is called when the 2 Pointer Button is clicked */
    public void add2ForA() {
        scoreTeamA += 2;
        displayScoreForTeamA(scoreTeamA);
    }

    /* This method is called when the Free Throw Button is clicked */
    public void addFreeForA() {
        scoreTeamA += 1;
        displayScoreForTeamA(scoreTeamA);
    }

    /* This method is called when the Foul Button is clicked */
    public void addFoulForA() {
        foulTeamA += 1;
        displayFoulForTeamA(foulTeamA);
    }

    /**
     * This method displays the Score For Team A.
     * @param score is the score of team A.
     */
    private void displayScoreForTeamA(int score) {
        mTeamAScoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays the number of fouls of Team A.
     * @param foul is the number of fouls of team A.
     */
    private void displayFoulForTeamA(int foul) {
        mTeamAFoulView.setText(String.valueOf(foul));
    }


    /**
     * Increase in Score for Team B
     */
    /* This method is called when the 3 Pointer Button is clicked */
    public void add3ForB() {
        scoreTeamB += 3;
        displayScoreForTeamB(scoreTeamB);
    }

    /* This method is called when the 2 Pointer Button is clicked */
    public void add2ForB() {
        scoreTeamB += 2;
        displayScoreForTeamB(scoreTeamB);
    }

    /* This method is called when the Free Throw Button is clicked */
    public void addFreeForB() {
        scoreTeamB += 1;
        displayScoreForTeamB(scoreTeamB);
    }

    /* This method is called when the Foul Button is clicked */
    public void addFoulForB() {
        foulTeamB += 1;
        displayFoulForTeamB(foulTeamB);
    }

    /**
     * This method displays the Score For Team B.
     * @param score is the score of team B.
     */
    private void displayScoreForTeamB(int score) {
        mTeamBScoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays the number of fouls of Team B.
     * @param foul is the number of fouls of team B.
     */
    private void displayFoulForTeamB(int foul) {
        mTeamBFoulView.setText(String.valueOf(foul));
    }


    /**
     * This method is called when the RESET Button is clicked.
     */
    public void resetScore() {
        scoreTeamA = 0;
        foulTeamA = 0;
        displayScoreForTeamA(0);
        displayFoulForTeamA(0);

        scoreTeamB = 0;
        foulTeamB = 0;
        displayScoreForTeamB(0);
        displayFoulForTeamB(0);
    }
}
