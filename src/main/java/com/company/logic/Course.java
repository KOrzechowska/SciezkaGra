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
    public void getPlansza(){
        /** pobranie planszy z xml*/
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
        String planszaStream = propertiesReader.getPropertyValue("plansza", levelNumber);
        planszaStream = new StringBuffer(planszaStream).reverse().toString();
        int i=0;
        for(int y=-10; y<10; y++)
            for (int x=0; x<10; x++)
            {
                int rodzajBloku = Integer.parseInt(planszaStream.substring(i, i + 1));
                if (rodzajBloku == 0) {
                    currentCourseBlocks.add(new BlockShoulder(x, y));
                    //System.out.println("pobocze:\t"+x+"\t"+y);
                    int maxX = x*Commons.blockSize + Commons.blockSize;
                    int minX = x*Commons.blockSize;
                    int maxY = (8-y)*Commons.blockSize + Commons.blockSize;
                    int minY = (8-y)*Commons.blockSize;
                }
                if (rodzajBloku == 1 || rodzajBloku == 7) {
                    currentCourseBlocks.add(new BlockCourse(x, y));
                    if(rodzajBloku ==7) {
                        //System.out.println("gracz:\t" + x + "\t" + y);
                        int maxX = x * Commons.blockSize + Commons.blockSize;
                        int minX = x * Commons.blockSize;
                        int maxY = (8-y)*Commons.blockSize + Commons.blockSize;
                        int minY = (8-y)*Commons.blockSize;
                    }
                }
                if( rodzajBloku == 2){
                    currentCourseBlocks.add(new BlockStone(x,y));
                    int maxX = x*Commons.blockSize + Commons.blockSize;
                    int minX = x*Commons.blockSize;
                    int maxY = (8-y)*Commons.blockSize + Commons.blockSize;
                    int minY = (8-y)*Commons.blockSize;
                }

                if ( rodzajBloku == 3)
                    currentCourseBlocks.add(new BlockCoin(x,y));
                if ( rodzajBloku == 4) {
                    currentCourseBlocks.add(new BlockHeart(x, y));
                }
                if ( rodzajBloku == 5) {
                    currentCourseBlocks.add(new BlockFinish(x, y));
                    System.out.println("META\t"+x+"\t"+y);
                }

                  i++;
            }

        getRodzajKlocka(4,5);
    }

    public Block getBlock(int x, int y){
        Block wynikowy = null;
        for(Block block : currentCourseBlocks){
            //if(block.getX() == 3 && block.getY() == 6)
            //if(block.isInRangeX(x) && block.isInRangeY(y)) {
            if(block.isInRange(x,y)){
                wynikowy = block;
                getRodzajKlocka(block.getX(),block.getY());
                //System.out.println(block.getY()+"\t"+block.getX()+" klocek");
            }
        }
        return wynikowy;
    }

    public Class<? extends Block> getRodzajKlocka(int xKlocka, int yKlocka){
        List<Block> blocks = new ArrayList<>();
        for(Block block : currentCourseBlocks){
            if(block.getY()==yKlocka && block.getX()== xKlocka){
                blocks.add(block);
            }
        }
        return blocks.get(0).getClass();
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
