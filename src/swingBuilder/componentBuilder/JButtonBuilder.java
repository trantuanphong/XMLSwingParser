/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import swingBuilder.componentBuilder.ComponentBuilder;
import javax.swing.JButton;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JButtonBuilder extends ComponentBuilder {
    private JButton jbutton;
    
    public JButtonBuilder(MyComponent comp) {
        jbutton = new JButton(comp.getName());
    }

    @Override
    public JButton build() {
        return this.jbutton;
    }
    
}
