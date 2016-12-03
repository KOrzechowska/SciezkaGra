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
        assertEquals("30",speed);
       String doopa = pReader.getPropertyValue("doopa");
        assertNull(doopa);
        int speedInt = pReader.getPropertyValueInt("lifes");
        assertNotNull(pReader.getPropertyValue("plansza",1));
        assertNull(pReader.getPropertyValue("plansza",2));
        assertEquals(4,speedInt);
    }
}
