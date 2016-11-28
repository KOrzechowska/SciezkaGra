package com.company.widok;

import com.company.PropertiesReader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kasia on 28.11.16.
 */
public class Plansza extends JPanel{

    /** ustawienie rozmiaru czcionki */
    private final Font smallfont = new Font("Helvetica", Font.BOLD, 14);
    /** obiekt klasy BufferedImage */
    private BufferedImage heart, bomb;
    private BufferedImage setIcon(String imageName){
        try {
            return ImageIO.read(getClass().getClassLoader().getResource(imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private final int scrsize = 6 * 50;
    /**zmienna do której przypisujemy akltualny szerokoæ okna*/
    private int w;
    /**zmienna do której przypisujemy akltualny wysokoæ okna*/
    private int h;
    /**skala dla szerokoci*/
    float skala_w ;
    /**skala dla wysokoci*/
    float skala_h;

    public Plansza(){
        super();
        heart = (BufferedImage) setIcon("serce1.jpg");

        JPanel box = new JPanel();
        JPanel all = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));

        all.setLayout(new BorderLayout());
        all.add(box, BorderLayout.NORTH);
        add(all, BorderLayout.EAST);

        setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.gray);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        drawZycia(g);
    }

    private void drawZycia(Graphics g)
    {
        int i;
        String s;
        String p;
        g.setFont(smallfont);
        g.setColor(Color.white);
        s = "Level: 1";// + level;
        p = "Liczba punktow: ";// + bomber.getScore();
        /** rysowanie na ekran liczby punktów i który to poziom */
        g.drawString(p, (int)(skala_w*scrsize) / 2 + 96, (int)(skala_h*scrsize) + 36);
        g.drawString(s, (int)(skala_w*scrsize) / 2 + 96, (int)(skala_h*scrsize) + 16);

        for (i = 0; i < 3; i++)
        {
            g.drawImage(heart, i * 28 + 8, (int)(skala_h*scrsize) +1, this);
        }

    }
}
