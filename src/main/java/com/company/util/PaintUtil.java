package com.company.util;

import com.company.logic.CourseBlock;
import com.company.Game;
import com.company.logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.List;

public class PaintUtil {
    public static void paintGamer(Graphics g,ImageObserver imageObserver)
    {
        ImageIcon Gamer = ImageUtil.getImageIconFromFile("red_car.jpg");
        Player player = Game.getGame().getPlayer();
        int blockSize =50;
        int skala_w = (int) (blockSize*Game.getGame().getWidth()/500);
        int skala_h = (int) (blockSize*Game.getGame().getHeight()/600);
        g.drawImage(Gamer.getImage(),(int)(player.getX() * skala_w), (int)(player.getY() * skala_h), skala_w, skala_h,imageObserver);
    }

    private static void paintBlock(Graphics g,CourseBlock courseBlock, ImageObserver imageObserver)
    {
        int blockSize =50;
        int skala_w = (int) (blockSize*Game.getGame().getWidth()/500);
        int skala_h = (int) (blockSize*Game.getGame().getHeight()/600);
        ImageIcon blockImage;
        if(courseBlock.getRodzaj() == 0)// podłoga
            blockImage = ImageUtil.getImageIconFromFile("pobocze.jpeg");
        else
            blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
        g.drawImage(blockImage.getImage(), (int)(courseBlock.getX() * skala_w), (int)(courseBlock.getY() * skala_h), skala_w, skala_h, imageObserver);
    }

    public static void paintCourse(Graphics g, ImageObserver imageObserver) {
        List<CourseBlock> courseBlocks= Game.getGame().getCourse().getCurrentCourseBlocks();
        for (CourseBlock block : courseBlocks)
        {
            paintBlock(g,block,imageObserver);
        }

    }
}
