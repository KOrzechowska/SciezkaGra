package com.company;

import com.company.util.SpringUtilities;
import com.company.przyklady.ZasadyGry;
import com.company.widok.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {
    JButton start = ButtonFactory.createJButtonWithName("Start");
    JButton scianaChwaly = ButtonFactory.createJButtonWithName("ScianaChwaly");
    JButton reguly = ButtonFactory.createJButtonWithName("Reguly");
    JButton wyjscie = ButtonFactory.createJButtonWithName("Wyjscie");
    JButton opcje = ButtonFactory.createJButtonWithName("Opcje");

    public MenuPanel() {

        super(new SpringLayout());
        add(start);
        add(scianaChwaly);
        add(reguly);
        add(opcje);
        add(wyjscie);
        SpringUtilities.makeGrid(this, 5, 1, 5, 5, 5, 5);


        wyjscie.addActionListener(e -> Game.getGame().dispose());
        start.addActionListener(e -> Game.getGame().setCurrentActivePanel(new PreGamePanel()));
        opcje.addActionListener(this);
        reguly.addActionListener(e -> Game.getGame().setCurrentActivePanel(new ZasadyGry()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if (zrodlo == opcje) {
            CarChoicePanel options = new CarChoicePanel();
        }
    }


    public static void main(String[] args) {
        Game appMenu = Game.getGame();
    }
}
