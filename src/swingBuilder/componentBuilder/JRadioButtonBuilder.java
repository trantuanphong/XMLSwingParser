/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import model.MyComponent;

/**
 *
 * @author Anh Hao
 */
public class JRadioButtonBuilder extends JComponentBuilder {

    private JRadioButton jradiobutton;

    public JRadioButtonBuilder(MyComponent comp) {
        jradiobutton = new JRadioButton();
        initAttributes(comp);
    }

    @Override
    public JRadioButton build() {
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
                case KeyWord.IS_SELECTED: {
                    if (attributes.get(key).equalsIgnoreCase("true")) {
                        jradiobutton.setSelected(true);
                    } else {
                        jradiobutton.setSelected(false);
                    }
                    break;
                }
                case KeyWord.GROUP: {
                    if (!buttonGroups.containsKey(attributes.get(key))) {
                        buttonGroups.put(attributes.get(key), new ButtonGroup());
                    }
                    buttonGroups.get(attributes.get(key)).add(jradiobutton);
                    break;
                }
                default: {
                    initJComponentAttributes(jradiobutton, key, comp);
                }
            }
        }
    }

}
