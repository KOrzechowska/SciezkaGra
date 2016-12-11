package com.company.widok;

import com.company.Game;
import com.company.util.ButtonFactory;

import javax.swing.*;
import java.awt.*;

/**
 * klasa dziedzicząca po JPanel
 * zawiera okno tekstowe w którym są zawarte reguły gry
 */
public class ZasadyGry extends JPanel{
    public ZasadyGry()
    {
        super();
        JFrame.setDefaultLookAndFeelDecorated(true);

        JButton previousButton = ButtonFactory.createJButtonWithName("Wróć do menu");
        previousButton.addActionListener(e -> Game.getGame().setCurrentActivePanel(new MenuPanel()));

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
        textAreal.setEditable(false);
        textAreal.setLineWrap(true);
        add(previousButton);
        add(textAreal);
        setVisible(true);
    }
}
