package com.lab4;

import java.awt.*;

public class Ring extends Figure {
    @Override
    public void paint(Graphics2D graphics) {
        graphics.setColor(getColor());
        graphics.drawOval(getX(),getY(), getWidth(), getHeight());
    }


    public Ring() {
    }

    public Ring(int x, int y, int height, int width, Color color) {
        super(x, y, height, width, color);
    }

    public Ring(int x, int y) {
        super(x, y);
    }


}
