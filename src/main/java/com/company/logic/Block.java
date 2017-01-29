package com.company.logic;


import com.company.Game;

import javax.swing.*;
import java.awt.*;

/**
 *Klasa po której dziedziczą wszystkie rodzaje Bloków
 */
public class Block {
    /**współrzędne bloku*/
    int x, y;
    //*zmienna opisująca wygląd bloku*/
    ImageIcon blockImage;
    /**sprawdzanie czy blok jest aktywny*/
    boolean isActive;
    /**konstruktor klasy block*/
    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ImageIcon getBlockImage() {
        return blockImage;
    }

    public void setBlockImage(ImageIcon blockImage) {
        this.blockImage = blockImage;
    }
    /**sprawdzanie czy bloki nachodzą na siebie*/
    public boolean isInRange(int x, int y) {
        int skala_h = (int) (Commons.blockSize* Game.getGame().getHeight()/Commons.boardHeigth);
        int maxX = this.getX() * Commons.blockSize + Commons.blockSize;
        int minX = getX() * Commons.blockSize;
        int maxY = (8 - getY()) * skala_h + skala_h;
        int minY = (8 - getY()) * skala_h;


        if (x < maxX && x >= minX && y < maxY && y >= minY) {
            return true;
        } else {
            if (x + Commons.blockSize < maxX && x + Commons.blockSize >= minX && y < maxY && y >= minY) {
                return true;
            } else {
                return false;
            }

        }
    }

    public void collide() {

    }

    public void advanceBlock() {
        this.y++;
    }
}
