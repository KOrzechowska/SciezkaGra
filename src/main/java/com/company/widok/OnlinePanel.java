package com.company.widok;

import com.company.Game;
import com.company.util.ServerConector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mrgrinch on 22.01.17.
 */
public class OnlinePanel extends JPanel {

    public OnlinePanel(){
        JPanel all = new JPanel();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel center = new JPanel();
        JPanel buttons = new JPanel();
        JPanel centerNorth = new JPanel();
        JPanel centerCenter = new JPanel();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        all.setLayout(new BorderLayout());
        south.setLayout(new BorderLayout());
        center.setLayout(new BorderLayout());
        centerCenter.setLayout(new GridLayout(2, 2));
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel3.setLayout(new BorderLayout());
        panel4.setLayout(new BorderLayout());
        final JLabel status = new JLabel();
        final JLabel label3 = new JLabel("Serwer_IP" + ":   ");
        final JLabel label4 = new JLabel("Port" + ":   ");
        label3.setFont(label3.getFont().deriveFont((float) 12));
        label4.setFont(label4.getFont().deriveFont((float) 12));
        status.setFont(status.getFont().deriveFont((float) 11));
        label3.setForeground(Color.black);
        label4.setForeground(Color.black);
        /**ustawienie napisów na polach jako połączenie z lokalnym serwerem*/
        ServerConector.setDefaultIp();
        ServerConector.setDefaultPort();
        final JTextField ip = new JTextField(ServerConector.ip);  //textowe pole, domyślnie napisane
        final JTextField port = new JTextField(ServerConector.port); // localhost i 1000 (port)
        /**guzik start*/
        final JButton start = new JButton("start");
        /**guzik exit*/
        final JButton exit = new JButton("exit");
        start.setPreferredSize(new Dimension(85, 25));
        exit.setPreferredSize(new Dimension(85, 25));
        ip.setPreferredSize(new Dimension(0, 25));
        port.setPreferredSize(new Dimension(0,25));
        ip.setColumns(12);
        port.setColumns(12);
        start.setFocusable(false);
        exit.setFocusable(false);

        all.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        north.setBorder(new EmptyBorder(10, 10, 10, 10));
        center.setBorder(new EmptyBorder(10, 10, 10, 10));
        centerNorth.setBorder(new EmptyBorder(0, 0, 5, 0));

        panel1.add(label3, BorderLayout.EAST);
        panel2.add(ip, BorderLayout.WEST);
        panel3.add(label4, BorderLayout.EAST);
        panel4.add(port, BorderLayout.WEST);

        centerNorth.add(status);

        centerCenter.add(panel1);
        centerCenter.add(panel2);
        centerCenter.add(panel3);
        centerCenter.add(panel4);

        buttons.add(exit);
        buttons.add(start);

        center.add(centerNorth, BorderLayout.NORTH);
        center.add(centerCenter, BorderLayout.CENTER);

        south.add(buttons, BorderLayout.EAST);

        all.add(north, BorderLayout.NORTH);
        all.add(center, BorderLayout.CENTER);
        all.add(south, BorderLayout.SOUTH);

        add(all);
        /******************************************************************************************/
        /**obsługa guzika start*/
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int choice = ServerConector.setConfig(ip.getText(), port.getText());
                /**połaczono z serwerem*/
                if (choice == 1)
                {Game.isOnline=true;
                    setVisible(false);
                    Game.getGame().getPlayer().setNrOfLifes(ServerConector.zycia);
                    Game.getGame().getPlayer().setMaxNrOfLifes(ServerConector.zycia);
                    Game.getGame().getCourse().setPlanszaStream(ServerConector.plansza);
                    Game.getGame().getCourse().getCurrentCourseBlocks().clear();
                    Game.getGame().getCourse().getPlansza();
                    Game.getGame().setCurrentActivePanel(new MenuPanel());
                    }
                /**nie połączono z serwerem*/
                if (choice == 2)

                {Game.isOnline=false;
                    setVisible(false);
                    Game.getGame().setCurrentActivePanel(new MenuPanel());
                }

            }
        });
        /**obsługa guzika exit*/
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Game.getGame().setCurrentActivePanel(new MenuPanel());
            }
        });
    }
}
