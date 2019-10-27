/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.layoutBuilder;

import common.KeyWord;
import java.awt.FlowLayout;
import java.util.HashMap;
import model.MyComponent;

/**
 *
 * @author Phong
 */
public class FlowLayoutBuilder extends LayoutBuilder {
    private FlowLayout flowLayout;
    
    public FlowLayoutBuilder(MyComponent comp) {
        flowLayout = new FlowLayout();
        initAttributes(comp);
    }

    @Override
    public FlowLayout build() {
        return this.flowLayout;
    }

    @Override
    protected void initAttributes(MyComponent comp) {
        HashMap<String, String> attributes = comp.getAttributes();
        for (String key : attributes.keySet()) {
            switch (key) {
                case KeyWord.ALIGN: {
                    flowLayout.setAlignment(getAlign(attributes.get(key)));
                    break;
                }
                case KeyWord.HGAP: {
                    flowLayout.setHgap(Integer.parseInt(attributes.get(key)));
                    break;
                }
                case KeyWord.VGAP: {
                    flowLayout.setVgap(Integer.parseInt(attributes.get(key)));
                    break;
                }
                default: {
                    
                }
            }
        }
    }
    
    private int getAlign(String value) {
        switch (value) {
            case KeyWord.CENTER: {
                return FlowLayout.CENTER;
            }
            case KeyWord.TRAILING: {
                return FlowLayout.TRAILING;
            }
            case KeyWord.LEFT: {
                return FlowLayout.LEFT;
            }
            case KeyWord.RIGHT: {
                return FlowLayout.RIGHT;
            }
            default: {
                return FlowLayout.LEADING;
            }
        }
    }
}
