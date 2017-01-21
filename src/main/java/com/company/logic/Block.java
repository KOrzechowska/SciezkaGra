package com.company.logic;


import com.company.Game;

import javax.swing.*;

/**
 * klasa abstarkcyjna dziedziczą po niej wszystkie klocki
 */
public abstract class Block {
    public abstract void advanceBlock();

    public abstract int getX();

    public abstract int getY();

    public abstract ImageIcon getBlockImage();

    public boolean isInRangeX(int x) {
        int maxX = this.getX() * Commons.blockSize + Commons.blockSize;
        int minX = getX() * Commons.blockSize;

        if (x < maxX && x >= minX) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isInRangeY(int y) {
        int maxY = (getY() - 2) * Commons.blockSize;
        int minY = (getY() - 2) * Commons.blockSize - Commons.blockSize;
        if (y < maxY && y >= minY) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isInRange(int x, int y) {
        int maxX = this.getX() * Commons.blockSize + Commons.blockSize;
        int minX = getX() * Commons.blockSize;
        int maxY = (8 - getY()) * Commons.blockSize + Commons.blockSize;
        int minY = (8 - getY()) * Commons.blockSize;

        if (x < maxX && x >= minX && y < maxY && y >= minY) {
            return true;
        } else {
            return false;
        }
    }
    public void collide(){

    }

}
