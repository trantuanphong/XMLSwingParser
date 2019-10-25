/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder;

import swingBuilder.windowBuilder.JFrameBuilder;
import swingBuilder.windowBuilder.WindowBuilder;
import swingBuilder.componentBuilder.JTextfieldBuilder;
import swingBuilder.componentBuilder.JLabelBuilder;
import swingBuilder.componentBuilder.JButtonBuilder;
import swingBuilder.componentBuilder.ComponentBuilder;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class SwingBuilderFactory {
    
    private SwingBuilderFactory() {
        
    }
    
    public static final WindowBuilder getWindowBuilder(MyComponent comp) {
        switch (comp.getName()) {
            case "jframe": {
                return new JFrameBuilder(comp);
            }
            case "jdialog": {
                return null;
            }
        }
        return null;
    }
    
    public static final ComponentBuilder getComponentBuilder(MyComponent comp) {
        switch (comp.getName()) {
            case "jlabel": {
                return new JLabelBuilder(comp);
            }
            case "jbutton": {
                return new JButtonBuilder(comp);
            }
            case "jtextfield": {
                return new JTextfieldBuilder(comp);
            }
        }
        return null;
    }
}
