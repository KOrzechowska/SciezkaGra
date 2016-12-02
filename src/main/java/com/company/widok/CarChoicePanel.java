package com.company.widok;

import com.company.Util.ImageUtil;

import javax.swing.*;

public class CarChoicePanel extends JPanel {
    public CarChoicePanel()
    {
        Icon auto1 = ImageUtil.getImageIconFromFile("auto1.jpeg");
        Icon auto2 = ImageUtil.getImageIconFromFile("auto2.jpeg");
        Icon auto3 = ImageUtil.getImageIconFromFile("auto3.jpeg");
        Object tablicaObrazowAut[] = {auto1, auto2, auto3};

        int resultvalue = JOptionPane.showOptionDialog(this, "Wybierz samochód którym chcesz jechać?", "Opcje",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tablicaObrazowAut, tablicaObrazowAut[0]);
        System.out.println(resultvalue);
    }
}
