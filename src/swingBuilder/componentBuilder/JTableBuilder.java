/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.MyComponent;

/**
 *
 * @author Anh Hao
 */
public class JTableBuilder extends JComponentBuilder {

    private Vector column;
    private Vector data;
    private JTable jtable;

    public JTableBuilder(MyComponent comp) {
        jtable = new JTable();
        data = new Vector();
        column = new Vector();
        initAttributes(comp);
    }

    @Override
    public JScrollPane build() {
        jtable.setModel(new DefaultTableModel(data, column));
        return new JScrollPane(jtable);
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.COLUMN: {
                    String temp = attributes.get(key);
                    String[] values = temp.split("\\#");
                    for (String value : values) {
                        column.add(value);
                    }
                    break;
                }
                case KeyWord.DATA: {
                    String temp = attributes.get(key);
                    String[] values = temp.split("\\|");
                    for (String value : values) {
                        String[] rowDatas = value.split("\\#");
                        Vector tempData = new Vector();
                        for (String columnData : rowDatas) {
                            tempData.add(columnData);
                        }
                        data.add(tempData);
                    }
                    break;
                }
                default: {
                    initJComponentAttributes(jtable, key, comp);
                }
            }
        }
    }
}
