package com.company.widok;

import com.company.PropertiesReader;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

import static com.company.PropertiesReader.getPropertyValue;

/**
 * Created by kasia on 27.11.16.
 */
public class Ramka extends JFrame {

    private  JButton _newGameButton;
    private  JButton _pauseButton;
    private ImageIcon _newGameIcon;
    private ImageIcon _pauseIcon;
    private ImageIcon _stopIcon;
    private ImageIcon _highScoresIcon;
    private static int nroflifes;

    private ImageIcon setIcon(String imageName){
        return new ImageIcon(getClass().getClassLoader().getResource(imageName));
    }
    public Ramka(){
        super("Sciezka");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        this.setLayout(new BorderLayout());
        // ustawienie obrazków dla przycisków z menu
        // nowa gra, najwyższe wyniki, pauza
       _newGameIcon = setIcon("new game.png");
        _pauseIcon = setIcon("pause.png");
        _stopIcon = setIcon("stop.png");
        _highScoresIcon = setIcon("high scores.png");

        _newGameButton = new JButton(_newGameIcon);
        JButton highScoresButton = new JButton(_highScoresIcon);
        _pauseButton = new JButton(_pauseIcon);
        final JToolBar toolbar = new JToolBar();

            toolbar.add(highScoresButton);
        toolbar.add(_newGameButton);
        toolbar.add(_pauseButton);
        _pauseButton.setFocusable(false);
        _newGameButton.setFocusable(false);
        highScoresButton.setFocusable(false);
        _newGameButton.setToolTipText("Graj");
        _pauseButton.setToolTipText("Pauza");
        highScoresButton.setToolTipText("wyniki");
System.out.println("jestem");
        setVisible(true);

        Plansza GamePlansza = new Plansza();
        add(toolbar, BorderLayout.NORTH);
        add(GamePlansza);
        //nroflifes = Integer.getInteger(PropertiesReader.getPropertyValue("life"));

        // czytanie z pliku
        //getPropertyValue("life");


    }
}
