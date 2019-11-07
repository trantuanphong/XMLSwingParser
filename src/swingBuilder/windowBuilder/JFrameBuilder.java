/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.windowBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.JFrame;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JFrameBuilder extends WindowBuilder {

    private JFrame jframe;

    public JFrameBuilder(MyComponent comp) {
        jframe = new JFrame();
        initAttributes(comp);
        addChildComponent(jframe, comp);
        jframe.pack();
    }

    @Override
    public JFrame build() {
        return jframe;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setVisible(true);
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.TITLE: {
                    jframe.setTitle(attributes.get(key));
                    break;
                }
                default: {
                    initComponentAttributes(jframe.getContentPane(), key, comp);
                }
            }
        }
    }

}
