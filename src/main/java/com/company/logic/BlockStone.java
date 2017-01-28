package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

/**
 * Przeszkody na ścieżce
 */
public class BlockStone extends Block {
    public BlockStone(int x, int y) {
        super(x, y);
        this.blockImage = ImageUtil.getImageIconFromFile("stone.png");
    }

    public void collide() {
        Player player = Game.getGame().getPlayer();
        if (!player.isUnBreakable()) {
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
}

