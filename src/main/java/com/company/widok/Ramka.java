package com.company.widok;

import javax.swing.*;
import java.awt.*;

public class Ramka extends JFrame {

    private static int nroflifes;

    public Ramka() {
        super("Sciezka");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        this.setLayout(new BorderLayout());
        JButton newGameButton = ButtonWithImageFactory.getJButtonWithImageFile("new game.png");
        JButton highScoresButton = ButtonWithImageFactory.getJButtonWithImageFile("high scores.png");
        JButton pauseButton = ButtonWithImageFactory.getJButtonWithImageFile("pause.png");
        final JToolBar toolbar = new JToolBar();

        toolbar.add(highScoresButton);
        toolbar.add(newGameButton);
        toolbar.add(pauseButton);
        pauseButton.setFocusable(false);

        newGameButton.setToolTipText("Graj");
        pauseButton.setToolTipText("Pauza");
        highScoresButton.setToolTipText("wyniki");
        System.out.println("jestem");
        setVisible(true);

        Plansza GamePlansza = new Plansza();
        add(toolbar, BorderLayout.NORTH);
        add(GamePlansza);
    }
}
