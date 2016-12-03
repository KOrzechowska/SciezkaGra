package com.company;

import com.company.util.SpringUtilities;
import com.company.przyklady.ZasadyGry;
import com.company.widok.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {


    public MenuPanel() {

        super();
        JPanel mainMenuPanel = new JPanel(new SpringLayout());
        JButton start = ButtonFactory.createJButtonWithName("Start");
        JButton scianaChwaly = ButtonFactory.createJButtonWithName("Ściana Chwały");
        JButton reguly = ButtonFactory.createJButtonWithName("Reguły");
        JButton opcje = ButtonFactory.createJButtonWithName("Opcje");
        JButton wyjscie = ButtonFactory.createJButtonWithName("Wyjście");

        mainMenuPanel.add(start);
        mainMenuPanel.add(scianaChwaly);
        mainMenuPanel.add(reguly);
        mainMenuPanel.add(opcje);
        mainMenuPanel.add(wyjscie);
        SpringUtilities.makeGrid(mainMenuPanel, 5, 1, 5, 5, 5, 5);
        add(mainMenuPanel);

        start.addActionListener(e -> Game.getGame().setCurrentActivePanel(new PreGamePanel()));
        reguly.addActionListener(e -> Game.getGame().setCurrentActivePanel(new ZasadyGry()));
        opcje.addActionListener(e -> new CarChoicePanel());
        wyjscie.addActionListener(e -> Game.getGame().dispose());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->  Game.getGame());
    }
}
