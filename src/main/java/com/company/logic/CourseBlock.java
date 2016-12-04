package com.company.logic;

/**
 * blok ścieżki czyli blok planszy
 */
public class CourseBlock {
    final int x,y;
    int rodzaj;
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
}
