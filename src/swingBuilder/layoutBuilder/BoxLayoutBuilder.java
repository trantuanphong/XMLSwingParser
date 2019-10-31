/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.layoutBuilder;

import common.KeyWord;
import java.awt.Container;
import java.util.HashMap;
import javax.swing.BoxLayout;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class BoxLayoutBuilder extends LayoutBuilder {
    
    private Container container;
    private int axis;
    public BoxLayoutBuilder(Container container, MyComponent comp) {
        this.container = container;
        this.axis = BoxLayout.Y_AXIS;
        initAttributes(comp);
    }

    @Override
    public BoxLayout build() {
        return new BoxLayout(container, axis);
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.AXIS: {
                    axis = getAxis(attributes.get(key));
                    break;
                }
            }
        }
    }
    
    private int getAxis(String axis) {
        switch (axis) {
            case KeyWord.X_AXIS: {
                return BoxLayout.X_AXIS;
            }
            default: {
                return BoxLayout.Y_AXIS;
            }
        }
    }
}
