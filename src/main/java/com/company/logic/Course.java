package com.company.logic;

import com.company.Game;
import com.company.util.Client;
import com.company.util.PropertiesReader;
import com.company.util.ServerConector;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa ścieżka - zawiera informację o położeniu
 * wszystkich klocków składajacych się na planszę
 */
public class Course {
    /**poczatkowy poziom*/
    private int levelNumber = 1;
    /**lista klockow*/
    private List<Block> currentCourseBlocks;
    /**ciag znakow planszy*/
    private String planszaStream;
    /**konnstuktor klasy Course*/
    public Course() {
        /**stworzenie nowej listy klockow*/
        currentCourseBlocks = new ArrayList<Block>();
        /**pobieranie planszy*/
        getPlansza();
    }

    /**
     * funkcja czytająca definicję planszy z pliku properties
     * i zamieniająca ją na elementy planszy - obiekty klasy
     * CourseBlock
     */
    public void getPlansza() {
        /** sprawdzamy czy gramy online jezeli tak */
        if (Game.isOnline) {
            /**ustawiamy server na ktorym chcemy grac podajac ip oraz port*/
            ServerConector.setConfig(ServerConector.ip, ServerConector.port);
            /**czytamy ciag znakow planszy z servera*/
            planszaStream = ServerConector.plansza;
            /**w przeciwnym razie z pliku properties*/
        } else {
            PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
            /**pobieramy ciag znakow opisujacy plansze z pliku properties plansza-tag  levelNumber- id*/
            planszaStream = propertiesReader.getPropertyValue("plansza", levelNumber);
        }
        /**odwracamy naz ciag znakow pobrany z servera albo pliku */
        planszaStream = new StringBuffer(planszaStream).reverse().toString();
        int i = 0;
        /**okreslenie rozmiaru planszy*/
        for (int y = -10; y < 10; y++)
            for (int x = 0; x < 10; x++) {
                /**rodzaj bloku rodzaje bloku sa okreslone przez cyfry*/
                int rodzajBloku = Integer.parseInt(planszaStream.substring(i, i + 1));
                /**jezeli 0 to obecny klocek bedzie poboczem*/
                if (rodzajBloku == 0) {
                    currentCourseBlocks.add(new BlockShoulder(x, y));
                }
                /**jezeli 1 lub 7 obecny blok bedzie klockiem sciezki 7 oznacza rowniez poczatkowe ustawienie gracza*/
                if (rodzajBloku == 1 || rodzajBloku == 7) {
                    currentCourseBlocks.add(new BlockCourse(x, y));
                    if (rodzajBloku == 7) {
                    }
                }
                /**jezeli 2 obecny blok bedzie kamieniem(przeszkoda)*/
                if (rodzajBloku == 2) {
                    currentCourseBlocks.add(new BlockStone(x, y));
                }
                /**jezeli 3 obecny klocek bedzie moneta*/
                if (rodzajBloku == 3)
                    currentCourseBlocks.add(new BlockCoin(x, y));
                /**jezeli 4 obecny klocek bedzie sercem*/
                if (rodzajBloku == 4) {
                    currentCourseBlocks.add(new BlockHeart(x, y));
                }
                /**jezeli 5 blok bedzie meta*/
                if (rodzajBloku == 5) {
                    currentCourseBlocks.add(new BlockFinish(x, y));
                }
                /**jezeli 6 blok bedzie wzmocnieniem*/
                if (rodzajBloku == 6) {
                    currentCourseBlocks.add(new BlockPowerUp(x, y));
                }

                i++;
            }
    }
    /** funkcja pobiera blok o wspolrzednych x, y */
    public Block getBlock(int x, int y) {
        /**stworzenie bloku wynikowego przypisanie mu wartosci null*/
        Block wynikowy = null;
        /**petla wyszukujaca chcianego bloku*/
        for (Block block : currentCourseBlocks) {
            if (block.isInRange(x, y)) {
                wynikowy = block;

            }
        }
        /**zwraca blok ktorego szukamy*/
        return wynikowy;
    }

    public Class<? extends Block> getRodzajKlocka(int xKlocka, int yKlocka) {
        List<Block> blocks = new ArrayList<>();
        for (Block block : currentCourseBlocks) {
            if (block.getY() == yKlocka && block.getX() == xKlocka) {
                blocks.add(block);
            }
        }
        return blocks.get(0).getClass();
    }

    /**
     * funkcja zwarcający aktulany poziom
     *
     * @return poziom gry
     */
    public int getLevelNumber() {
        return levelNumber;
    }

    /**
     * funkcja ustawiajaca poziom gry
     * @param levelNumber poziom gry
     */
    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    /**
     * funkcja zwiększająca level o jeden
     * - przejście do kolejnego poziomu gry
     */
    public void advanceLevel() {
        levelNumber++;
    }

    /**
     * funkcja zwracająca listę klocków
     * czyli definicję planszy już w postaci obiektów
     *
     * @return lista klocków
     */
    public List<Block> getCurrentCourseBlocks() {
        return currentCourseBlocks;
    }

    /**
     * ustaw listę klocków
     *
     * @param currentBlocks - definicja planszy
     */
    public void setCurrentCourseBlocks(List<Block> currentBlocks) {
        this.currentCourseBlocks = currentBlocks;
    }

    public void advanceCourse() {
        for (Block block : this.currentCourseBlocks) {
            block.advanceBlock();
        }
    }

    public String getPlanszaStream() {
        return planszaStream;
    }

    public void setPlanszaStream(String planszaStream) {
        this.planszaStream = planszaStream;
    }
}
