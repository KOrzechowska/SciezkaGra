package com.company.util;

import com.company.logic.Commons;
import com.company.logic.CourseBlock;
import com.company.Game;
import com.company.logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.List;

/**
 * narzedzie do malowania elementów plansz
 */
public class PaintUtil {
    /**
     * funkcja służąca do rysowania gracza
     * @param g obiekt klasy Graphics
     * @param imageObserver interfejs ImageObserver odpowiada za powiadomienia podczas towrzenia obrazka
     */
    public static void paintGamer(Graphics g,ImageObserver imageObserver)
    {
        ImageIcon gamerIcon = ImageUtil.getImageIconFromFile("red_car.jpg");
        if(Game.getGame().getPlayer().getCarImage()==0)
            gamerIcon = ImageUtil.getImageIconFromFile("auto1.jpeg");
        if(Game.getGame().getPlayer().getCarImage()==2)
            gamerIcon = ImageUtil.getImageIconFromFile("auto3.jpeg");
        Player player = Game.getGame().getPlayer();

        int skala_w = (int) (Commons.blockSize*Game.getGame().getWidth()/Commons.boardWidth);
        int skala_h = (int) (Commons.blockSize*Game.getGame().getHeight()/Commons.boardHeigth);
        g.drawImage(gamerIcon.getImage(),(int)(player.getX() * skala_w/Commons.blockSize), 8*skala_h, skala_w, skala_h,imageObserver);
    }

    /**
     * funkcja służąca do rysowania  klocka planszy
     * @param g obiekt klasy Grapgics
     * @param courseBlock klocek planszy
     * @param imageObserver interfejs ImageObserver
     */
    private static void paintBlock(Graphics g,CourseBlock courseBlock, ImageObserver imageObserver)
    {
        Game game = Game.getGame();
        Player player = game.getPlayer();

        int skala_w = (int) (Commons.blockSize*Game.getGame().getWidth()/Commons.boardWidth);
        int skala_h = (int) (Commons.blockSize*Game.getGame().getHeight()/Commons.boardHeigth);
        ImageIcon blockImage;
        if(courseBlock.getRodzaj() == 0)// podłoga
            blockImage = ImageUtil.getImageIconFromFile("pobocze.jpeg");
        else
            blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");

        g.drawImage(blockImage.getImage(), (int)(courseBlock.getX() * skala_w), (int)(courseBlock.getY()  * skala_h)+player.getY(), skala_w, skala_h, imageObserver);
    }

    /**
     * funkcja rysująca wszystkie klocki
     * @param g
     * @param imageObserver
     */
    public static void paintCourse(Graphics g, ImageObserver imageObserver) {
        List<CourseBlock> courseBlocks= Game.getGame().getCourse().getCurrentCourseBlocks();
        for (CourseBlock block : courseBlocks)
        {
            paintBlock(g,block,imageObserver);
        }

    }
}
