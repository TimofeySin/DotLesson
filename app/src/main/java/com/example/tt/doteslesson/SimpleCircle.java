package com.example.tt.doteslesson;

import java.util.ArrayList;

public class SimpleCircle {
    protected int x;
    protected int y;
    protected int radius;
    private int color;

    public SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public int getColor() {
        return color;
    }

    protected void setColor(int color) {
        this.color = color;
    }

    public SimpleCircle getCircleArea() {
        return new SimpleCircle(x, y, radius * 3);
    }

    public boolean isIntersect(SimpleCircle circle) {
        Boolean result;
        result = radius + circle.radius >= Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
        return result;
    }

    public boolean isIntersect(ArrayList<EnemyCircle> circleList, SimpleCircle circle) {
        Boolean result;
        for (SimpleCircle curcircle : circleList) {
            result = curcircle.radius + circle.radius >= Math.sqrt(Math.pow(curcircle.x - circle.x, 2) + Math.pow(curcircle.y - circle.y, 2));
            if ((result) && (curcircle != circle)){
                return curcircle;
            }
        }
        return circle;
    }
}
