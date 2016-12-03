package com.company.util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class PropertiesReader {

    Document doc;

    public PropertiesReader(String Filename) {
        try {
            //Get file from resources folder
            ClassLoader classLoader = PropertiesReader.class.getClassLoader();
            File fXmlFile = new File(classLoader.getResource(Filename).getFile());

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String propertyName) {

        NodeList nList = doc.getElementsByTagName(propertyName);
        String output = (nList.item(0) != null) ? nList.item(0).getTextContent() : null;
        return output;
    }

    public String getPropertyValue(String propertyName, int id) {

        NodeList nList = doc.getElementsByTagName(propertyName);
        // po wszystkich planszach
        String output = null;
        for(int x=0,size= nList.getLength(); x<size; x++) {
            if(Integer.valueOf(nList.item(x).getAttributes().getNamedItem("id").getNodeValue()) == id)
                output = nList.item(x).getTextContent();
        }
        return output;
    }
    
    public int getPropertyValueInt(String propertyName) {
        String returnValue = getPropertyValue(propertyName);
        return Integer.valueOf(returnValue);
    }
}
