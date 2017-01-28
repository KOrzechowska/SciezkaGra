package com.company.widok;

import com.company.logic.HighScores;
import com.company.util.SpringUtilities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Top5Panel extends JPanel {

    public Top5Panel() {
        super();
        JFrame.setDefaultLookAndFeelDecorated(true);
        JTextArea textAreal = new JTextArea("TOP 5 WYNIKÓW", 5, 10);

        HighScores highScores2 = new HighScores();
        highScores2.addToHighScoreList("john", 343);
        highScores2.addToHighScoreList("john", 344);
        highScores2.addToHighScoreList("john", 345);
        highScores2.addToHighScoreList("john", 340);
        highScores2.addToHighScoreList("john", 343);
        try {
            highScores2.saveHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HighScores highScores = new HighScores();
        try {
            highScores.loadHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        JPanel highScoresPanel = new JPanel(new SpringLayout());
        for (int i = 0; i < 5; i++) {
            JLabel nr = new JLabel(i+1+".");
            JLabel nick = new JLabel(highScores.getHighScoreList().get(i).getNick());
            JLabel score = new JLabel(""+highScores.getHighScoreList().get(i).getScore());
            highScoresPanel.add(nr);
            highScoresPanel.add(nick);
            highScoresPanel.add(score);
        }
        SpringUtilities.makeGrid(highScoresPanel, 5, 3, 5, 5, 5, 5);

        add(highScoresPanel);

        setVisible(true);

    }

}
