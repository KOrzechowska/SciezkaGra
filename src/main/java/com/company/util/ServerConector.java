package com.company.util;

import java.io.IOException;

/**
 * Created by mrgrinch on 22.01.17.
 */
public class ServerConector {
    public static String ip;
    public static String port;
    public static int zycia;
    public static int speed;
    public static String plansza;

    public static void setDefaultIp(){
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
         ip = propertiesReader.getPropertyValue("ip");

    }

    public static void setDefaultPort(){
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
        port = propertiesReader.getPropertyValue("port");

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public static int setConfig(String text, String text1) {
        ip = text;
        port = text1;
        try {
            zycia = Client.setInt(ip, port, Protocol.GETZYCIA);
            plansza = Client.setString(ip, port, Protocol.GETPLANSZAKLOCKOW);
            speed = Integer.parseInt(Client.setString(ip, port, Protocol.GETSPEED));
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 2;
        }
    }
}
