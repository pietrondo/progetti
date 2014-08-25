package com.teamtreehouse.funfacts;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by pietro on 25/08/14.
 */
public class ColorWheel {

    public String[] mColors = {"#39add1", "#3079ab",
            "#c25975",
            "#e15258",
            "#f9845b",
            "#838cc7"
    };
    public int getmColors() {



        String color;
        Random randomcolor = new Random();
        int randomcolornumber = randomcolor.nextInt(mColors.length);
        color= mColors[randomcolornumber];
        int ColorAsInt = Color.parseColor(color);
        return ColorAsInt;

    }
}
