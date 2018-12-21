package com.example.tt.doteslesson;

import android.graphics.Color;

public class MainCircle extends SimpleCircle {
    public static final int INTRadius = 50;
    public static final int MAIN_SPEED = 30;
    public static final int OUR_COLOR = Color.BLUE;
    public static final double NUMBER_PI = 3.1415;
    public MainCircle(int x, int y) {
        super(x, y, INTRadius);
        setColor(OUR_COLOR);
    }


    public void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;
    }

    public void initRadius() {
        radius = INTRadius;
    }

    public void growRadius(SimpleCircle collCircle) {
        radius=  (int) Math.sqrt( ((NUMBER_PI *Math.pow( radius,2)) + (NUMBER_PI *Math.pow(collCircle.radius,2)) )  /NUMBER_PI);
    }
}
