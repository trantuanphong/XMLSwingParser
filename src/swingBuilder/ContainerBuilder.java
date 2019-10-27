/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder;

import common.KeyWord;
import java.awt.Container;

/**
 *
 * @author Phong
 */
public abstract class ContainerBuilder extends SwingBuilder {

    protected Container initComponentAttributes(Container container, String attr, String value) {
        switch (attr) {
            case KeyWord.NAME: {
                container.setName(value);
                break;
            }
        }
        return container;
    }
}
