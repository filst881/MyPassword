package com.example.fille.mypassword;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by fille on 2017-12-16.
 */

public class PasswordStrenghtChecker{

    private EditText editText;
    private ProgressBar progressBar;
    private Checker checker;
    private TextView textView;


    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public Checker getChecker() {
        return checker;
    }

    public PasswordStrenghtChecker(EditText editText, final TextView textView, final ProgressBar progressBar){

        this.editText = editText;
        this.progressBar = progressBar;
        this.textView = textView;

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                //calcPassStrength(editable.toString());

                int strength = checker.StrengthChecker(editable.toString());

                if(strength == 0 ){

                    textView.setText("No password");
                    progressBar.setProgress(0);
                    progressBar.getProgressDrawable().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_IN);
                }

                if (strength <= 2 && strength > 0) {
                    textView.setText("Strength: low");
                    progressBar.setProgress(33);
                    progressBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
                }

                if (2 < strength && strength < 5) {
                    textView.setText("Strength: medium");
                    progressBar.setProgress(66);
                    progressBar.getProgressDrawable().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                }
                if (strength >= 5) {
                    textView.setText("Strength: high");
                    progressBar.setProgress(100);
                    progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                }
            }
        });
    }
}