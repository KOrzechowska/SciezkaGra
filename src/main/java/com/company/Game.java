package com.company;

import com.company.logic.Commons;
import com.company.logic.Course;
import com.company.logic.Player;
import com.company.widok.MenuPanel;

import javax.swing.*;
import java.awt.*;

/**
 * klasa dziedzicząca po JFrame
 * tworzy ramke gry
 * zawiera obiekty gracz i ścieżka
 */
public class Game extends JFrame {
    /** instatncja gry - obiekt statyczny*/
    private static Game game = new Game();
    /** gracz*/
    private Player player = new Player();
    /** ścieżka - plansza*/
    private Course course = new Course();

    private Game() {
        super();
        setTitle("Sciezka");
        setMinimumSize(new Dimension(Commons.boardWidth, Commons.boardHeigth));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new MenuPanel());
        setVisible(true);
        pack();
    }

    /**
     * funkcja zwracająca aktualną grę
     * @return
     */
    public static Game getGame() {
        return game;
    }

    /**
     * funkcja służąca do ustawienia aktualnie wyświetlanego panelu
     * @param currentActivePanel panel do wyświetlania
     */
    public void setCurrentActivePanel(JPanel currentActivePanel) {

        getContentPane().removeAll();
        getContentPane().add(currentActivePanel);
        validate();
        setVisible(true);
    }

    /**
     * funkcja pobierająca obiekt gracz
     * @return zwaraca obiekt gracz
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * ustawienie aktualnego gracza
     * @param player - gracz
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * funkcja pobierajaca ścieżkę
     * @return zwraca ścieżkę
     */
    public Course getCourse() {
        return course;
    }

    /**
     * ustawienie aktualnej ścieżki
     * @param course - ścieżka - plansza
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> Game.getGame());
    }
}
