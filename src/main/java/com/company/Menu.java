package com.company;

import com.company.przyklady.ZasadyGry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 * Created by mrgrinch on 12.11.16.
 */
public class Menu extends JFrame implements ActionListener
{
    JButton wyjscie,start, reguly, scianachwaly, opcje;

    public Menu()
    {
        setTitle("Sciezka");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//zamykamy aplikacje gry klikniemy na przycisk
        setLocationRelativeTo(null);
        setLayout(null);
        start = new JButton("Start");
        scianachwaly = new JButton("ScianaChwaly");
        reguly =new JButton("Reguly");
        wyjscie= new JButton("Wyjscie");
        opcje= new JButton("Opcje");
        start.setBounds(150,100,200,50);
        scianachwaly.setBounds(150,150,200,50);
        reguly.setBounds(150,200,200,50);
        opcje.setBounds(150,250,200,50);
        wyjscie.setBounds(150,300,200,50);
        wyjscie.addActionListener(this);
        start.addActionListener(this);
        opcje.addActionListener(this);
        reguly.addActionListener(this);
        add(start);
        add(scianachwaly);
        add(reguly);
        add(opcje);
        add(wyjscie);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo= e.getSource();
        if (zrodlo== start)
        {
            Object result = JOptionPane.showInputDialog(this,"Podaj Nick :");
            System.out.println("start" + result);
            if(result!=null)
            {
                JDialog.setDefaultLookAndFeelDecorated(true);
                Object[] selectionValues = { "Latwy", "Sredni", "Trudny" };
                String initialSelection = "Latwy";
                Object selection = JOptionPane.showInputDialog(this, "Wybierz poziom trudnosci :",
                        "Poziom Trudnosci", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
                System.out.println(selection);
            }

        }
        if (zrodlo==wyjscie)
        {
            dispose();
        }
      /*  if else(zrodlo==scianachwaly)
        {

       */
        if(zrodlo==reguly)
        {

            ZasadyGry zGry= new ZasadyGry();
        }
        if (zrodlo==opcje)
        {
            Icon auto1 = new ImageIcon(getClass().getClassLoader().getResource("auto1.jpeg"));
            Icon auto2 = new ImageIcon(getClass().getClassLoader().getResource("auto2.jpeg"));
            Icon auto3 = new ImageIcon(getClass().getClassLoader().getResource("auto3.jpeg"));
            Object tablicaObrazowAut[] = {auto1 ,auto2, auto3};

            int resultvalue = JOptionPane.showOptionDialog(this, "Wybierz samochód którym chcesz jechać?", "Opcje",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tablicaObrazowAut, tablicaObrazowAut[0]);
            System.out.println(resultvalue);
        }
    }


    public static void main(String[] args)
    {
        Menu appMenu=new Menu();
        appMenu.setVisible(true);
    }
}
