package com.company.util;

import com.company.util.ImageUtil;

import javax.swing.*;

public class ButtonFactory {
    public static JButton createJButtonWithImageFile(String imageFileName) {
        ImageIcon gameIcon = ImageUtil.getImageIconFromFile(imageFileName);
        JButton gameButton = new JButton(gameIcon);
        gameButton.setFocusable(false);
        return gameButton;
    }

    public static JButton createJButtonWithName(String buttonName) {
        JButton gameButton = new JButton(buttonName);
        return gameButton;
    }

}
