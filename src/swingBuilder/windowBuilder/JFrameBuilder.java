/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.windowBuilder;

import swingBuilder.windowBuilder.WindowBuilder;
import java.awt.FlowLayout;
import java.awt.Window;
import javax.swing.JFrame;
import model.MyComponent;
import swingBuilder.SwingBuilderFactory;

/**
 *
 * @author Phong
 */
public class JFrameBuilder extends WindowBuilder {

    private JFrame jframe;
    
    public JFrameBuilder(MyComponent comp) {
        jframe = new JFrame(comp.getName());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(500,500);
        jframe.setLayout(new FlowLayout());
        for (MyComponent cmp : comp.getChildren()) {
            jframe.add(SwingBuilderFactory.getComponentBuilder(cmp).build());
        }
        jframe.setVisible(true);
    }
    
    @Override
    public Window build() {
        return jframe;
    }
    
}
