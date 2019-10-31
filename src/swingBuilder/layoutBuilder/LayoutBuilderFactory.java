/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.layoutBuilder;

import common.KeyWord;
import java.awt.Container;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class LayoutBuilderFactory {

    private static LayoutBuilderFactory instance;

    private LayoutBuilderFactory() {
    }

    public static LayoutBuilderFactory getInstance() {
        if (instance == null) {
            instance = new LayoutBuilderFactory();
        }
        return instance;
    }
    
    public LayoutBuilder getLayoutBuilder(Container container, 
            MyComponent comp, String layout) {
        switch (layout) {
            case KeyWord.BOX_LAYOUT: {
                return new BoxLayoutBuilder(container, comp);
            }
            default: {
                return new FlowLayoutBuilder(comp);
            }
        }
    }
}
