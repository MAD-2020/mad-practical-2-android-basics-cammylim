package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private TextView Score;
    private static int count = 0;
    private static final String TAG = "Whack-A-Mole";

    public void Randomizer() {
        Button[] buttons = {ButtonLeft, ButtonMiddle, ButtonRight};
        Random random = new Random();
        int select = random.nextInt(3);
        Button m = buttons[select];
        for (Button b : buttons) {
            if (b == m) {
                b.setText("*");
            } else {
                b.setText("O");
            }
        }
    }

    public void UpdateScore() {
        Score.setText(String.valueOf(count));
    }

    public boolean Check(Button b) {
        if (b.getText() == "*") {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonRight = (Button) findViewById(R.id.ButtonRight);
        Score = (TextView) findViewById(R.id.Score);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Application launched!");
        Randomizer();
        UpdateScore();
    }

    public void OnClickButton(View v) {
        switch(v.getId()){
            case R.id.ButtonLeft:
                Log.v(TAG,"Left Button Clicked!");
                break;

            case R.id.ButtonMiddle:
                Log.v(TAG,"Middle Button Clicked!");
                break;

            default:
                Log.v(TAG,"Right Button Clicked!");
        }
        Button button = (Button) v;
        if (Check(button) == true) {
            count++;
            Log.v(TAG, "Hit, score added!");
        }
        else if(count != 0){
            count--;
            Log.v(TAG, "Missed, score deducted!");
        }
        else{
            Log.v(TAG, "Missed, score deducted!");
        }
        UpdateScore();
        Randomizer();
    }
}
