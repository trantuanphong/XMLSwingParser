/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.windowBuilder;

import java.awt.Window;
import swingBuilder.ContainerBuilder;

/**
 *
 * @author Phong
 */
public abstract class WindowBuilder extends ContainerBuilder {
    public abstract Window build();
}
