/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder;

import common.KeyWord;
import swingBuilder.windowBuilder.*;
import swingBuilder.componentBuilder.*;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class ComponentBuilderFactory {
    
    private static ComponentBuilderFactory instance;
    
    private ComponentBuilderFactory() {
    }

    public static ComponentBuilderFactory getInstance() {
        if (instance == null) {
            instance = new ComponentBuilderFactory();
        }
        return instance;
    }
    
    public WindowBuilder getWindowBuilder(MyComponent comp) {
        switch (comp.getName()) {
            case KeyWord.JFRAME: {
                return new JFrameBuilder(comp);
            }
            case KeyWord.JDIALOG: {
                return new JDialogBuilder(comp);
            }
        }
        System.out.println("Null Window Builder");
        return null;
    }
    
    public JComponentBuilder getJComponentBuilder(MyComponent comp) {
        switch (comp.getName()) {
            case KeyWord.JLABEL: {
                return new JLabelBuilder(comp);
            }
            case KeyWord.JBUTTON: {
                return new JButtonBuilder(comp);
            }
            case KeyWord.JTEXTFIELD: {
                return new JTextfieldBuilder(comp);
            }
            case KeyWord.JPANEL: {
                return new JPanelBuilder(comp);
            }
        }
        System.out.println("Null JComponent Builder");
        return null;
    }
}
