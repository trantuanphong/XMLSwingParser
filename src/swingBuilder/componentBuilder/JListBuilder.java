/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.JList;
import model.MyComponent;

/**
 *
 * @author Anh Hao
 */
public class JListBuilder extends JComponentBuilder{

    private JList jlist; 

    public JListBuilder(MyComponent comp) {
        jlist = new JList();
        initAttributes(comp);
    }
    
    @Override
    public JList build() {
        return this.jlist;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.ITEM: {
                    String temp = attributes.get(key);
                    String[] values = temp.split("\\#");
                    jlist = new JList(values);
                    break;
                }
                default: {
                    initJComponentAttributes(jlist, key, comp);
                }
            }
        }
    }
    
}
