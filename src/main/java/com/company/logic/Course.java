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
    private List<CourseBlock> currentCourseBlocks;

    public Course() {
        currentCourseBlocks = new ArrayList<CourseBlock>();
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
                currentCourseBlocks.add(new CourseBlock(x,y,rodzajBloku));
                  i++;
            }
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
    public List<CourseBlock> getCurrentCourseBlocks() {
        return currentCourseBlocks;
    }

    /**
     * ustaw listę klocków
     * @param currentCourseBlocks - definicja planszy
     */
    public void setCurrentCourseBlocks(List<CourseBlock> currentCourseBlocks) {
        this.currentCourseBlocks = currentCourseBlocks;
    }

    public void advanceCourse()
    {
        for (CourseBlock block : this.currentCourseBlocks)
        {
            block.advanceBlock();
        }
    }
}
