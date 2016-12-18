package com.company.logic;

import com.company.util.ImageUtil;

import javax.swing.*;

/**
 * Created by mrgrinch on 18.12.16.
 */
public class BlockCourse extends Block
{
    private int x,y;
    private ImageIcon blockImage;
    public BlockCourse(int x,int y)
    {
        this.x=x;
        this.y=y;
        this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
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

    @Override
    public void advanceBlock()
    {
            this.y++;
    }
}
