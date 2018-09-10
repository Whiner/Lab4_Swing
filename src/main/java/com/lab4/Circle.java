package com.lab4;

import java.awt.*;

public class Circle extends Figure {
    @Override
    public void paint(Graphics2D graphics) {
        graphics.setColor(getColor());
        graphics.fillOval(getX(),getY(), getWidth(), getHeight());
    }

    public Circle() {
    }

    public Circle(int x, int y, int height, int width, Color color) {
        super(x, y, height, width, color);
    }

    public Circle(int x, int y) {
        super(x, y);
    }

}
