package com.company.widok;

import com.company.Game;
import com.company.util.ButtonFactory;

import javax.swing.*;

public class GameInfoBar extends JPanel {
    public GameInfoBar() {
        super();

        for (int i=0; i<Game.getGame().getPlayer().getNrOfLifes(); i++)
            addHeart();

        JTextArea scoreArea = new JTextArea("Score: "+ Game.getGame().getPlayer().getScore());
        scoreArea.setEditable(false);
        add(scoreArea);
        JTextArea levelNumberArea = new JTextArea("Level: " + Game.getGame().getCourse().getLevelNumber());
        levelNumberArea.setEditable(false);
        add(levelNumberArea);
    }

    private void addHeart() {
        JButton heartImage = ButtonFactory.createJButtonWithImageFile("serce1.jpg");
        heartImage.setEnabled(false);
        heartImage.setDisabledIcon(heartImage.getIcon());
        add(heartImage);
    }
}
