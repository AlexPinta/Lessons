package ua.ap.Homework4.MVC;

import ua.ap.Homework4.Bug;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 07.05.15
 * Time: 6:05
 * @version: 1.0
 */
public class MyTableModel extends AbstractTableModel {
    private int columnCount;
    private String[] pListColumn;
    public ArrayList <Object[]> dataArrayList;

    public MyTableModel(String[] pListColumn) {
        this.pListColumn = new String[pListColumn.length+1];
        for (int i = 0; i < pListColumn.length; i++) {
            this.pListColumn[i] = pListColumn[i];
        }
        this.pListColumn[pListColumn.length] = "Object";

        this.columnCount = this.pListColumn.length;
        dataArrayList = new ArrayList<Object[]>();
        for (int i = 0; i < dataArrayList.size(); i++){
            dataArrayList.add(new String[columnCount]);
        }

    }

    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int i) {
        return pListColumn[i];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object value = dataArrayList.get(row)[col];
        return value;
    }

    public void addData(Object[] row) {
        Object[] newString = new String[columnCount];
        newString = row;
        dataArrayList.add(newString);
    }

    @Override
    public boolean isCellEditable(int i, int i2) {
        return true;
    }

    @Override
    public void setValueAt(Object o, int row, int column) {
        Bug objBug = (Bug)dataArrayList.get(row)[this.columnCount-1];

        if (getColumnName(column) == "Name"){
            objBug.setName((String) o);
        } else if (getColumnName(column) == "Color") {
            objBug.setColor((String) o);
        } else if (getColumnName(column) == "Age") {
            objBug.setAge(Integer.parseInt((String) o));
        } else if (getColumnName(column) == "Size") {
            objBug.setSize(Integer.parseInt((String) o));
        }
        dataArrayList.get(row)[column] = (String) o;

    }

}
