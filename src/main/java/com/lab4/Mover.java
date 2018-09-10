package com.lab4;

import javax.swing.*;

public class Mover extends Thread {
    private Figure figure;
    private DrawingPanel panel;
    private int step;
    private DirectionEditor directionEditor;
    private boolean run;

    public Mover(Figure figure, DrawingPanel panel, int step) {
        this.figure = figure;
        this.panel = panel;
        this.step = step;
        directionEditor = new DirectionEditor(step, Direction.DOWN, figure);
    }


    @Override
    public void run() {
        run = true;
        while (run) {
            System.out.println(Thread.currentThread().getName() + " run loop");
            directionEditor.step();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            panel.repaint();
        }
    }

    public void stopAnimation(){
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
