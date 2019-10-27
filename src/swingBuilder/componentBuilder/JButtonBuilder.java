/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.JButton;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JButtonBuilder extends JComponentBuilder {
    private JButton jbutton;
    
    public JButtonBuilder(MyComponent comp) {
       jbutton = new JButton();
       initAttributes(comp);
    }

    @Override
    public JButton build() {
        return this.jbutton;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.TEXT: {
                    jbutton.setText(attributes.get(key));
                    break;
                }
                default: {
                    jbutton = (JButton) initJComponentAttributes(jbutton, 
                            key, attributes.get(key));
                }
            }
        }
    }
    
}
