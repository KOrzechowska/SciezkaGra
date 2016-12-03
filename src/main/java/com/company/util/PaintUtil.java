package com.company.util;

import com.company.logic.CourseBlock;
import com.company.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.List;

public class PaintUtil {
    public static void paintGamer(Graphics g,ImageObserver imageObserver)
    {
        ImageIcon Gamer = ImageUtil.getImageIconFromFile("auto1.jpeg");
        g.drawImage(Gamer.getImage(),50,50,imageObserver);
    }

    private static void paintBlock(Graphics g,CourseBlock courseBlock)
    {
        g.setColor(Color.white);
        int blockSize =30;
        g.fillRect(courseBlock.getX()*blockSize,courseBlock.getY()*blockSize,blockSize,blockSize);
    }

    public static void paintCourse(Graphics g) {
        List<CourseBlock> courseBlocks= Game.getGame().getCourse().getCurrentCourseBlocks();
        for (CourseBlock block : courseBlocks)
        {
            paintBlock(g,block);
        }

    }
}
