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
    public MainGameField() {

        setLayout(new BorderLayout());
        //setPreferredSize(new Dimension(Commons.boardWidth, 500));

        final GameInfoBar infoBar = new GameInfoBar();
        final GameToolbar toolbar = new GameToolbar();
        infoBar.disabledHeart(2);//#TODO usunąć
        System.out.println("jestem");
        setVisible(true);

        add(toolbar, BorderLayout.NORTH);
        add(infoBar, BorderLayout.SOUTH);
        add(new PlayingField());


    }
}
