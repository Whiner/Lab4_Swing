package com.lab4.moving;

import com.lab4.DrawingPanel;
import com.lab4.figures.Figure;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mover extends Thread {
    private Figure figure;
    private DrawingPanel panel;
    private int step;
    private DirectionEditor directionEditor;
    private boolean run;
    private boolean figureFixed = false;
    private int marginX;
    private int marginY;

    public Mover(Figure figure, DrawingPanel panel, int step) {
        this.figure = figure;
        this.panel = panel;
        this.step = step;
        directionEditor = new DirectionEditor(step, Direction.DOWN, figure);
        addMouseListener();
    }

    private boolean checkClickOnFigure(int clickX, int clickY) {
        return (clickX >= figure.getX() && clickX <= figure.getX() + figure.getWidth()
                && clickY >= figure.getY() && clickY <= figure.getY() + figure.getHeight());
    }

    private void addMouseListener() {
        if (figure.isActive()) {

            MouseAdapter mouseAdapter = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (checkClickOnFigure(e.getX(), e.getY())) {
                        figureFixed = true;
                        marginX = e.getX() - figure.getX();
                        marginY = e.getY() - figure.getY();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    figureFixed = false;
                }

                @Override
                public void mouseDragged(MouseEvent e) {

                    if (figureFixed) {
                        figure.setX(e.getX() - marginX);
                        figure.setY(e.getY() - marginY);
                        panel.repaint();
                    }
                }
            };
            panel.addMouseListener(mouseAdapter);
            panel.addMouseMotionListener(mouseAdapter);
        }
    }

    @Override
    public void run() {
        if (!figure.isActive()) {
            run = true;
            while (run) {
                directionEditor.step();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                panel.repaint();
            }
        }
    }

    public void stopAnimation() {
        run = false;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public DrawingPanel getPanel() {
        return panel;
    }

    public void setPanel(DrawingPanel panel) {
        this.panel = panel;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
