package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

/**
 * monety na ścieżce
 */
public class BlockFinish extends Block{
    private int x,y;
    private ImageIcon blockImage;
    private boolean isActive;
    public BlockFinish(int x, int y)
    {
        this.isActive = true;
        this.x=x;
        this.y=y;
        this.blockImage = ImageUtil.getImageIconFromFile("meta.jpg");
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
    public void collide(){
        if (this.isActive() == true) {
            Course course = Game.getGame().getCourse();
            Player player = Game.getGame().getPlayer();
            course.advanceLevel();
            player.setScore(player.getScore() + 50);
            MainGameField.getInfoBar().setScoreArea();
            MainGameField.getInfoBar().setLevelNumberArea();
            player.setFirstCoordinates();
            course.getPlansza();
            this.setActive(false);

        }
    }
}

