package com.company.widok;

import com.company.Game;
import com.company.util.ButtonFactory;

import javax.swing.*;

public class GameInfoBar extends JPanel {
    public GameInfoBar() {
        super();
        addHeart();
        addHeart();
        addHeart();
        JTextArea scoreArea = new JTextArea("Score: "+0);
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
