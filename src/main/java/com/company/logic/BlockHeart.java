package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

public class BlockHeart extends Block {
    private int x, y;
    private ImageIcon blockImage;
    private boolean isActive;

    public BlockHeart(int x, int y) {
        this.isActive = true;
        this.x = x;
        this.y = y;
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
    public void advanceBlock() {
        this.y++;
    }

    public void collide() {
        Player player = Game.getGame().getPlayer();
        if (this.isActive() == true && player.getNrOfLifes() < player.getMaxNrOfLifes()) {
            player.setNrOfLifes(player.getNrOfLifes() + 1);
            MainGameField.getInfoBar().activateHeart(player.getNrOfLifes() - 1);
            this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
            this.setActive(false);
        }
        if(this.isActive() == true && player.getNrOfLifes() == player.getMaxNrOfLifes()){
            player.setScore(player.getScore() + 2);
            MainGameField.getInfoBar().setScoreArea();
            this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
            this.setActive(false);
        }
    }
}
