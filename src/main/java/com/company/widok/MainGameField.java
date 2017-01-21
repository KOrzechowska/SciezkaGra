package com.company.widok;

import com.company.logic.Commons;

import javax.swing.*;
import java.awt.*;

/**
 * klasa dziedziczaca po JPanel
 * zawiera trzy panele gry
 * tzn panel gry, panel informacyjny, panel narzędzi
 */
public class MainGameField extends JPanel {
    private static GameInfoBar infoBar = new GameInfoBar();
    public MainGameField() {

        setLayout(new BorderLayout());

        final GameToolbar toolbar = new GameToolbar();
        
        System.out.println("jestem");
        setVisible(true);

        add(toolbar, BorderLayout.NORTH);
        add(infoBar, BorderLayout.SOUTH);
        add(new PlayingField());


    }

    public static GameInfoBar getInfoBar() {
        return infoBar;
    }
}
