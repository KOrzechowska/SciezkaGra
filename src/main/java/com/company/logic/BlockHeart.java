package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

public class BlockHeart extends Block {
    public BlockHeart(int x, int y) {
        super(x,y);
        this.isActive = true;
        this.blockImage = ImageUtil.getImageIconFromFile("serce1.jpg");
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
