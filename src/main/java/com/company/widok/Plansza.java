package com.company.widok;

import com.company.Util.ImageUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Plansza extends JPanel {

    private final Font smallfont = new Font("Helvetica", Font.BOLD, 14);
    private BufferedImage heartImage, bombImage;

    private final int screenSize = 6 * 50;
    private int width;
    private int height;
    private float width_scale;
    private float height_scale;

    public Plansza() {
        super();
        heartImage = ImageUtil.setIcon("serce1.jpg");

        JPanel box = new JPanel();
        JPanel all = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));

        all.setLayout(new BorderLayout());
        all.add(box, BorderLayout.NORTH);
        add(all, BorderLayout.EAST);

        setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.gray);
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawZycia(g);
    }

    private void drawZycia(Graphics g) {
        int i;
        String s;
        String p;
        g.setFont(smallfont);
        g.setColor(Color.white);
        s = "Level: 1";// + level;
        p = "Liczba punktow: ";// + bomber.getScore();
        /** rysowanie na ekran liczby punktów i który to poziom */
        g.drawString(p, (int) (width_scale * screenSize) / 2 + 96, (int) (height_scale * screenSize) + 36);
        g.drawString(s, (int) (width_scale * screenSize) / 2 + 96, (int) (height_scale * screenSize) + 16);

        for (i = 0; i < 3; i++) {
            g.drawImage(heartImage, i * 28 + 8, (int) (height_scale * screenSize) + 1, this);
        }

    }
}
