package com.example.fille.mypassword;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fille on 2017-12-16.
 */

public class StrengthChecker implements Checker {




    @Override
    public int StrengthChecker(String Password) {

        boolean hasUppercase = !Password.equals(Password.toLowerCase());
        boolean hasLowercase = !Password.equals(Password.toUpperCase());
        int strengthPoints = 0;
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(Password);
        boolean b = m.find();


        if (b) {
            strengthPoints++;
        }

        if (hasLowercase) {
            strengthPoints++;
        }

        if (hasUppercase) {
            strengthPoints++;
        }

        if (Password.matches(".*\\d+.*")) {
            strengthPoints++;
        }

        if (Password.length() > 8) {
            strengthPoints++;
        }

        if (Password.length() > 12) {
            strengthPoints++;
        }

        return strengthPoints;

    }
}

