package com.example.fille.mypassword;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by fille on 2017-12-20.
 */

public class PasswordStrenghtMeter extends LinearLayout {

    private EditText password;
    private TextView strengthText;
    private ProgressBar strengthBar;
    private Checker checker = new StrengthChecker();
    LinearLayout.LayoutParams param;

    public PasswordStrenghtMeter(final Context context) {
        super(context);

        password = new EditText(context);
        strengthText = new TextView(context);
        strengthBar = new ProgressBar(context);

        this.setOrientation(VERTICAL);
        param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        PasswordStrenghtChecker passwordChecker = new PasswordStrenghtChecker(password, strengthText, strengthBar);

        passwordChecker.setChecker(checker);

        this.setLayoutParams(param);
        this.addView(password);
        this.addView(strengthText);
        this.addView(strengthBar);
    }
}
