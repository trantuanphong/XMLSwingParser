/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.util.HashMap;
import javax.swing.JPasswordField;
import model.MyComponent;

/**
 *
 * @author Anh Hao
 */
public class JPasswordFieldBuilder extends JComponentBuilder{

    private JPasswordField jpassword;
    
    public JPasswordFieldBuilder(MyComponent comp){
        jpassword = new JPasswordField();
        initAttributes(comp);
    }
    
    @Override
    public JPasswordField build() {
        return this.jpassword;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.TEXT: {
                    jpassword.setText(attributes.get(key));
                    break;
                }
                case KeyWord.LENGTH: {
                    jpassword.setColumns(Integer.parseInt(attributes.get(key)));
                    break;
                }
                default: {
                    initJComponentAttributes(jpassword, key, comp);
                }
            }
        }
    }
    
}
