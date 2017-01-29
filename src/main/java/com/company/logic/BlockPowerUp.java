package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

/**
 * BlokPowerUp dziedizczy po klasie Block
 */
public class BlockPowerUp extends Block{
    /**konstruktor klasy BlockPowerUp*/
    public BlockPowerUp(int x,int y)
    {
        super(x,y);
        /**ustawienie na aktywny*/
        this.isActive = true;
        /**ustawienie wygladu tego bloku*/
        this.blockImage = ImageUtil.getImageIconFromFile("unbreakable.jpg");
    }

    /**
     * funkcja opisujaca efekt zderzenia gracza z tym blokiem
     */
    public void collide(){
        /**jezeli jest aktywny*/
        if (this.isActive() == true) {
            Player player = Game.getGame().getPlayer();
            /**aktywacja niezniszalnosci*/
            player.setUnBreakable(true);
            /**startuje czas bonusu*/
            player.setStartTime(System.currentTimeMillis());
            /**dodanie jedengo pkt za zebranie bonusu*/
            player.setScore(player.getScore() + 1);
            /**po zebraniu bonus znika*/
            this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
            /**odświezenie panelu wyniku*/
            MainGameField.getInfoBar().setScoreArea();
            /**odswiezenei panelu pokazujacego czy niezniszalnosc jest wlaczona czy nie*/
            MainGameField.getInfoBar().setUnbreakable();
            /**wylaczenie bonusu*/
            this.setActive(false);

        }
    }
}
