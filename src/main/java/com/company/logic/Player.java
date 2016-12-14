package com.company.logic;

import com.company.util.PropertiesReader;

import java.awt.event.KeyEvent;

/**
 * Player - gracz
 */
public class Player {
    private int nrOfLifes;
    private int score;
    private int x,y;
    private String nick;
    private int carImage=1;

    public Player(){
        //pobieranie informacji z xml
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
        nrOfLifes = propertiesReader.getPropertyValueInt("lifes");
        setFirstCoordinates();
    }

    /**
     * ustwienie początkowych współrzędnych graczy
     * - współrzędne te są czytane z pliku konfiguracyjnego
     */
    private void setFirstCoordinates(){
            // pobranie planszy z xml
            PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
            String planszaStream = propertiesReader.getPropertyValue("plansza", 1);
            int i=0;
            for(int y=9; y>-1; y--)
                for (int x=0; x<10; x++)
                {
                    int rodzajBloku = Integer.parseInt(planszaStream.substring(i, i + 1));
                    if(rodzajBloku == 7){
                        this.x = x;
                        this.y = y;
                    }
                    i++;
                }
    }
    public void advancePlayer()
    {
        this.y++;
    }
    /**
     * funkcja zwarvająca wybrany pojazd użytkownika
     * @return kod wybranego auta
     */
    public int getCarImage() {
        return carImage;
    }

    /**
     * ustawienie auta dla gracza
     * @param carImage - kod auta
     */
    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }

    /**
     * funkcja zwracająca nazwę użtkownika
     * @return nazwa gracza
     */
    public String getNick() {
        return nick;
    }

    /**
     * ustawienie nazwy graczowi
     * @param nick - nazwa gracza
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * funkcja zwaracająca współrzedną x gracza
     * @return - współrzędna x
     */
    public int getX() {
        return x;
    }

    /**
     * ustawienie graczowi współrzędnej x
     * @param x współrzędna x gracza
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * funkcja zwracająca współrzędną y gracza
     * @return współrzędna y gracza
     */
    public int getY() {
        return y;
    }

    /**
     * ustawienie współrzędnej x użytkownika
     * @param y współrzędna y gracza
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * funkcja zwracająca liczbę żyć gracza
     * @return liczba żyć
     */
    public int getNrOfLifes() {
        return nrOfLifes;
    }

    /**
     * ustawienie liczby żyć użytkownikowi
     * @param nrOfLifes - liczba żyć
     */
    public void setNrOfLifes(int nrOfLifes) {
        this.nrOfLifes = nrOfLifes;
    }

    /**
     * funkcja zwracająca wynik gracza
     * @return - liczba zdobytych punktów
     */
    public int getScore() {
        return score;
    }

    /**
     * ustawienie graczowi liczby punktów
     * @param score - liczba zdobytych punktów
     */
    public void setScore(int score) {
        this.score = score;
    }

    public void handleKeys(KeyEvent e)
    {
        System.out.println("malekotki");
    }

}
