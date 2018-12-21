package com.example.tt.doteslesson;

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;
    public static final int ENEMY_COLOR_Food = Color.GREEN;
    public static final int ENEMEY_COLOR_War = Color.RED;

    public EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);

    }

    public static Object getRandomCircles() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius);

        return enemyCircle;
    }

    public void setEnemyOrFoodColorDependesOn(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)) {
            setColor(ENEMY_COLOR_Food);
        } else {
            setColor(ENEMEY_COLOR_War);

        }
    }

    private boolean isSmallerThan(SimpleCircle circle) {
        if (radius < circle.radius) {
            return true;
        } else {
            return false;
        }

    }
}