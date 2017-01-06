package com.company.logic;

import com.company.util.ImageUtil;

import javax.swing.*;

/**
 * monety na ścieżce
 */
public class BlockCoin extends Block{
    private int x,y;
    private ImageIcon blockImage;
    private boolean isActive;
    public BlockCoin(int x,int y)
    {
        this.isActive = true;
        this.x=x;
        this.y=y;
        this.blockImage = ImageUtil.getImageIconFromFile("coin.png");
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
    @Override
    public void advanceBlock()
    {
        this.y++;
    }
}
