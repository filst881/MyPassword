package com.example.fille.mypassword;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText password;
    private TextView strengthText;
    private ProgressBar strengthBar;
    private Checker checker = new StrengthChecker();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = (EditText) (findViewById(R.id.passwordText));
        strengthText = (TextView) (findViewById(R.id.strengthText));
        strengthBar = (ProgressBar) (findViewById(R.id.passStrengthBar));

        PasswordStrenghtChecker passwordChecker = new PasswordStrenghtChecker(password, strengthText, strengthBar);

        passwordChecker.setChecker(checker);

    }

/*
    public void calcPassStrength(String passwordText){

        boolean hasUppercase = !passwordText.equals(passwordText.toLowerCase());
        boolean hasLowercase = !passwordText.equals(passwordText.toUpperCase());
        int strengthPoints = 0;
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(passwordText);
        boolean b = m.find();


        if(passwordText.length() < 7){
            strengthText.setText("Password too short");
            strengthBar.setProgress(0);
        }
        else{

            if(b){
                strengthPoints++;
            }

            if(hasLowercase){
                strengthPoints++;
            }

            if(hasUppercase){
                strengthPoints++;
            }

            if(passwordText.matches(".*\\d+.*")){
                strengthPoints++;
            }

            if(passwordText.length() > 8){
                strengthPoints++;
            }

            if(passwordText.length() > 12){
                strengthPoints++;
            }


            if(strengthPoints <= 2){
                strengthText.setText("Strength: low");
                strengthBar.setProgress(33);
                strengthBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
            }

            if(2 < strengthPoints && strengthPoints < 5){
                strengthText.setText("Strength: medium");
                strengthBar.setProgress(66);
                strengthBar.getProgressDrawable().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
            }
            if(strengthPoints >= 5){
                strengthText.setText("Strength: high");
                strengthBar.setProgress(100);
                strengthBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
            }
        }
    }
    */
}