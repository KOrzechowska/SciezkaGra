package com.company.logic;

import com.company.util.PropertiesReader;

/**
 * Player - gracz
 */
public class Player {
    /** liczba zyc */
    private int nrOfLifes;
    /** wynik gracza */
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

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNrOfLifes() {
        return nrOfLifes;
    }

    public void setNrOfLifes(int nrOfLifes) {
        this.nrOfLifes = nrOfLifes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
