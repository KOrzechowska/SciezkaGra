package com.company.widok;

import com.company.Game;
import com.company.logic.HighScores;
import com.company.util.ButtonFactory;
import com.company.util.SpringUtilities;

import javax.swing.*;
import java.io.IOException;

/**
 * klasa dziedziczaca po JDialog
 */
public class Top5Panel extends JDialog {

    public Top5Panel() {
        super();
        JFrame.setDefaultLookAndFeelDecorated(true);
        JTextArea textAreal = new JTextArea("TOP 5 WYNIKÓW", 5, 10);


        HighScores highScores = new HighScores();
        try {
            highScores.loadHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        JPanel highScoresPanel = new JPanel(new SpringLayout());
        for (int i = 0; i < highScores.getHighScoreList().size(); i++) {
            JLabel nr = new JLabel(i+1+".");
            JLabel nick = new JLabel(highScores.getHighScoreList().get(i).getNick());
            JLabel score = new JLabel(""+highScores.getHighScoreList().get(i).getScore());
            highScoresPanel.add(nr);
            highScoresPanel.add(nick);
            highScoresPanel.add(score);
        }
        SpringUtilities.makeGrid(highScoresPanel,highScores.getHighScoreList().size(), 3, 5, 5, 5, 5);

        add(highScoresPanel);

        setVisible(true);

    }

}
