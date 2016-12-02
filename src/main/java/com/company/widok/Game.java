package com.company.widok;

import com.company.MenuPanel;

import javax.swing.*;

public class Game extends JFrame {
    private static Game game = new Game();

    private JPanel currentActivePanel=new MenuPanel();

    private Game() {
        super();
        setTitle("Sciezka");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(currentActivePanel);
        setVisible(true);
    }

    public static Game getGame() {
        return game;
    }


    public void setCurrentActivePanel(JPanel currentActivePanel) {
        getContentPane().removeAll();
        getContentPane().add(currentActivePanel);
        validate();
        setVisible(true);
    }

}
