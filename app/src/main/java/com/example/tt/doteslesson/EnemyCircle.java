package com.example.tt.doteslesson;

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;
    public static final int ENEMY_COLOR_Food = Color.GREEN;
    public static final int ENEMEY_COLOR_War = Color.RED;

    public static final int MAX_SPEED = 10;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static Object getRandomCircles() {
        Random random = new Random();

        int dx = 1 + random.nextInt(MAX_SPEED);
        int dy = 1 + random.nextInt(MAX_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        int x = radius + random.nextInt(GameManager.getWidth() - (radius * 2));
        int y = radius + random.nextInt(GameManager.getHeight() - (radius * 2));
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius, dx, dy);

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

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x + radius > GameManager.getWidth() || x - radius < 0) {
            dx = -dx;
        }
        if (y + radius > GameManager.getHeight() || y - radius < 0) {
            dy = -dy;
        }
    }

    public void changeMove() {
        dx = -dx;
        dy = -dy;
    }
}
