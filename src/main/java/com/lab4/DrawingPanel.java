package com.lab4;

import com.lab4.figures.Figure;
import com.lab4.moving.Mover;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {

    public static final int width = 1800;
    public static final int height = 800;
    private int minStep;
    private int maxStep;
    private List<Figure> figureList;
    private List<Mover> figureMovers = new ArrayList<>();

    public List<Figure> getFigureList() {
        return figureList;
    }



    public DrawingPanel(List<Figure> figureList, int minStep, int maxStep) {
        super();
        this.maxStep = maxStep;
        this.minStep = minStep;
        this.figureList = figureList;
        run();
    }

    public void run() {
        for (Figure figure : figureList) {
            Mover e = new Mover(figure, this,minStep + new Random().nextInt(maxStep - minStep));
            figureMovers.add(e);
        }

        for (Mover mover: figureMovers){
            mover.start();
        }
    }

    @Override
    protected synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Figure figure : figureList) {
            figure.paint(g2d);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}
