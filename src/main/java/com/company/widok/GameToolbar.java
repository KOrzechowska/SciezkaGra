package com.company.widok;

import javax.swing.*;

public class GameToolbar extends JToolBar {
    public GameToolbar() {
        super();
        JButton newGameButton = ButtonWithImageFactory.getJButtonWithImageFile("new game.png");
        JButton highScoresButton = ButtonWithImageFactory.getJButtonWithImageFile("high scores.png");
        JButton pauseButton = ButtonWithImageFactory.getJButtonWithImageFile("pause.png");
        newGameButton.setToolTipText("Graj");
        pauseButton.setToolTipText("Pauza");
        highScoresButton.setToolTipText("wyniki");
        add(highScoresButton);
        add(newGameButton);
        add(pauseButton);

    }
}
