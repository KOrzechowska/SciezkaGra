package com.company.widok;

import javax.swing.*;
import java.awt.*;

public class MainGameField extends JPanel {
    public MainGameField() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500));

        final GameInfoBar infoBar = new GameInfoBar();

        System.out.println("jestem");
        setVisible(true);

        add(infoBar, BorderLayout.NORTH);
        add(new PlayingField());

    }
}
