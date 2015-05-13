package ua.ap.Homework4.MVC;

import ua.ap.Homework4.Bug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 07.05.15
 * Time: 5:32
 * @version: 1.0
 */
public class ViewModel {
    private  MyTableModel locTableModel;
    private JTable mainTable;
    public ViewModel() {


        JFrame mainFrame = new JFrame("Форма для заполнения жуков");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridBagLayout());

        String[] columnNames = {"Name", "Color", "Age", "Size"};

        locTableModel = new MyTableModel(columnNames);

        mainTable = new JTable(locTableModel);
        mainTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        mainTable.setFillsViewportHeight(true);

        mainTable.createDefaultColumnsFromModel();
        mainTable.setAutoCreateColumnsFromModel(true);
        mainTable.setShowHorizontalLines(true);
        mainTable.setShowVerticalLines(true);
        mainTable.setShowGrid(true);

        JScrollPane scrollPane = new JScrollPane(mainTable);

        JButton addButton = new JButton("Add");
        JButton sortButton = new JButton("Sort");
        ActionListener addActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent pActionEvent) {
                Object[] locString = {"","","","", new Bug("", "", -1, 0)};
                locTableModel.addData(locString);
            }
        };
        addButton.addActionListener(addActionListener);
        ActionListener sortActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent pActionEvent) {
                Bug[] locBugs = new Bug[locTableModel.dataArrayList.size()];
                for (int i = 0; i < locTableModel.dataArrayList.size(); i++) {
                    locBugs[i] = (Bug) locTableModel.dataArrayList.get(i)[locTableModel.getColumnCount()-1];
                }
                Arrays.sort(locBugs);
                locTableModel.dataArrayList.clear();
                for (int i = 0; i < locBugs.length; i++) {
                    Object[] locObjects = new Object[locTableModel.getColumnCount()];
                    locObjects[0] = locBugs[i].getName();
                    locObjects[1] = locBugs[i].getColor();
                    locObjects[2] = locBugs[i].getAge();
                    locObjects[3] = locBugs[i].getSize();
                    locObjects[4] = locBugs[i];
                    locTableModel.dataArrayList.add(locObjects);

                }
            }
        };
        sortButton.addActionListener(sortActionListener);

        mainFrame.add(scrollPane, new GridBagConstraints(0, 0, 6, 2, 1, 1, GridBagConstraints.NORTH,
                        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        mainFrame.add(addButton,  new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.BASELINE,
                GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        mainFrame.add(sortButton,  new GridBagConstraints(3, 2, 2, 1, 1, 1, GridBagConstraints.BASELINE,
                GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        mainFrame.setSize(300, 300);
        //mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

}
