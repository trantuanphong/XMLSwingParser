/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import javax.swing.JLabel;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JNullComponentBuilder extends JComponentBuilder {
    private JLabel jlabel;
    
    public JNullComponentBuilder(MyComponent comp) {
        jlabel = new JLabel();
        initAttributes(comp);
    }
    
    @Override
    public JLabel build() {
        return this.jlabel;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        jlabel.setText("Does not support " + comp.getTagName() + " tag!");
    }
    
}
