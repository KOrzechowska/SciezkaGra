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
    private JTextArea scoreArea = new JTextArea("Score: "+ Game.getGame().getPlayer().getScore());
    private JTextArea levelNumberArea = new JTextArea("Level: " + Game.getGame().getCourse().getLevelNumber());
    private JTextArea unbreakable = new JTextArea("Niezniszcalność: "+ (Game.getGame().getPlayer().isUnBreakable()?"ON":"OFF"));

    /**
     * konstruktor klasy
     * zasilenie panelu wartościami początkowymi gry
     */
    public GameInfoBar() {
        super();
        int k;
        setPreferredSize(new Dimension(Commons.boardWidth,80));
        for (int i=0; i<Game.getGame().getPlayer().getNrOfLifes(); i++){
            addHeart();
        }
        JPanel teksty = new JPanel();
        teksty.setLayout(new BoxLayout(teksty, BoxLayout.PAGE_AXIS));
        System.out.println("score:"+Game.getGame().getPlayer().getScore());
        scoreArea.setText("Score: "+Game.getGame().getPlayer().getScore());
        scoreArea.setEditable(false);
        teksty.add(scoreArea);
        levelNumberArea.setText("Level: " + Game.getGame().getCourse().getLevelNumber());
        levelNumberArea.setEditable(false);
        teksty.add(levelNumberArea);
        unbreakable.setText("Niezniszcalność: "+ (Game.getGame().getPlayer().isUnBreakable()?"ON":"OFF"));
        unbreakable.setEditable(false);
        teksty.add(unbreakable);
        add(teksty);
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

    /**
     * funkcja aktuwujaca wszystkie serca
     */
    public void activateAllHearts(){
        for(int i = 0; i< Game.getGame().getPlayer().getNrOfLifes(); i++)
        hearts.get(i).setDisabledIcon(hearts.get(i).getIcon());
        validate();
        setVisible(true);
    }

    /**
     * funkcja ustawiajaca wynik wyswietlany w panelu
     */
    public void setScoreArea(){
        scoreArea.setText("Score: "+Game.getGame().getPlayer().getScore());
        validate();
    }

    /**
     * funkcja ustawiajaca wynik wyswietlany w panelu
     */
    public void setLevelNumberArea(){
        levelNumberArea.setText("Level: " + Game.getGame().getCourse().getLevelNumber());
        validate();
    }

    /**
     * funkcja wyswietlajaca w panelu  czy niezniszalnosc jest aktywna czy nie
     */
    public void setUnbreakable(){
        unbreakable.setText("Niezniszcalność: "+ (Game.getGame().getPlayer().isUnBreakable()?"ON":"OFF"));
        validate();
    }
}
