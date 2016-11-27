package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mrgrinch on 12.11.16.
 */
public class Start extends JFrame implements ActionListener
{
    JButton ok;
    JLabel Podajnick;
    JTextField nick;
    String nazwa= "";

    public Start()
    {
        setTitle("Podaj Nick");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//zamykamy aplikacje gry klikniemy na przycisk
        setLocationRelativeTo(null);
        setLayout(null);
        Podajnick= new JLabel("Podaj Nick :");
        ok = new JButton("Ok");
        nick= new JTextField();
        ok.setBounds(150,400,200,50);
        Podajnick.setBounds(150,150,200,50);
        nick.setBounds(150,250,200,50);
        ok.addActionListener(this);
        add(ok);
        add(Podajnick);
        add(nick);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
            Object zrodlo= e.getSource();
            if (zrodlo== ok)
            {
                nazwa=nick.getText();

            }
        /*if else(zrodlo==start)
        {

        }
        if else(zrodlo==scianachwaly)
        {

        }
        if else(zrodlo==reguly)
        {

        }
        if else(zrodlo==opcje)
        {

        }*/
    }


    public static void main(String[] args)
    {
        Start appMenu=new Start();
        appMenu.setVisible(true);
    }
}