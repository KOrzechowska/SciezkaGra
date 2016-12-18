package com.company.logic;


import javax.swing.*;

/**
 * klasa abstarkcyjna dziedziczą po niej wszystkie klocki
 */
public abstract class Block
{
    public abstract void advanceBlock();
    public abstract int getX();
    public abstract int getY();
    public abstract ImageIcon getBlockImage();
    //public abstract boolean isInRangeX(int x);
   // public abstract boolean isInRangeY(int y);
    public boolean isInRangeX(int x){
        boolean isInRange;
        int maxX = Commons.blockSize + this.getX()*Commons.blockSize;
        int minX = getX()*Commons.blockSize;
        if(x<maxX && x>=minX)
            isInRange = true;
        else
            isInRange = false;

        return isInRange;
    }
    public boolean isInRangeY(int y){
        boolean isInRange;
        int maxY = Commons.blockSize*2 + getY()*Commons.blockSize;
        int minY = getY()*Commons.blockSize+ Commons.blockSize;
        if(y<maxY && y>=minY)
            isInRange = true;
        else
            isInRange = false;
        //System.out.println(minY+"      "+maxY+"      "+y );
        return isInRange;
    }
}
