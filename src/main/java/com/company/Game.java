package com.company;

import com.company.logic.Commons;
import com.company.logic.Course;
import com.company.logic.Player;
import com.company.util.KeyboardKeyListener;
import com.company.widok.MenuPanel;
import com.company.widok.OnlinePanel;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;

/**
 * klasa dziedzicząca po JFrame
 * tworzy ramke gry
 * zawiera obiekty gracz i ścieżka
 */
public class Game extends JFrame {
    public static int difficultyLvl = 1;
    /** instatncja gry - obiekt statyczny*/
    private static Game game = new Game();
    /** gracz*/
    private Player player = new Player();
    /** ścieżka - plansza*/
    private Course course = new Course();
    private Timer timer;

    private boolean restartGame = false;
    /**czy jest połączenie online*/
    public static boolean isOnline = false;
    private Game() {
        super();
        addKeyListener(new KeyboardKeyListener());
        setTitle("Sciezka");
        setMinimumSize(new Dimension(Commons.boardWidth, Commons.boardHeigth));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new OnlinePanel());
        setVisible(true);
        setFocusable(true);
        pack();
    }

    /**
     * funkcja zwracająca aktualną grę
     * @return
     */
    public static Game getGame() {
        return game;
    }

    public boolean isRestartGame() {
        return restartGame;
    }

    public void setRestartGame(boolean restartGame) {
        this.restartGame = restartGame;
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

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public static int getDifficultyLvl() {
        return difficultyLvl;
    }

    public static void setDifficultyLvl(int difficultyLvl) {
        Game.difficultyLvl = difficultyLvl;
    }
}
