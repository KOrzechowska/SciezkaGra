package com.company.widok;

import com.company.Game;
import com.company.logic.Commons;
import com.company.util.ButtonFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * klasa dziedziczaca po JToolBar
 * pasek narzedzi z aktywnymi przyciskami
 * tzn pauza, top5 wyników i nowa gra
 */
public class GameToolbar extends JToolBar {
    Boolean isGamePaused = false;
    private Timer timer;

    public GameToolbar() {
        super();
        setPreferredSize(new Dimension(Commons.boardWidth, 50));
        JButton newGameButton = ButtonFactory.createJButtonWithImageFile("new game.png");
        JButton highScoresButton = ButtonFactory.createJButtonWithImageFile("high scores.png");
        JButton pauseButton = ButtonFactory.createJButtonWithImageFile("pause.png");
        newGameButton.setToolTipText("Graj");
        pauseButton.setToolTipText("Pauza");
        highScoresButton.setToolTipText("wyniki");
        add(highScoresButton);
        add(newGameButton);
        add(pauseButton);
        ActionListener pauseEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                timer = Game.getGame().getTimer();
                if (isGamePaused) {
                    isGamePaused = false;
                    timer.start();
                } else {
                    isGamePaused = true;
                    timer.stop();
                }
            }
        };
        pauseButton.addActionListener(pauseEvent);

        //ActionListener newGameEvent = new ActionListener() {
          //  @Override
            //public void actionPerformed(ActionEvent actionEvent) {

           // }
        //};
        //pauseButton.addActionListener(pauseEvent);
    }
}
