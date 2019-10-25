/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JTextField;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JTextfieldBuilder extends JComponentBuilder {

    private JTextField jTextfield;

    public JTextfieldBuilder(MyComponent comp) {
        jTextfield = new JTextField();
        initAttributes(comp);
    }

    @Override
    public JTextField build() {
        return this.jTextfield;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case "text": {
                    jTextfield.setText(attributes.get(key));
                    break;
                }
                case "col": {
                    jTextfield.setColumns(Integer.parseInt(attributes.get(key)));
                    break;
                }
            }
        }
    }

}
