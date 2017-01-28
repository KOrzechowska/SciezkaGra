package com.company.logic;


import javax.swing.*;
import java.awt.*;


public class Block {

    int x, y;
    ImageIcon blockImage;
    boolean isActive;

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

    public boolean isInRange(int x, int y) {
        int maxX = this.getX() * Commons.blockSize + Commons.blockSize;
        int minX = getX() * Commons.blockSize;
        int maxY = (8 - getY()) * Commons.blockSize + Commons.blockSize;
        int minY = (8 - getY()) * Commons.blockSize;


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
