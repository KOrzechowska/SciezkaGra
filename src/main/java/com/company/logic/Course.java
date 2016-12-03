package com.company.logic;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int levelNumber = 1;
    private List<CourseBlock> currentCourseBlocks;

    public Course() {
        currentCourseBlocks = new ArrayList<CourseBlock>();
        currentCourseBlocks.add(new CourseBlock(0,0));
        currentCourseBlocks.add(new CourseBlock(1,0));
        currentCourseBlocks.add(new CourseBlock(2,0));
        currentCourseBlocks.add(new CourseBlock(2,1));
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
