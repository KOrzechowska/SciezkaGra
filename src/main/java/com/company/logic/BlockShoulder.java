package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

/**
 * Klocek pobocza
 */
public class BlockShoulder extends Block {
    private int x, y;
    private ImageIcon blockImage;

    public BlockShoulder(int x, int y) {
        this.x = x;
        this.y = y;
        this.blockImage = ImageUtil.getImageIconFromFile("pobocze.jpeg");
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
    public void advanceBlock() {

    }
    public void collide(){
        Player player = Game.getGame().getPlayer();
        if (player.getNrOfLifes() > 0) {
            player.setNrOfLifes(player.getNrOfLifes() - 1);
            System.out.println("DEATH \t" + player.getNrOfLifes());
            player.setFirstCoordinates();
            MainGameField.getInfoBar().disabledHeart(player.getNrOfLifes());
        } else {
            System.out.println("GAME OVER");
        }
    }
}
