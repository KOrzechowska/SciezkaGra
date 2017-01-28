package orzechowski.piotr;

import com.company.logic.HighScores;
import com.company.util.PropertiesReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Unit test for simple MainMenu.
 */
public class AppTest {
    @Test
    public void testApp() {
        PropertiesReader pReader = new PropertiesReader("properties.xml");
        String speed = pReader.getPropertyValue("speed");
        //assertEquals("30",speed);
        assertEquals("30", pReader.getPropertyValue("speed",2));
        assertNotNull(pReader.getPropertyValueInt2("speed",2));
       String doopa = pReader.getPropertyValue("doopa");
        assertNull(doopa);
        int speedInt = pReader.getPropertyValueInt("lifes");
        assertNotNull(pReader.getPropertyValue("plansza",1));
        assertNotNull(pReader.getPropertyValue("plansza",2));
        assertEquals(4,speedInt);
    }

    @Test
    public void testHighScores() {
        HighScores highScores=new HighScores();
        highScores.addToHighScoreList("john",0);
        assertEquals(highScores.getHighScoreList().get(0).getNick(),"john");
        assertEquals(highScores.getHighScoreList().get(0).getScore(),new Integer(0));
        try {
            highScores.saveHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        }
        highScores=new HighScores();
        try {
            highScores.loadHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(highScores.getHighScoreList().get(0).getNick(),"john");
        assertEquals(highScores.getHighScoreList().get(0).getScore(),new Integer(0));
    }
}
