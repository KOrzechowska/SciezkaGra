package com.company.logic;

import com.company.util.ImageUtil;

import javax.swing.*;

public class BlockCourse extends Block {
    public BlockCourse(int x, int y) {
        super(x,y);
        this.blockImage = ImageUtil.getImageIconFromFile("droga.jpeg");
    }

}
