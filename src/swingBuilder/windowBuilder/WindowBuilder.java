/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.windowBuilder;

import common.KeyWord;
import java.awt.Window;
import swingBuilder.ContainerBuilder;
import swingBuilder.layoutBuilder.LayoutBuilderFactory;

/**
 *
 * @author Phong
 */
public abstract class WindowBuilder extends ContainerBuilder {
    public abstract Window build();
    
    protected Window initWindowAttributes(Window window, String attr, String value) {
        switch (attr) {
            default: {
                return (Window) initComponentAttributes(window, attr, value);
            }
        }
    }
}
