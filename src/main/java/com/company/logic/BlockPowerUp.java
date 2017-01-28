package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

/**
 * monety na ścieżce
 */
public class BlockPowerUp extends Block{
    public BlockPowerUp(int x,int y)
    {
        super(x,y);
        this.isActive = true;
        this.blockImage = ImageUtil.getImageIconFromFile("unbreakable.jpg");
    }
    public void collide(){
        if (this.isActive() == true) {
            Player player = Game.getGame().getPlayer();
            player.setUnBreakable(true);
            player.setStartTime(System.currentTimeMillis());
            player.setScore(player.getScore() + 1);
            MainGameField.getInfoBar().setScoreArea();
            MainGameField.getInfoBar().setUnbreakable();
            this.setActive(false);

        }
    }
}
