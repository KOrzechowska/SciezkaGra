package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

/**
 * monety na ścieżce
 */
public class BlockCoin extends Block{
    public BlockCoin(int x,int y)
    {
        super(x,y);
        this.isActive = true;
        this.blockImage = ImageUtil.getImageIconFromFile("coin.png");
    }


    public void collide(){
        if (this.isActive() == true) {
            Player player = Game.getGame().getPlayer();
            player.setScore(player.getScore() + 1);
            MainGameField.getInfoBar().setScoreArea();
            this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
            this.setActive(false);

        }
    }

}
