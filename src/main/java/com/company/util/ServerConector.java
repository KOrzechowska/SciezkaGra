package com.company.util;

import javax.swing.*;
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
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            /** nie łączymy online*/
            if (JOptionPane.showConfirmDialog(null, "Server sent incorrect data!" + "\n"
                            + "Czy chcesz zagrać offline?", "Error!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE) == 1)
            {
                return 0;}
            else {
                return 2;
            }
        }
        catch (IOException e) {
            if (e.getMessage().equals("server error")) {
                if (JOptionPane.showConfirmDialog(null, "Server sent error message!" + "\n"
                                + "Czy chcesz zagrać offline?", "Error!",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 1)
                    return 0;
                else {
                    return 2;
                }
            }
            if (JOptionPane.showConfirmDialog(null, "Connection with server could not be established!" + "\n"
                            +"Czy chcesz zagrać offline?", "Error!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE) == 1)
                return 0;
            else {
                return 2;
            }
        }
    }
}
