package com.company.widok;

import com.company.Game;
import com.company.logic.Commons;
import com.company.util.KeyboardKeyListener;
import com.company.util.PaintUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * klasa dziedziczaca po JPanel
 * generuje pole gry
 */
public class PlayingField extends JPanel implements ActionListener {
    private final int DELAY = 25; //#TODO uzależnić od poziomu trudności
    private Timer timer;

    public PlayingField() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(Commons.boardWidth, Commons.boardWidth));

        initGame();
        revalidate();
        addKeyListener(new KeyboardKeyListener());
    }

    private void initGame() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        PaintUtil.paintCourse(g, this);
        PaintUtil.paintGamer(g, this);


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Game game = Game.getGame();
        game.getPlayer().advancePlayer();
        repaint();
    }

}
