package com.company.widok;

import com.company.Game;
import com.company.util.ButtonFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameInfoBar extends JPanel {

    private List<JButton> hearts = new ArrayList<>();
    public GameInfoBar() {
        super();
        setPreferredSize(new Dimension(500,50));
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
        hearts.add(heartImage);
    }

    public void disabledHeart(int i){
        hearts.get(i).setDisabledIcon(null);
    }

    public void activateHeart(int i){
        hearts.get(i).setDisabledIcon(hearts.get(i).getIcon());
    }
}
