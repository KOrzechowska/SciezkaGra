package com.company.widok;

import com.company.util.KeyboardHandler;
import com.company.util.PaintUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayingField extends JPanel implements ActionListener {
    private final int DELAY = 140; //#TODO uzależnić od poziomu trudności
    private Timer timer;

    public PlayingField() {
        addKeyListener(new KeyboardHandler());
        setBackground(Color.black);
        setFocusable(true);
        initGame();

    }

    private void initGame() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        PaintUtil.paintCourse(g);
        PaintUtil.paintGamer(g,this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}
