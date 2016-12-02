package com.company.widok;

import javax.swing.*;

public class GameToolbar extends JToolBar {
    public GameToolbar() {
        super();
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
