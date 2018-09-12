package com.lab4.figures;

import java.awt.*;

public abstract class Figure {
    private int x;
    private int y;
    private int height;
    private int width;
    private Color color = Color.WHITE;
    private boolean active = false;
    public abstract void paint(Graphics2D graphics);

    public Figure() {
    }

    public Figure(int x, int y, int height, int width, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public Figure(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {

        return height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
