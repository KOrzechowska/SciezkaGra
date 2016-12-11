package com.company.widok;

import com.company.Game;
import com.company.logic.Commons;
import com.company.util.ButtonFactory;

import javax.swing.*;
import java.awt.*;

/**
 * klasa dziedziczaca po JToolBar
 * pasek narzedzi z aktywnymi przyciskami
 * tzn pauza, top5 wyników i nowa gra
 */
public class GameToolbar extends JToolBar {
    public GameToolbar() {
        super();
        setPreferredSize(new Dimension(Commons.boardWidth,50));
        JButton newGameButton = ButtonFactory.createJButtonWithImageFile("new game.png");
        JButton highScoresButton = ButtonFactory.createJButtonWithImageFile("high scores.png");
        JButton pauseButton = ButtonFactory.createJButtonWithImageFile("pause.png");
        newGameButton.setToolTipText("Graj");
        pauseButton.setToolTipText("Pauza");
        highScoresButton.setToolTipText("wyniki");
        add(highScoresButton);
        add(newGameButton);
        add(pauseButton);


    }
}
