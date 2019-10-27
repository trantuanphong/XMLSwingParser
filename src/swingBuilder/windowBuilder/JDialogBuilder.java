/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.windowBuilder;

import java.awt.FlowLayout;
import java.awt.Window;
import javax.swing.JDialog;
import model.MyComponent;
import swingBuilder.ComponentBuilderFactory;

/**
 *
 * @author Phong
 */
public class JDialogBuilder extends WindowBuilder {

    private JDialog jdialog;
    
    public JDialogBuilder(MyComponent comp) {
        jdialog = new JDialog();
        jdialog.setTitle(comp.getName());
        jdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jdialog.setSize(500,500);
        jdialog.setLayout(new FlowLayout());
        for (MyComponent cmp : comp.getChildren()) {
            jdialog.add(ComponentBuilderFactory.getInstance()
                    .getJComponentBuilder(cmp).build());
        }
        jdialog.setVisible(true);
    }
    
    @Override
    public Window build() {
        return this.jdialog;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
    }
    
}
