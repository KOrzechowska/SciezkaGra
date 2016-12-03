package com.company.logic;

public class Course {
    private int levelNumber = 1;
    private Object[] currentLevel;

    public int getLevelNumber() {
        return levelNumber;
    }

    public void advanceLevel() {
        levelNumber++;
    }

    public Object[] getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Object[] currentLevel) {
        this.currentLevel = currentLevel;
    }
}
