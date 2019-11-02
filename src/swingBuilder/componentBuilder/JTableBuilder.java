/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.MyComponent;

/**
 *
 * @author Anh Hao
 */
public class JTableBuilder extends JComponentBuilder{

    JTable jtable;

    public JTableBuilder(MyComponent comp) {
        jtable = new JTable();
        initAttributes(comp);
    }
    
    @Override
    public JComponent build() {
        return this.jtable;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        Vector column = new Vector();
        Vector data = new Vector();
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.COLUMN: {
                    String temp = attributes.get(key).toString();
                    String[] values = temp.split("\\#");
                    for(String value : values){
                        column.add(value);
                    }
                }
                case KeyWord.DATA: {
                    String temp = attributes.get(key).toString();
                    String[] values = temp.split("\\|");
                    for(String value : values){
                        String[] rowDatas = value.split("\\#");
                        Vector tempData = new Vector();
                        for(String columnData : rowDatas){
                            tempData.add(columnData);
                        }
                    }
                    jtable.setModel(new DefaultTableModel(data, column));
                }
                default: {
                    initJComponentAttributes(jtable, key, comp);
                }
            }
        }
    }
    
}
