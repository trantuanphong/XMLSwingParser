/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import java.util.HashMap;
import javax.swing.JPanel;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JPanelBuilder extends JComponentBuilder {

    private JPanel jpanel;

    public JPanelBuilder(MyComponent comp) {
        jpanel = new JPanel();
        initAttributes(comp);
        jpanel = (JPanel) addChildComponent(jpanel, comp);
    }

    @Override
    public JPanel build() {
        return this.jpanel;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                default: {
                    initJComponentAttributes(jpanel, key, comp);
                }
            }
        }
    }
}
