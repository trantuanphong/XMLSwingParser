/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javafx.scene.control.RadioButton;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import model.MyComponent;

/**
 *
 * @author Anh Hao
 */
public class JRadioButtonBuilder extends JComponentBuilder{
    
    JRadioButton jradiobutton;

    public JRadioButtonBuilder(MyComponent comp) {
        jradiobutton = new JRadioButton();
        initAttributes(comp);
    }

    @Override
    public JComponent build() {
        return this.jradiobutton;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.TEXT: {
                    jradiobutton.setText(attributes.get(key));
                    break;
                }
                case KeyWord.ISSELECTED: {
                    if(attributes.get(key).toString().equals("true")){
                        jradiobutton.setSelected(true);
                    }
                }
                default: {
                    initJComponentAttributes(jradiobutton, key, comp);
                }
            }
        }
    }
    
}
