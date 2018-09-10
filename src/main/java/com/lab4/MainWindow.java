package com.lab4;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    //public MainWindow(){
//        setSize(1800, 900);
//        setBackground(new Color(255, 255, 204));
//        setVisible(true);
//        for(Figure figure: figureList) {
//            figure.paint(getGraphics());
//        }
   // }
    public MainWindow(JPanel panel) {
        this.panel = panel;
        this.initComponents();
    }

    private void initComponents(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanel(){
        return panel;
    }

    private JPanel panel;

}
