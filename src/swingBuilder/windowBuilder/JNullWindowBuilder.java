/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.windowBuilder;

import javax.swing.JDialog;
import javax.swing.JLabel;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JNullWindowBuilder extends WindowBuilder {

    private JDialog jdialog;
    
    public JNullWindowBuilder(MyComponent comp) {
        jdialog = new JDialog();
        jdialog.add(new JLabel("Build Fail!"));
        jdialog.pack();
    }
    
    @Override
    public JDialog build() {
        return this.jdialog;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        jdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jdialog.setVisible(true);
    }
    
}
