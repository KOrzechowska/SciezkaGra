package com.company.logic;

import com.company.util.ImageUtil;

import javax.swing.*;

public class BlockHeart extends Block {
    private int x,y;
    private ImageIcon blockImage;
    private boolean isActive;
    public BlockHeart(int x,int y)
    {
        this.isActive= true;
        this.x=x;
        this.y=y;
        this.blockImage = ImageUtil.getImageIconFromFile("serce1.jpg");
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

    public ImageIcon getBlockImage() {
        return blockImage;
    }

    public void setBlockImage(ImageIcon blockImage) {
        this.blockImage = blockImage;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void advanceBlock()
    {
        this.y++;
    }
}
