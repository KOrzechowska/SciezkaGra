package orzechowski.piotr;

import com.company.util.PropertiesReader;
import org.junit.Test;

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
}
