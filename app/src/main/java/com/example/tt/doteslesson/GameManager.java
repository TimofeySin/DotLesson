package com.example.tt.doteslesson;


import java.util.ArrayList;

public class GameManager {
    public static final int MAX_CIRCLE = 10;

    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        circles = new ArrayList<>();
        for (int i = 0; i < MAX_CIRCLE; i++) {
            EnemyCircle circle;
            SimpleCircle mainEnemyCircleArea;
            do {
                circle = (EnemyCircle) EnemyCircle.getRandomCircles();
                mainEnemyCircleArea = circle.getCircleArea();
            }
            while (circle.isIntersect(mainCircleArea) == true || !mainEnemyCircleArea.equals(circle.isIntersect(circles, mainEnemyCircleArea)));
            circles.add(circle);
        }
        calculateAndSetCirclesColor();
    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle : circles) {
            circle.setEnemyOrFoodColorDependesOn(mainCircle);
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        checkCollision();
        moveCircles();

    }

    private void checkCollision() {
        SimpleCircle collCircle;
        SimpleCircle ciclefordel = null;
        collCircle = mainCircle.isIntersect(circles, mainCircle);

        if (!mainCircle.equals(collCircle)) {
            if (mainCircle.isSmallerThan(collCircle)) {
                gameEnd(false);
                return;
            } else {
                mainCircle.growRadius(collCircle);
                calculateAndSetCirclesColor();
                ciclefordel = collCircle;

            }

            if (ciclefordel != null) {
                circles.remove(ciclefordel);
            }
            if (circles.isEmpty()) {
                gameEnd(true);
            }

        }
    }

    private void gameEnd(boolean b) {


        canvasView.showMessage(b);

        mainCircle.initRadius();
        initEnemyCircles();
        canvasView.redraw();
    }

    private void moveCircles() {
        for (EnemyCircle circle : circles) {

            circle.moveOneStep();
            if (!circle.equals(mainCircle.isIntersect(circles, circle))) {
                circle.changeMove();
            }
        }
    }
}
