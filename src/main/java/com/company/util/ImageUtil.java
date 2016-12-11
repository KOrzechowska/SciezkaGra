package com.company.util;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * narzedzie do wczytywania obrazków znajdujących się w pliku Recources
 */
public class ImageUtil {
    public static BufferedImage getBufferedImageFromFile(String imageFileName) {
        try {
            return ImageIO.read(ImageUtil.class.getClassLoader().getResource(imageFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ImageIcon getImageIconFromFile(String imageFileName){
        return new ImageIcon(ImageUtil.class.getClassLoader().getResource(imageFileName));
    }
}
