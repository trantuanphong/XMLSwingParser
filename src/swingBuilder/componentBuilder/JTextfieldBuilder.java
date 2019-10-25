/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import swingBuilder.componentBuilder.ComponentBuilder;
import javax.swing.JComponent;
import javax.swing.JTextField;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JTextfieldBuilder extends ComponentBuilder{

    private JTextField jTextfield;
    
    public JTextfieldBuilder(MyComponent comp) {
        jTextfield = new JTextField(comp.getName());
        jTextfield.setSize(50, 20);
    }
    
    @Override
    public JComponent build() {
        return this.jTextfield;
    }
    
}
