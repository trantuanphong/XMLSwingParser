/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.JLabel;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JLabelBuilder extends JComponentBuilder {
    private JLabel jlabel;
    
    public JLabelBuilder(MyComponent comp) {
        jlabel = new JLabel();
        initAttributes(comp);
    }
    
    @Override
    public JLabel build() {
        return this.jlabel;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.TEXT: {
                    jlabel.setText(attributes.get(key));
                    break;
                }
                default: {
                    jlabel = (JLabel) initJComponentAttributes(jlabel, 
                            key, attributes.get(key));
                }
            }
        }
    }
}
