package com.company;

import com.company.logic.Course;
import com.company.logic.Player;
import com.company.widok.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private static Game game = new Game();

    private Player player = new Player();
    private Course course = new Course();

    private Game() {
        super();
        setTitle("Sciezka");
        setMinimumSize(new Dimension(500, 625));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new MenuPanel());
        setVisible(true);
        pack();
    }

    public static Game getGame() {
        return game;
    }


    public void setCurrentActivePanel(JPanel currentActivePanel) {

        getContentPane().removeAll();
        getContentPane().add(currentActivePanel);
        validate();
        setVisible(true);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> Game.getGame());
    }
}
