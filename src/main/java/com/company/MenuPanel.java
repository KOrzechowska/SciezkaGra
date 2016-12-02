package com.company;

import com.company.util.SpringUtilities;
import com.company.przyklady.ZasadyGry;
import com.company.widok.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    JButton start = ButtonFactory.createJButtonWithName("Start");
    JButton scianaChwaly = ButtonFactory.createJButtonWithName("ScianaChwaly");
    JButton reguly = ButtonFactory.createJButtonWithName("Reguly");
    JButton wyjscie = ButtonFactory.createJButtonWithName("Wyjscie");
    JButton opcje = ButtonFactory.createJButtonWithName("Opcje");

    public MenuPanel() {

        super();
        JPanel mainMenuPanel = new JPanel(new SpringLayout());
        mainMenuPanel.add(start);
        mainMenuPanel.add(scianaChwaly);
        mainMenuPanel.add(reguly);
        mainMenuPanel.add(opcje);
        mainMenuPanel.add(wyjscie);
        SpringUtilities.makeGrid(mainMenuPanel, 5, 1, 5, 5, 5, 5);
        add(mainMenuPanel);

        wyjscie.addActionListener(e -> Game.getGame().dispose());
        start.addActionListener(e -> Game.getGame().setCurrentActivePanel(new PreGamePanel()));
        opcje.addActionListener(e -> new CarChoicePanel());
        reguly.addActionListener(e -> Game.getGame().setCurrentActivePanel(new ZasadyGry()));
    }

    public static void main(String[] args) {
        Game appMenu = Game.getGame();
    }
}
