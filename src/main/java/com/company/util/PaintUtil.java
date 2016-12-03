package com.company.util;

import com.company.widok.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class PaintUtil {
    public static void paintGamer(Graphics g, ImageObserver imageObserver)
    {
        ImageIcon Gamer = ImageUtil.getImageIconFromFile("auto1.jpeg");
        g.drawImage(Gamer.getImage(),50,50,imageObserver);
    }
}
