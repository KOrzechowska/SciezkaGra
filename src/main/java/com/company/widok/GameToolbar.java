package com.company.widok;

import com.company.Game;
import com.company.util.ButtonFactory;

import javax.swing.*;
import java.awt.*;

public class GameToolbar extends JToolBar {
    public GameToolbar() {
        super();
        setPreferredSize(new Dimension(500,50));
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
