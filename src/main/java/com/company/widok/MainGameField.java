package com.company.widok;

import javax.swing.*;
import java.awt.*;

public class MainGameField extends JPanel {
    public MainGameField() {

        setLayout(new BorderLayout());

        final GameInfoBar infoBar = new GameInfoBar();

        System.out.println("jestem");
        setVisible(true);

        add(infoBar, BorderLayout.NORTH);

    }
}
