package com.company;

import com.company.util.SpringUtilities;
import com.company.przyklady.ZasadyGry;
import com.company.widok.ButtonFactory;
import com.company.widok.CarChoicePanel;
import com.company.widok.Game;
import com.company.widok.Ramka;

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
        SpringUtilities.makeGrid(this,5,1,5,5,5,5);


        wyjscie.addActionListener(e -> Game.getGame().dispose());
        start.addActionListener(this);
        opcje.addActionListener(this);
        reguly.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if (zrodlo == start) {
            Object result = JOptionPane.showInputDialog(this, "Podaj Nick :");
            System.out.println("start" + result);
            if (result != null) {
                JDialog.setDefaultLookAndFeelDecorated(true);
                Object[] avalibleDifficulties = {"Latwy", "Sredni", "Trudny"};
                Object initialDifficultySelection = avalibleDifficulties[0];
                Object selection = JOptionPane.showInputDialog(this, "Wybierz poziom trudnosci :",
                        "Poziom Trudnosci", JOptionPane.QUESTION_MESSAGE, null, avalibleDifficulties, initialDifficultySelection);
                System.out.println(selection);
            }
            this.setVisible(false);
            Ramka ramka = new Ramka();

        }
      /*  if else(zrodlo==scianachwaly)
        {

       */
        if (zrodlo == reguly) {

            ZasadyGry zGry = new ZasadyGry();
        }
        if (zrodlo == opcje) {
            CarChoicePanel options = new CarChoicePanel();
        }
    }


    public static void main(String[] args) {
        Game appMenu = Game.getGame();
    }
}
