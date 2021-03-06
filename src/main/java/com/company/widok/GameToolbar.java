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
    /** sprawdza czy gra jest zatrzymana*/
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
        System.out.println("fdf"+Game.getGame().getPlayer().getNick());
        JTextArea NickArea = new JTextArea("Nick: "+ Game.getGame().getPlayer().getNick());
        NickArea.setEditable(false);
        add(NickArea);

        ActionListener pauseEvent = new ActionListener() {
            @Override
            /**zatrzymanie gry*/
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
        ActionListener newGameEvent = new ActionListener() {
            @Override
            /**rozpoczecie gry od poczatku*/
            public void actionPerformed(ActionEvent actionEvent) {
                Game.getGame().setRestartGame(true);
                Game.getGame().getTimer().start();
            }
        };
        newGameButton.addActionListener(newGameEvent);
        /**wyswietlenie listy najlepszych wynikow*/
        highScoresButton.addActionListener(e->{
            JDialog wyniki = new Top5Panel();
            wyniki.setModal(true);
            wyniki.setVisible(true);
            wyniki.pack();
        });
    }
}
