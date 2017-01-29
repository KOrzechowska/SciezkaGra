package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.widok.MainGameField;

import javax.swing.*;

/**
 * Klocek pobocza
 * dziedziczy po klasie Block
 */
public class BlockShoulder extends Block {
    /*konstuktor klasy BlockShoulder*/
    public BlockShoulder(int x, int y) {
        super(x, y);
        /**wyglad tego klocka*/
        this.blockImage = ImageUtil.getImageIconFromFile("pobocze.jpeg");
    }

    /**
     * funkcja opisujaca efekt kolizji
     * gracz ginie
     */
    public void collide() {
        /**stworzenie gracza*/
        Player player = Game.getGame().getPlayer();
        /**jezeli liczba zyc jest wieksza od 0*/
        if (player.getNrOfLifes() > 0) {
            /**zabranie graczowi jendego zycia */
            player.setNrOfLifes(player.getNrOfLifes() - 1);
            /**po smierci zaczecie od poczatkowych ustawien gracza*/
            player.setFirstCoordinates();
            /**zabranie jednego zycia z panelu wyswietlajacego serca*/
            MainGameField.getInfoBar().disabledHeart(player.getNrOfLifes());
        } else {
            System.out.println("GAME OVER");
        }
    }
}
