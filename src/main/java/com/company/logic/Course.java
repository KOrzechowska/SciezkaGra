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
    private int levelNumber = 1;
    private List<Block> currentCourseBlocks;
    private String planszaStream;

    public Course() {
        currentCourseBlocks = new ArrayList<Block>();
        getPlansza();
    }

    /**
     * funkcja czytająca definicję planszy z pliku properties
     * i zamieniająca ją na elementy planszy - obiekty klasy
     * CourseBlock
     */
    public void getPlansza() {
        /** pobranie planszy z xml*/
        if(Game.isOnline){
            ServerConector.setConfig(ServerConector.ip, ServerConector.port);
            planszaStream = ServerConector.plansza;
        }else{
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
         planszaStream = propertiesReader.getPropertyValue("plansza", levelNumber);
        }
        planszaStream = new StringBuffer(planszaStream).reverse().toString();
        int i = 0;
        for (int y = -10; y < 10; y++)
            for (int x = 0; x < 10; x++) {
                int rodzajBloku = Integer.parseInt(planszaStream.substring(i, i + 1));
                if (rodzajBloku == 0) {
                    currentCourseBlocks.add(new BlockShoulder(x, y));
                }
                if (rodzajBloku == 1 || rodzajBloku == 7) {
                    currentCourseBlocks.add(new BlockCourse(x, y));
                    if (rodzajBloku == 7) {
                    }
                }
                if (rodzajBloku == 2) {
                    currentCourseBlocks.add(new BlockStone(x, y));
                }

                if (rodzajBloku == 3)
                    currentCourseBlocks.add(new BlockCoin(x, y));
                if (rodzajBloku == 4) {
                    currentCourseBlocks.add(new BlockHeart(x, y));
                }
                if (rodzajBloku == 5) {
                    currentCourseBlocks.add(new BlockFinish(x, y));
                    System.out.println("META\t" + x + "\t" + y);
                }
                if (rodzajBloku == 6) {
                    currentCourseBlocks.add(new BlockPowerUp(x, y));
                }

                i++;
            }

        getRodzajKlocka(4, 5);
    }

    public Block getBlock(int x, int y) {
        Block wynikowy = null;
        for (Block block : currentCourseBlocks) {
            if (block.isInRange(x, y)) {
                wynikowy = block;
                getRodzajKlocka(block.getX(), block.getY());
            }
        }
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
