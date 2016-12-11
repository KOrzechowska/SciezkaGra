package com.company.logic;

import com.company.util.PropertiesReader;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int levelNumber = 1;
    private List<CourseBlock> currentCourseBlocks;

    public Course() {
        currentCourseBlocks = new ArrayList<CourseBlock>();
       /* currentCourseBlocks.add(new CourseBlock(0,0));
        currentCourseBlocks.add(new CourseBlock(1,0));
        currentCourseBlocks.add(new CourseBlock(2,0));
        currentCourseBlocks.add(new CourseBlock(2,1));*/
        getPlansza();
    }

    private void getPlansza(){
        /** pobranie planszy z xml*/
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
        String planszaStream = propertiesReader.getPropertyValue("plansza", 1);
        int i=0;
        for(int y=9; y>-1; y--)
            for (int x=0; x<10; x++)
            {
                int rodzajBloku = Integer.parseInt(planszaStream.substring(i, i + 1));
                currentCourseBlocks.add(new CourseBlock(x,y,rodzajBloku));
                  i++;
            }
    }
    public int getLevelNumber() {
        return levelNumber;
    }

    public void advanceLevel() {
        levelNumber++;
    }

    public List<CourseBlock> getCurrentCourseBlocks() {
        return currentCourseBlocks;
    }

    public void setCurrentCourseBlocks(List<CourseBlock> currentCourseBlocks) {
        this.currentCourseBlocks = currentCourseBlocks;
    }
}
