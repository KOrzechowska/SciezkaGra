package com.company.widok;

import com.company.Game;
import com.company.util.ButtonFactory;
import com.company.util.PropertiesReader;
import com.company.util.SpringUtilities;
import com.company.widok.PlayingField;

import javax.swing.*;

/**
 * klasa dziedzicząca po JPanel
 * zawiera przyciski funkcjonalne oraz rozwijaną liste z wyborem jednego z trzech poziomów trudności
 */
public class PreGamePanel extends JPanel {
    JComboBox difficultySelection = new JComboBox();
    public PreGamePanel() {

        Object[] avalibleDifficulties = {"Latwy", "Sredni", "Trudny"};
        JLabel difficultyLabel = new JLabel("Poziom Trudności");
        difficultySelection = new JComboBox(avalibleDifficulties);
        difficultySelection.setSelectedIndex(0);
        JLabel nickLabel = new JLabel("Nick Gracza");

        JTextField nickInput = new JTextField();

        JButton nextButton = ButtonFactory.createJButtonWithName("Rozpocznij Gre");
        JButton previousButton = ButtonFactory.createJButtonWithName("Wróć do menu");

        previousButton.addActionListener(e -> Game.getGame().setCurrentActivePanel(new MenuPanel()));
        nextButton.addActionListener(e ->{
            Game.getGame().getPlayer().setNick(nickInput.getText());
            System.out.println(Game.getGame().getPlayer().getNick());
            checkDifficultyLvl();
                                            Game.getGame().setCurrentActivePanel(new MainGameField());

                                        });

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

    public void checkDifficultyLvl(){
        if (difficultySelection.getSelectedIndex() == 0) {
            Game.setDifficultyLvl(1);
        }
        if (difficultySelection.getSelectedIndex() == 1){
            Game.setDifficultyLvl(2) ;
        }
        if (difficultySelection.getSelectedIndex() == 2){
            Game.setDifficultyLvl(3);
        }
    }

}
