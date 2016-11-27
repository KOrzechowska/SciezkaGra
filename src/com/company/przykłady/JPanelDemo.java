package com.company.przykłady;

import java.awt.*;
import javax.swing.*;

public class JPanelDemo extends JFrame
{
	/**
     * Konstruktor
     */
	public JPanelDemo()
	{
		JPanel mainPanel=new JPanel();

		mainPanel.setBackground(Color.YELLOW);
		mainPanel.setBorder(BorderFactory.createTitledBorder("Border"));
		mainPanel.setPreferredSize(new Dimension(300,300));

		this.getContentPane().add(mainPanel);
        
		this.setTitle("JPanelDemo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				JPanelDemo app = new JPanelDemo();
				app.setVisible(true);
			}
	    });
	}
}