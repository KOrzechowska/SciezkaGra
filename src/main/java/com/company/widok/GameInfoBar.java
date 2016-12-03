package com.company.widok;

import com.company.util.ImageUtil;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class GameInfoBar extends JToolBar {
    public GameInfoBar() {
        super();
        addHeart();
        addHeart();
        addHeart();
        JTextArea scoreArea = new JTextArea("Score: "+0);
        add(scoreArea);
        JTextArea levelNumberArea = new JTextArea("Level: " + Game.getGame().getCourse().getLevelNumber());
        add(levelNumberArea);
    }

    private void addHeart() {
        JButton heartImage = ButtonFactory.createJButtonWithImageFile("serce1.jpg");
        heartImage.setEnabled(false);
        heartImage.setDisabledIcon(heartImage.getIcon());
        add(heartImage);
    }
}
