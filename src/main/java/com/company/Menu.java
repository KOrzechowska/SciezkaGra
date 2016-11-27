package com.company;

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
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame("Zasady gry");
            String text = "Zasady gry\n" +
                    "Na początku (poziom 1) trasa, po której porusza się gracz jest bez przeszkód. Pojazd w momencie startu znajduje się na środku ścieżki i porusza się ze stałą prędkością (wartości prędkości dla każdej planszy będzie określana w konfiguracji). Ścieżka składa się z pasów - najmniej dwa. Użytkownik może sterować ruchem pojazdu za pomocą strzałek: lewo, prawo - zmieniając pas po którym jedzie.  Z czasem ścieżka zmienia swój bieg - pojawiają się rozgałęzienia, skręty oraz nieregularne brzegi. Gracz ma ograniczoną liczbę pojazdów (żyć) - domyślnie 3 (parametr ten będzie pobierany z pliku konfiguracyjnego). Pojazd na swojej drodze może napotkać przeszkody, bonusy i nagrody jak: dodatkowe życie, odporność na przeszkody czy monety. Przeszkody niszczą pojazd i odbierają życie. W trakcie gry będzie mógł się pojawić bonus występujący w dwóch wersjach: automatyczne przejście na wyższy poziom oraz przenoszący na poziom niżej. Dodatkowe życie uzupełnia brakujące pojazdy. Odporność na przeszkody pozwala na przejechanie ścieżki bez zwracania uwagi na przeszkody - przeszkody znikają - nagroda ta nie trwa wiecznie a jedynie ustalony skończony czas od momentu zebrania. Monety - punkty w przeliczeniu 1:1 - jedna moneta jeden punkt. Najechanie na przeszkodę to nie jedyny sposób na stracenie życia, kolejny to wyjechanie poza brzegi ścieżki. Utrata życia prezentowana będzie w prawym górnym rogu poprzez znikające ikonki aut. Po utracie życia gra kontynuowana jest od miejsca wypadku. Wykorzystanie wszystkich żyć oznacza koniec gry - w tym momencie pojawi się okno umożliwiające zapis wyniku.\n" +
                    "Kolejne poziomy (plansze) różnią się prędkością ścieżki oraz skomplikowaniem trasy. Gracz wygrywa grę gdy przejdzie wszystkie poziomy. \n" +
                    "Ponadto przed rozpoczęciem gry użytkownik wybiera stopień trudności wpływający na częstotliwość przeszkód. \n" +
                    "Punkty będą liczone w następujący sposób:\n" +
                    "\n" +
                    "\n" +
                    "wynik = 1*liczbaZebranychMonet +2*zatrzymaneŻycia+stopieńTrudności*nrLevelu\n" +
                    "gdzie stopieńTrudności: łatwy=1; średni =2; trudny=3\n" +
                    "    ";
            JTextArea textAreal = new JTextArea(text, 5, 10);
            textAreal.setPreferredSize(new Dimension(500, 500));
            textAreal.setLineWrap(true);
            frame.add(textAreal);
            frame.pack();
            frame.setVisible(true);
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
