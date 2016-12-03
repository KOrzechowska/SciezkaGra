package orzechowski.piotr;

import com.company.util.PropertiesReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple MainMenu.
 */
public class AppTest {
    @Test
    public void testApp() {
        PropertiesReader pReader = new PropertiesReader("properties.xml");
        String speed = pReader.getPropertyValue("lifes");
        assertEquals("3",speed);
       String doopa = pReader.getPropertyValue("doopa");
        assertNull(doopa);
        int speedInt = pReader.getPropertyValueInt("lifes");
        assertEquals(3,speedInt);
    }
}
