/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Phong
 */
public class MyComponent {
    private String tagName;
    private HashMap<String,String> attributes;
    private ArrayList<MyComponent> children;

    public MyComponent() {
    }

    public MyComponent(String tagName, HashMap attribute, ArrayList<MyComponent> children) {
        this.tagName = tagName;
        this.attributes = attribute;
        this.children = children;
    }

    public HashMap getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap attributes) {
        this.attributes = attributes;
    }

    public ArrayList<MyComponent> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<MyComponent> children) {
        this.children = children;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
