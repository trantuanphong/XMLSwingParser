/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder;

import common.KeyWord;
import java.awt.Container;
import model.MyComponent;
import swingBuilder.layoutBuilder.LayoutBuilderFactory;

/**
 *
 * @author Phong
 */
public abstract class ContainerBuilder extends SwingBuilder {

    protected Container initComponentAttributes(Container container, 
            String key, MyComponent comp) {
        switch (key) {
            case KeyWord.NAME: {
                container.setName(comp.getAttributes().get(key).toString());
                break;
            }
            case KeyWord.LAYOUT: {
                container.setLayout(LayoutBuilderFactory.getInstance()
                        .getLayoutBuilder(container, comp, 
                                comp.getAttributes().get(key).toString())
                        .build());
                break;
            }
        }
        return container;
    }
    
    protected Container addChildComponent(Container container, MyComponent comp) {
        for (MyComponent cmp : comp.getChildren()) {
            container.add(ComponentBuilderFactory.getInstance()
                    .getJComponentBuilder(cmp).build());
        }
        return container;
    }
    
    
}
