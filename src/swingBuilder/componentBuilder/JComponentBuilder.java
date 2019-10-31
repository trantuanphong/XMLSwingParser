/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import javax.swing.JComponent;
import model.MyComponent;
import swingBuilder.ContainerBuilder;

/**
 *
 * @author Phong
 */
public abstract class JComponentBuilder extends ContainerBuilder {
    public abstract JComponent build();
    
    protected void initJComponentAttributes(JComponent jcomp, 
            String key, MyComponent comp) {
        switch (key) {
            default: {
                initComponentAttributes(jcomp, key, comp);
            }
        }
    }
}
