/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import parser.XMLReader;
import swingBuilder.SwingBuilderFactory;

/**
 *
 * @author Phong
 */
public class Main {
    
    public static void main(String[] args){
        SwingBuilderFactory.getWindowBuilder(
                new XMLReader("login.xml").read())
                .build();
    }
    
}