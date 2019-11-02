/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import model.MyComponent;

/**
 *
 * @author Anh Hao
 */
public class JComboBoxBuilder extends JComponentBuilder{

    JComboBox<String> jcomboBox;

    public JComboBoxBuilder(MyComponent comp) {
        jcomboBox = new JComboBox<>();
        initAttributes(comp); 
    }
    
    @Override
    public JComponent build() {
        return this.jcomboBox;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.ITEM: {
                    String temp = attributes.get(key).toString();
                    String[] values = temp.split("\\#");
                    for(String value : values){
                        jcomboBox.addItem(value);
                    }
                }
                default: {
                    initJComponentAttributes(jcomboBox, key, comp);
                }
            }
        }
    }
    
}
