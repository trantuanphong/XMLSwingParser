/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.windowBuilder;

import common.KeyWord;
import java.awt.Window;
import java.util.HashMap;
import javax.swing.JDialog;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class JDialogBuilder extends WindowBuilder {

    private JDialog jdialog;

    public JDialogBuilder(MyComponent comp) {
        jdialog = new JDialog();
    }

    @Override
    public Window build() {
        return this.jdialog;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        jdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jdialog.setVisible(true);
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.TITLE: {
                    jdialog.setTitle(attributes.get(key));
                    break;
                }
                default: {
                    initComponentAttributes(jdialog.getContentPane(), key, comp);
                }
            }
        }
    }
}
