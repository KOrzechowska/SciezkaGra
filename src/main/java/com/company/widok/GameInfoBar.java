package com.company.widok;

import com.company.Game;
import com.company.logic.Commons;
import com.company.util.ButtonFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * klasa dziedziczaca po JPanel
 * pasek z informacjami o obecnym stanie gry
 * tzn liczba żyć , liczba punktów, poziom
 */
public class GameInfoBar extends JPanel {
    /**lista prezentowanych zyć*/
    private List<JButton> hearts = new ArrayList<>();

    /**
     * konstruktor klasy
     * zasilenie panelu wartościami początkowymi gry
     */
    public GameInfoBar() {
        super();
        setPreferredSize(new Dimension(Commons.boardWidth,50));
        for (int i=0; i<Game.getGame().getPlayer().getNrOfLifes(); i++)
            addHeart();

        JTextArea scoreArea = new JTextArea("Score: "+ Game.getGame().getPlayer().getScore());
        scoreArea.setEditable(false);
        add(scoreArea);
        JTextArea levelNumberArea = new JTextArea("Level: " + Game.getGame().getCourse().getLevelNumber());
        levelNumberArea.setEditable(false);
        add(levelNumberArea);
    }

    /**
     * funkcja dodajaca jedno zycie do panelu
     */
    private void addHeart() {
        JButton heartImage = ButtonFactory.createJButtonWithImageFile("serce1.jpg");
        heartImage.setEnabled(false);
        heartImage.setDisabledIcon(heartImage.getIcon());
        add(heartImage);
        hearts.add(heartImage);
    }

    /**
     * funkcja odejmująca życie na panelu
     * @param i numer życia do desaktywacji
     */
    public void disabledHeart(int i){
        hearts.get(i).setDisabledIcon(null);
        validate();
        setVisible(true);
    }

    /**
     * funkcja dodająca życie na panelu
     * @param i nr życia do aktywacji
     */
    public void activateHeart(int i){
        hearts.get(i).setDisabledIcon(hearts.get(i).getIcon());
        validate();
        setVisible(true);
    }

    public void activateAllHearts(){
        for(int i = 0; i< Game.getGame().getPlayer().getNrOfLifes(); i++)
        hearts.get(i).setDisabledIcon(hearts.get(i).getIcon());
        validate();
        setVisible(true);
    }
}
