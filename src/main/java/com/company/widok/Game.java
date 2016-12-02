package com.company.widok;

import com.company.Menu;

import javax.swing.*;

public class Game extends JFrame {
    private static Game game = new Game();

    JPanel currentActivePanel=new Menu();

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

    public JPanel getCurrentActivePanel() {
        return currentActivePanel;
    }

    public void setCurrentActivePanel(JPanel currentActivePanel) {
        this.currentActivePanel = currentActivePanel;
    }

}
