package com.company.util;

import com.company.util.ImageUtil;

import javax.swing.*;

/**
 * tworzenie przycisku z napisem lub obrazkiem
 */
public class ButtonFactory {
    /**
     * funkcja do tworzenia przycisku
     * @param imageFileName- nazwa pliku obrazka dla przycisku
     * @return JButton w postaci obrazka
     */
    public static JButton createJButtonWithImageFile(String imageFileName) {
        ImageIcon gameIcon = ImageUtil.getImageIconFromFile(imageFileName);
        JButton gameButton = new JButton(gameIcon);
        gameButton.setFocusable(false);
        return gameButton;
    }

    /**
     * funkcja do tworzenia przycisku
     * @param buttonName- nazwa na przycisku
     * @return przycisk z napisem
     */
    public static JButton createJButtonWithName(String buttonName) {
        JButton gameButton = new JButton(buttonName);
        return gameButton;
    }

}
