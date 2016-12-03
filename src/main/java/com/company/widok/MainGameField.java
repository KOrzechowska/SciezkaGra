package com.company.widok;

import javax.swing.*;
import java.awt.*;

public class MainGameField extends JPanel {
    public MainGameField() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500));

        final GameInfoBar infoBar = new GameInfoBar();
        final GameToolbar toolbar = new GameToolbar();
        System.out.println("jestem");
        setVisible(true);

        add(toolbar, BorderLayout.NORTH);
        add(infoBar, BorderLayout.SOUTH);
        add(new PlayingField());


    }
}
