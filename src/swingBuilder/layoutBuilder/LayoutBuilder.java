/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.layoutBuilder;

import java.awt.LayoutManager;
import swingBuilder.SwingBuilder;

/**
 *
 * @author Phong
 */
public abstract class LayoutBuilder extends SwingBuilder {
    public abstract LayoutManager build();
}
