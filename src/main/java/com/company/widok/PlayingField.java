package com.company.widok;

import com.company.Game;
import com.company.logic.BlockFinish;
import com.company.logic.Commons;
import com.company.logic.GameController;
import com.company.util.KeyboardKeyListener;
import com.company.util.PaintUtil;
import com.company.util.PropertiesReader;
import com.company.util.ServerConector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * klasa dziedziczaca po JPanel
 * generuje pole gry
 */
public class PlayingField extends JPanel implements ActionListener {
    public int DELAY; //#TODO uzależnić od poziomu trudności
    public long elapsedTime = 0L;
    GameController gameController;
    public PlayingField() {
        if(Game.isOnline){
            DELAY = ServerConector.speed;
        }else {
            PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
            DELAY = propertiesReader.getPropertyValueInt2("speed", Game.getDifficultyLvl());
        }
        System.out.println("wartosc index:"+Game.getGame().difficultyLvl);
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
        if(Game.getGame().isRestartGame()) {
            Game.getGame().getPlayer().setFirstCoordinates();
            Game.getGame().getPlayer().setNrOfLifes(Game.getGame().getPlayer().getMaxNrOfLifes());
            Game.getGame().getPlayer().setScore(0);
            Game.getGame().getCourse().setLevelNumber(1);
            Game.getGame().getCourse().getPlansza();
            MainGameField.getInfoBar().setScoreArea();
            MainGameField.getInfoBar().setLevelNumberArea();
            MainGameField.getInfoBar().activateAllHearts();

        }
    }

    private void showGameOver(Graphics g2d) {
        gameController.saveScore();
        g2d.setColor(new Color(50, 251, 18));
        g2d.fillRect(50, 10*Commons.blockSize / 2 - 30, 10*Commons.blockSize - 100, 50);
        g2d.setColor(Color.white); g2d.drawRect(50, 10*Commons.blockSize / 2 - 30, 10*Commons.blockSize - 100, 50);
        String s = "Game Over- naciśnij R.";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);
        g2d.setColor(Color.white); g2d.setFont(small);
        g2d.drawString(s, (10*Commons.blockSize - metr.stringWidth(s)) / 2, 10*Commons.blockSize / 2);
    }

    private void showGameWin(Graphics g2d) {
        gameController.saveScore();
        g2d.setColor(new Color(50, 251, 18));
        g2d.fillRect(50, 10*Commons.blockSize / 2 - 30, 10*Commons.blockSize - 100, 50);
        g2d.setColor(Color.white); g2d.drawRect(50, 10*Commons.blockSize / 2 - 30, 10*Commons.blockSize - 100, 50);
        String s = " WYGRANA GRACZA: "+ Game.getGame().getPlayer().getNick()+" TWOJ WYNIK TO: "+Game.getGame().getPlayer().getScore();
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
        gameController.checkCollisions();
        gameController.checkForRestart(this);

        if(Game.getGame().getPlayer().isUnBreakable()){
            elapsedTime = (new Date()).getTime() - Game.getGame().getPlayer().getStartTime();
            if ((int)elapsedTime > 6*1000){
                Game.getGame().getPlayer().setUnBreakable(false);
                MainGameField.getInfoBar().setUnbreakable();
            }
        }
        if(Game.getGame().getPlayer().getNrOfLifes()==0) {
            showGameOver(g);
            Game.getGame().getTimer().stop();
        }
        if(Game.getGame().getPlayer().isWin() == true)
        {
            Game.getGame().getCourse().setLevelNumber(1);
            showGameWin(g);
            Game.getGame().getPlayer().setWin(false);
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
