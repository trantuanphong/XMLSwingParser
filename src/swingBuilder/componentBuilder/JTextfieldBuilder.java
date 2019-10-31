/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.JTextField;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JTextfieldBuilder extends JComponentBuilder {

    private JTextField jtextfield;

    public JTextfieldBuilder(MyComponent comp) {
        jtextfield = new JTextField();
        initAttributes(comp);
    }

    @Override
    public JTextField build() {
        return this.jtextfield;
    }
    
    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.TEXT: {
                    jtextfield.setText(attributes.get(key));
                    break;
                }
                case KeyWord.LENGTH: {
                    jtextfield.setColumns(Integer.parseInt(attributes.get(key)));
                    break;
                }
                default: {
                    initJComponentAttributes(jtextfield, key, comp);
                }
            }
        }
    }

}
