package com.company.util;

import com.company.logic.CourseBlock;
import com.company.Game;
import com.company.logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.List;

/**
 * narzedzie do malownia elementów plansz
 */
public class PaintUtil {
    /**
     * funkcja służąca do rysowania gracza
     * @param g obiekt klasy Graphics
     * @param imageObserver interfejs ImageObserver odpowiada za powiadomienia podczas towrzenia obrazka
     */
    public static void paintGamer(Graphics g,ImageObserver imageObserver)
    {
        /**obraz pojazdu wybieranego automatycznie */
        ImageIcon Gamer = ImageUtil.getImageIconFromFile("red_car.jpg");
        /**auto wybierane opcjonalnie*/
        if(Game.getGame().getPlayer().getCarImage()==0)
            Gamer = ImageUtil.getImageIconFromFile("auto1.jpeg");
        if(Game.getGame().getPlayer().getCarImage()==2)
            Gamer = ImageUtil.getImageIconFromFile("auto3.jpeg");
        /**gracz*/
        Player player = Game.getGame().getPlayer();
        /**rozmiar klocka-elemntu planszy*/
        int blockSize =50;
        /**skala obrazu do jego skalowania w szerokości*/
        int skala_w = (int) (blockSize*Game.getGame().getWidth()/500);
        /**skala obrazu do jego skalowania w wyskości*/
        int skala_h = (int) (blockSize*Game.getGame().getHeight()/600);
        g.drawImage(Gamer.getImage(),(int)(player.getX() * skala_w), (int)(player.getY() * skala_h), skala_w, skala_h,imageObserver);
    }

    /**
     * funkcja służąca do rysowania  klocka planszy
     * @param g obiekt klasy Grapgic
     * @param courseBlock klocek planszy
     * @param imageObserver interfejs ImageObserver
     */
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

    /**
     * funkcja rysująca wszystkie klocki
     * @param g
     * @param imageObserver
     */
    public static void paintCourse(Graphics g, ImageObserver imageObserver) {
        /**lista wszystkich klocków do wyświetlenia*/
        List<CourseBlock> courseBlocks= Game.getGame().getCourse().getCurrentCourseBlocks();
        /**pętla chodząca po całej liście , dla każdego bloku wywołuje funkcje paint*/
        for (CourseBlock block : courseBlocks)
        {
            paintBlock(g,block,imageObserver);
        }

    }
}
