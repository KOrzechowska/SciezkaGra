package com.company.widok;

import com.company.Game;
import com.company.logic.Commons;
import com.company.logic.GameController;
import com.company.logic.Player;
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
    private final int DELAY = 50; //#TODO uzależnić od poziomu trudności
    GameController gameController;

    public PlayingField() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(Commons.boardWidth, Commons.boardWidth));
        Game.getGame().setTimer(new Timer(DELAY, this));
        gameController = new GameController();
        initGame();
        revalidate();
        addKeyListener(new KeyboardKeyListener());

    }

    public void initGame() {
        Timer timer = Game.getGame().getTimer();
        timer.start();
        // nowy Player
        if(Game.getGame().isRestartGame()) {
            Game.getGame().getPlayer().setFirstCoordinates();
            Game.getGame().getPlayer().setNrOfLifes(4);
            MainGameField.getInfoBar().activateAllHearts();
        }
    }

    private void showGameOver(Graphics g2d) {
        g2d.setColor(new Color(50, 251, 18));
        g2d.fillRect(50, 10*Commons.blockSize / 2 - 30, 10*Commons.blockSize - 100, 50);
        g2d.setColor(Color.white); g2d.drawRect(50, 10*Commons.blockSize / 2 - 30, 10*Commons.blockSize - 100, 50);
        String s = "Game Over- naciśnij R.";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);
        g2d.setColor(Color.white); g2d.setFont(small);
        g2d.drawString(s, (10*Commons.blockSize - metr.stringWidth(s)) / 2, 10*Commons.blockSize / 2);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        PaintUtil.paintCourse(g, this);
        PaintUtil.paintGamer(g, this);
        gameController.doControlling();
        gameController.checkForRestart(this);
        if(Game.getGame().getPlayer().getNrOfLifes()==0) {
            showGameOver(g);
            Game.getGame().getTimer().stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Game game = Game.getGame();
        game.getPlayer().advancePlayer();
        repaint();
    }
}
