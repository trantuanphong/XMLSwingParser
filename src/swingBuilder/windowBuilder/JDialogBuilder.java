/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.windowBuilder;

import java.awt.FlowLayout;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;
import model.MyComponent;
import swingBuilder.SwingBuilderFactory;

/**
 *
 * @author Phong
 */
public class JDialogBuilder extends WindowBuilder {

    private JDialog jdialog;
    
    public JDialogBuilder(MyComponent comp) {
        jdialog = new JDialog();
        jdialog.setTitle(comp.getName());
        jdialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jdialog.setSize(500,500);
        jdialog.setLayout(new FlowLayout());
        for (MyComponent cmp : comp.getChildren()) {
            jdialog.add(SwingBuilderFactory.getJComponentBuilder(cmp).build());
        }
        jdialog.setVisible(true);
    }
    
    @Override
    public Window build() {
        return this.jdialog;
    }
    
}
