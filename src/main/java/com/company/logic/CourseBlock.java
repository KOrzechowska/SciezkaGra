package com.company.logic;

/**
 * blok ścieżki czyli blok planszy
 */
public class CourseBlock {
    private int x,y;
    int rodzaj;//#TODO zamienić na enuma albo polimorfizm
    public CourseBlock(int x,int y, int rodzaj)
    {
        this.x=x;
        this.y=y;
        this.rodzaj=rodzaj;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(int rodzaj) {
        this.rodzaj = rodzaj;
    }

    public void advanceBlock()
    {
        this.y++;
    }
}
