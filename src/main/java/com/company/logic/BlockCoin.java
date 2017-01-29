package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

/**
 * monety na ścieżce
 * klasa dziedziczaca po klasie Block
 */
public class BlockCoin extends Block{
    /**konstruktor klasy BlockCoin*/
    public BlockCoin(int x,int y)
    {
        super(x,y);
        /**ustawienie że moneta jest aktywana*/
        this.isActive = true;
        /**ustawienie wyglądu monety*/
        this.blockImage = ImageUtil.getImageIconFromFile("coin.png");
    }

    /**
     * funkcja opisujaca efekt kolizji z tym blokiem
     */
    public void collide(){
        /**jezeli gracz zderzy sie z moneta*/
        if (this.isActive() == true) {
            Player player = Game.getGame().getPlayer();
            /**do wyniku gracza zostaje dodany 1 pkt*/
            player.setScore(player.getScore() + 1);
            /**odświeżenie tablicy wyniku*/
            MainGameField.getInfoBar().setScoreArea();
            /**po zebraniu monety ona znika*/
            this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
            /**deaktywacja tego pola*/
            this.setActive(false);

        }
    }

}
