package com.company.widok;

import com.company.logic.HighScores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kasia on 27.01.17.
 */
public class Top5Panel extends JPanel {

    public Top5Panel(){
        super();
        JFrame.setDefaultLookAndFeelDecorated(true);
        JTextArea textAreal = new JTextArea("TOP 5 WYNIKÓW", 5, 10);
        HighScores highScores = new HighScores();
        try {
            highScores.loadHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<String> columns = new ArrayList<>();
        columns.add("nick");
        columns.add("score");
        TableModel tableModel = new DefaultTableModel(highScores.getHighScoreList().toArray(new Object[][] {}), columns.toArray());
        JTable table = new JTable();
        JScrollPane spTable = new JScrollPane(table);
        JPanel panel = new JPanel();

        panel.add(textAreal);
        panel.add(spTable);
        add(panel);

        setVisible(true);

    }

}
