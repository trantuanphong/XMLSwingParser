/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.JCheckBox;
import model.MyComponent;

/**
 *
 * @author Anh Hao
 */
public class JCheckBoxBuilder extends JComponentBuilder{
    
    private JCheckBox jcheckBox;

    public JCheckBoxBuilder(MyComponent comp) {
        jcheckBox = new JCheckBox();
        initAttributes(comp);
    }
    
    @Override
    public JCheckBox build() {
        return this.jcheckBox;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.TEXT: {
                    jcheckBox.setText(attributes.get(key));
                    break;
                }
                case KeyWord.IS_CHECKED: {
                    if (attributes.get(key).equalsIgnoreCase("true")) {
                        jcheckBox.setSelected(true);
                    } else {
                        jcheckBox.setSelected(false);
                    }
                    break;
                }
                default: {
                    initJComponentAttributes(jcheckBox, key, comp);
                }
            }
        }
    }
    
}
