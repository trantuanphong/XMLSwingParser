/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingBuilder.componentBuilder;

import common.KeyWord;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import model.MyComponent;
import swingBuilder.ContainerBuilder;

/**
 *
 * @author Phong
 */
public abstract class JComponentBuilder extends ContainerBuilder {
    protected static HashMap<String, ButtonGroup> buttonGroups = new HashMap();
    public abstract JComponent build();
    
    protected void initJComponentAttributes(JComponent jcomp, 
            String key, MyComponent comp) {
        switch (key) {
            case KeyWord.FONT_SIZE: {
                int size = getFontSize(comp.getAttributes().get(key).toString());
                if (size > 0) {
                    jcomp.setFont(new Font(jcomp.getFont().getName(), 
                        jcomp.getFont().getStyle(), size));
                }
                break;
            }
            case KeyWord.FONT_STYLE: {
                jcomp.setFont(new Font(jcomp.getFont().getName(), 
                        getFontStyle(comp.getAttributes().get(key).toString()), 
                        jcomp.getFont().getSize()));
                break;
            }
            case KeyWord.FONT_NAME: {
                jcomp.setFont(new Font(getFontName(comp.getAttributes().get(key).toString()), 
                        jcomp.getFont().getStyle(), 
                        jcomp.getFont().getSize()));
                break;
            }
            default: {
                initComponentAttributes(jcomp, key, comp);
            }
        }
    }
    
    private int getFontSize(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception ex) {
            return -1;
        }
    }
    
    private int getFontStyle(String input) {
        switch (input.toLowerCase()) {
            case KeyWord.BOLD: {
                return Font.BOLD;
            }
            case KeyWord.ITALIC: {
                return Font.ITALIC;
            }
            default: {
                return Font.PLAIN;
            }
        } 
    }
    
    private String getFontName(String input) {
        switch (input.toLowerCase()) {
            case KeyWord.SERIF: {
                return Font.SERIF;
            }
            case KeyWord.SANS_SERIF: {
                return Font.SANS_SERIF;
            }
            case KeyWord.DIALOG: {
                return Font.DIALOG;
            }
            case KeyWord.DIALOG_INPUT: {
                return Font.DIALOG_INPUT;
            }
            default: {
                return Font.MONOSPACED;
            }
        }
    }
}
