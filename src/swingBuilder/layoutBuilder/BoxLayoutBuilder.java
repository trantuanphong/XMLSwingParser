/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.layoutBuilder;

import javax.swing.BoxLayout;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class BoxLayoutBuilder extends LayoutBuilder {
    private BoxLayout boxLayout;
    
    public BoxLayoutBuilder(MyComponent comp) {
        boxLayout = new BoxLayout(null, 0);
        initAttributes(comp);
    }

    @Override
    public BoxLayout build() {
        return this.boxLayout;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
