package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

/**
 * Przeszkody na ścieżce
 * klasa dziedziczaca po klasie Block
 */
public class BlockStone extends Block {
    /**konstuktor klasy BlockStone*/
    public BlockStone(int x, int y) {
        super(x, y);
        /*wyglad klocka*/
        this.blockImage = ImageUtil.getImageIconFromFile("stone.png");
    }

    /**
     * funkcja opisujaca efekt kolizji
     * gracz traci jedno zycie
     */
    public void collide() {
        Player player = Game.getGame().getPlayer();
        /**jezeli gracz nie jest niezniszalny*/
        if (!player.isUnBreakable()) {
            /**jezeli liczba zyc wieksza od 0*/
            if (player.getNrOfLifes() > 0) {
                /**gracz traci jedno zycie*/
                player.setNrOfLifes(player.getNrOfLifes() - 1);
                /**po smierci zaczecie od poczatkowej pozycji*/
                player.setFirstCoordinates();
                /**deaktywacja jednego serca z panelu wyświetlajacego serca*/
                MainGameField.getInfoBar().disabledHeart(player.getNrOfLifes());
            } else {
                System.out.println("GAME OVER");
            }
        }
    }
}

