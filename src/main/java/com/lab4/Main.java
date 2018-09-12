package com.lab4;

import com.lab4.figures.Circle;
import com.lab4.figures.Figure;
import com.lab4.figures.Ring;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Figure figure = new Circle(10, 10, 40, 40, Color.BLACK);
        figure.setActive(true);
        Figure figure1 = new Ring(150, 300, 50, 50, Color.GREEN);
        Figure figure2 = new Circle(300, 100, 10, 10, Color.GRAY);
        Figure figure3 = new Circle(300, 100, 100, 100, Color.GRAY);
        Figure figure4 = new Ring(650, 450, 50, 50, Color.RED);

        List<Figure> figures = new ArrayList<>(Arrays.asList(figure, figure1, figure2, figure3, figure4));

        new MainWindow(new DrawingPanel(figures, 1, 15));


    }
}
