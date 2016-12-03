package com.company.widok;

import com.company.util.KeyboardHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayingField extends JPanel implements ActionListener {

   public PlayingField()
   {
       addKeyListener(new KeyboardHandler());
       setBackground(Color.black);
       setFocusable(true);

   }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
