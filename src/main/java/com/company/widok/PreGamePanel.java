package com.company.widok;

import com.company.Game;
import com.company.util.ButtonFactory;
import com.company.util.SpringUtilities;

import javax.swing.*;

public class PreGamePanel extends JPanel {
    public PreGamePanel() {

        Object[] avalibleDifficulties = {"Latwy", "Sredni", "Trudny"};
        JLabel difficultyLabel = new JLabel("Poziom Trudności");
        JComboBox difficultySelection = new JComboBox(avalibleDifficulties);
        difficultySelection.setSelectedIndex(0);

        JLabel nickLabel = new JLabel("Nick Gracza");
        JTextField nickInput = new JTextField();

        JButton nextButton = ButtonFactory.createJButtonWithName("Rozpocznij Gre");
        JButton previousButton = ButtonFactory.createJButtonWithName("Wróć do menu");

        previousButton.addActionListener(e -> Game.getGame().setCurrentActivePanel(new MenuPanel()));
        nextButton.addActionListener(e -> Game.getGame().setCurrentActivePanel(new MainGameField()));

        JPanel main = new JPanel(new SpringLayout());
        main.add(difficultyLabel);
        main.add(difficultySelection);
        main.add(nickLabel);
        main.add(nickInput);
        main.add(previousButton);
        main.add(nextButton);

        SpringUtilities.makeCompactGrid(main, 3, 2, 6, 6, 6, 6);
        add(main);
        //#TODO zrobić listenera na tych polach by zmieniał atrybuty gracza
    }

}
