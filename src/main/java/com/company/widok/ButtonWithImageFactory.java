package com.company.widok;

import com.company.Util.ImageUtil;

import javax.swing.*;

public class ButtonWithImageFactory {
    public static JButton getJButtonWithImageFile(String imageFileName) {
        ImageIcon GameIcon = ImageUtil.getImageIconFromFile(imageFileName);
        JButton GameButton = new JButton(GameIcon);
        GameButton.setFocusable(false);
        return GameButton;
    }

}
