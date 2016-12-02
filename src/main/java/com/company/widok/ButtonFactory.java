package com.company.widok;

import com.company.Util.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory {
    public static JButton createJButtonWithImageFile(String imageFileName) {
        ImageIcon gameIcon = ImageUtil.getImageIconFromFile(imageFileName);
        JButton gameButton = new JButton(gameIcon);
        gameButton.setFocusable(false);
        return gameButton;
    }
    public static JButton createJButtonWithName(String buttonName)
    {
        JButton gameButton = new JButton(buttonName);
        gameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return gameButton;
    }

}
