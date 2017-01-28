package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

/**
 * Klocek pobocza
 */
public class BlockShoulder extends Block {
    public BlockShoulder(int x, int y) {
        super(x, y);
        this.blockImage = ImageUtil.getImageIconFromFile("pobocze.jpeg");
    }

    public void collide() {
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
