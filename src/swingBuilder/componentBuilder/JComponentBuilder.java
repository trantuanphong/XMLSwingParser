/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import javax.swing.JComponent;
import swingBuilder.ContainerBuilder;

/**
 *
 * @author Phong
 */
public abstract class JComponentBuilder extends ContainerBuilder {
    public abstract JComponent build();
    
    protected JComponent initJComponentAttributes(JComponent jcomp, String attr, String value) {
        switch (attr) {
            default: {
                return (JComponent) initComponentAttributes(jcomp, attr, value);
            }
        }
    }
}
