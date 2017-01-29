package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

/**
 * klasa dziedziczaca po klasie Block
 */
public class BlockHeart extends Block {
    /**konstruktor klasy BlockHeart*/
    public BlockHeart(int x, int y) {
        super(x,y);
        /**ustawienie bloku na aktywny*/
        this.isActive = true;
        /**wygląd bloku*/
        this.blockImage = ImageUtil.getImageIconFromFile("serce1.jpg");
    }

    /**
     * funkcja opisujaca efekt zerzenia sie gracza z tym blokiem
     */
    public void collide() {
        Player player = Game.getGame().getPlayer();
        /**jezeli blok jest aktywny i liczba zyc jest mniejsza niz liczba czytana z liku properties*/
        if (this.isActive() == true && player.getNrOfLifes() < player.getMaxNrOfLifes()) {
            /**dodajemy jedno zycie graczowi*/
            player.setNrOfLifes(player.getNrOfLifes() + 1);
            /**odswiezenie panelu pokazujacego liczbe zyc*/
            MainGameField.getInfoBar().activateHeart(player.getNrOfLifes() - 1);
            /**po zebraniu bonusu bonus znika*/
            this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
            /**deaktywacja tego bonusu*/
            this.setActive(false);
        }
        /**jezeli bonus jest aktywny a liczba zyć jest równa maksymalnej liczbie zyc */
        if(this.isActive() == true && player.getNrOfLifes() == player.getMaxNrOfLifes()){
            /**dodaj graczowi 2 pkt*/
            player.setScore(player.getScore() + 2);
            /**odswiezenie miejsca w ktorym wyswietlany jest wynik*/
            MainGameField.getInfoBar().setScoreArea();
            /**znikniecie bonusu*/
            this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
            /**deaktywacja bonusu*/
            this.setActive(false);
        }
    }
}
