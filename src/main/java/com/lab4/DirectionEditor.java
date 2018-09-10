package com.lab4;

public class DirectionEditor {
    private int step;
    private Direction direction;
    private Figure figure;

    public DirectionEditor(int step, Direction startDirection, Figure figure) {
        this.step = step;
        this.direction = startDirection;
        this.figure = figure;
    }

    public void change() {

    }

    public void addStep() {
        int x = figure.getX();
        int y = figure.getY();

        switch (direction) {
            case RIGHT_DOWN:
                x+=step;
                y+=step;
                break;
            case DOWN:
                y+=step;
                break;
            case LEFT:
                x-=step;
                break;
            case LEFT_DOWN:
                x-=step;
                y+=step;
                break;
            case RIGHT:
                x+=step;
                break;
            case UP:
                y-=step;
                break;
            case UP_LEFT:
                x-=step;
                y-=step;
                break;
            case UP_RIGHT:
                x+=step;
                y-=step;
                break;
        }
        figure.setX(x);
        figure.setY(y);
    }

    public void step() {
        if (isOutOfBorders(figure.getX() + step * Direction.getXModifier(direction),
                figure.getY() + step * Direction.getYModifier(direction),
                figure.getWidth(), figure.getHeight())) {
            direction = Direction.getReverseRandomDirection(direction);
            step();
        } else {
            addStep();
        }
    }

    public boolean isOutOfBorders(int x, int y, int width, int height) {
        return x < 0 || x + width > DrawingPanel.width || y < 0 || y + height > DrawingPanel.height;
    }
}
