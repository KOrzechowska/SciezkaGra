package com.company.logic;

import com.company.util.ImageUtil;

import javax.swing.*;

/**
 * klasa sciezki dziedziczaca po klasie Block
 * poruszamy sie poniej
 */
public class BlockCourse extends Block {
    /**konstuktor klasy BlockCourse*/
    public BlockCourse(int x, int y) {
        super(x,y);
        /**obraz opisujący wygląd tego bloku*/
        this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
    }

}
