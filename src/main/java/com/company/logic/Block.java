package com.company.logic;


import com.company.Game;

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
        int maxX = this.getX()*Commons.blockSize + Commons.blockSize;
        int minX = getX()*Commons.blockSize;

        if(x<maxX && x>=minX) {
            isInRange = true;
            System.out.println("zakres w x:\t"+minX+"\t"+maxX+"\t"+x +"\t"+getX()+"\t"+ Game.getGame().getPlayer().getY());
        }
        else
            isInRange = false;

        return isInRange;
    }
    public boolean isInRangeY(int y){
        boolean isInRange;
        int maxY = (getY()-2)*Commons.blockSize;
        int minY = (getY()-2)*Commons.blockSize - Commons.blockSize;
        //int maxY = ///Commons.blockSize*2 + getY()*Commons.blockSize;
        //int minY = getY()*Commons.blockSize+ Commons.blockSize;
        if(y<maxY && y>=minY) {
            //if(y>=100)
            isInRange = true;
            System.out.println("zakres w y:\t"+minY+"\t"+maxY+"\t"+y +"\t"+getY()+"\t"+"\t\"+minX+\"\\t\"+maxX+\"\\t\"+x +\"\\t\"+getX()+\"\\t\"+ Game.getGame().getPlayer().getY()");
        }
        else
            isInRange = false;
        //System.out.println("zakres w y:\t"+y +"\t"+getY()+"\t"+minY+"\t"+maxY+"\t");
        return isInRange;
    }

    public boolean isInRange(int x, int y){
        boolean isInRange;
        int maxX = this.getX()*Commons.blockSize + Commons.blockSize;
        int minX = getX()*Commons.blockSize;
        int maxY = (getY())*Commons.blockSize;
        int minY = (getY())*Commons.blockSize - Commons.blockSize;

        if(x<maxX && x>=minX && y<maxY && y>=minY) {
            isInRange = true;
            System.out.println("zakres w y:\t"+y +"\t"+getY()+"\t"+minY+"\t"+maxY+"	"+minX+"\t"+maxX+"\t"+x +"\t"+getX()+"\t");
        }
        else
        isInRange = false;
      //  System.out.println("zakres w y:\t"+y +"\t"+getY()+"\t"+minY+"\t"+maxY+"	"+minX+"\t"+maxX+"\t"+x +"\t"+getX()+"\t");
        //System.out.println("zakres w y:\t"+y +"\t"+x +"\t");
        return isInRange;
    }
}
