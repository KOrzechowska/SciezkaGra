package com.company.Util;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtil {
    public static BufferedImage setIcon(String imageName) {
        try {
            return ImageIO.read(ImageUtil.class.getClassLoader().getResource(imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
