/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import swingBuilder.componentBuilder.ComponentBuilder;
import javax.swing.JLabel;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JLabelBuilder extends ComponentBuilder {
    private JLabel jlabel;
    
    public JLabelBuilder(MyComponent comp) {
        jlabel = new JLabel(comp.getName());
    }
    
    public JLabel build() {
        return this.jlabel;
    }
}
