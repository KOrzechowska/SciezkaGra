package com.company.widok;

import javax.swing.*;
import java.awt.*;

public class Ramka extends JFrame {
    public Ramka() {
        super("Sciezka");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        this.setLayout(new BorderLayout());

        final GameToolbar toolbar = new GameToolbar();

        System.out.println("jestem");
        setVisible(true);

        Plansza GamePlansza = new Plansza();
        add(toolbar, BorderLayout.NORTH);
        add(GamePlansza);
    }
}
