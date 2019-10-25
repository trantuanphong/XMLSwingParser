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
    private String name;
    private HashMap<String,String> attributes;
    private ArrayList<MyComponent> children;

    public MyComponent() {
    }

    public MyComponent(String name, HashMap attribute, ArrayList<MyComponent> children) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyComponent{" + "name=" + name + '}';
    }
}
