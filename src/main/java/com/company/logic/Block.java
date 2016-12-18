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
    public abstract boolean isInRangeX(int x);
    public abstract boolean isInRangeY(int y);
}
