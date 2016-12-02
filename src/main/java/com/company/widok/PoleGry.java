package com.company.widok;

import javax.swing.*;
import java.awt.*;

public class PoleGry extends JPanel {
    public PoleGry() {

        setLayout(new BorderLayout());

        final GameToolbar toolbar = new GameToolbar();

        System.out.println("jestem");
        setVisible(true);

        Plansza GamePlansza = new Plansza();
        add(toolbar, BorderLayout.NORTH);
        add(GamePlansza);
    }
}
