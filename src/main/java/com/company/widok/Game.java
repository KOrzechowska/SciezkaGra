package com.company.widok;

import com.company.MenuPanel;
import com.company.logic.Course;
import com.company.logic.Player;

import javax.swing.*;

public class Game extends JFrame {
    private static Game game = new Game();

    private JPanel currentActivePanel = new MenuPanel();

    private Player player = new Player();
    private Course course = new Course();

    private Game() {
        super();
        setTitle("Sciezka");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(currentActivePanel);
        setVisible(true);
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
}
