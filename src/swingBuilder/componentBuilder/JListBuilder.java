/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JList;
import model.MyComponent;

/**
 *
 * @author Anh Hao
 */
public class JListBuilder extends JComponentBuilder{

    JList jlist; 

    public JListBuilder(MyComponent comp) {
        jlist = new JList();
        initAttributes(comp);
    }
    
    @Override
    public JComponent build() {
        return this.jlist;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.ITEM: {
                    String temp = attributes.get(key).toString();
                    String[] values = temp.split("\\#");
//                    for(String value : values){
//                        jlist.
//                    }
                    jlist = new JList(values);
                }
                default: {
                    initJComponentAttributes(jlist, key, comp);
                }
            }
        }
    }
    
}
