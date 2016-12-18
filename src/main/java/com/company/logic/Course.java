package com.company.logic;

import com.company.util.PropertiesReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa ścieżka - zawiera informację o położeniu
 * wszystkich klocków składajacych się na planszę
 */
public class Course {
    private int levelNumber = 1;
    private List<Block> currentCourseBlocks;

    public Course() {
        currentCourseBlocks = new ArrayList<Block>();
        getPlansza();
    }

    /**
     * funkcja czytająca definicję planszy z pliku properties
     * i zamieniająca ją na elementy planszy - obiekty klasy
     * CourseBlock
     */
    private void getPlansza(){
        /** pobranie planszy z xml*/
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
        String planszaStream = propertiesReader.getPropertyValue("plansza", 1);
        planszaStream = new StringBuffer(planszaStream).reverse().toString();
        int i=0;
        for(int y=-10; y<10; y++)
            for (int x=0; x<10; x++)
            {
                int rodzajBloku = Integer.parseInt(planszaStream.substring(i, i + 1));
                if (rodzajBloku == 0)
                    currentCourseBlocks.add(new BlockShoulder(x,y));
                if (rodzajBloku == 1 || rodzajBloku == 7)
                    currentCourseBlocks.add(new BlockCourse(x,y));
                if( rodzajBloku == 2)
                    currentCourseBlocks.add(new BlockStone(x,y));
                  i++;
            }
    }

    public Block getBlock(int x, int y){
        Block wynikowy = null;
        for(Block block : currentCourseBlocks){

            if(block.isInRangeX(x) && block.isInRangeY(y)) {
                wynikowy = block;
                System.out.println(block.getY()+" klocek");
            }
        }
        return wynikowy;
    }

    /**
     * funkcja zwarcający aktulany poziom
     * @return poziom gry
     */
    public int getLevelNumber() {
        return levelNumber;
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
     * @return lista klocków
     */
    public List<Block> getCurrentCourseBlocks() {
        return currentCourseBlocks;
    }

    /**
     * ustaw listę klocków
     * @param currentBlocks - definicja planszy
     */
    public void setCurrentCourseBlocks(List<Block> currentBlocks) {
        this.currentCourseBlocks = currentBlocks;
    }

    public void advanceCourse()
    {
        for (Block block : this.currentCourseBlocks)
        {
            block.advanceBlock();
        }
    }
}
