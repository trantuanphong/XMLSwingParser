/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import model.MyComponent;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Phong
 */
public class XMLReader {

    private File file;
    
    public XMLReader(String fileName) {
        file = new File(fileName);
    }
    
    private Document initDocument() {
        Document document = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
        } catch (SAXException ex) {
            System.out.println("Document Build Exception");
        } catch (IOException ex) {
            System.out.println("File Exception");
        } finally {
            return document;
        }
    }

    private HashMap getAttributes(Node node) {
        HashMap attributes = new HashMap();
        NamedNodeMap nodeAttr = node.getAttributes();
        for (int i = 0; i < nodeAttr.getLength(); i++) {
            String key = nodeAttr.item(i).getNodeName();
            String value = nodeAttr.item(i).getNodeValue();
            attributes.put(key, value);
        }
        return attributes;
    }
    
    private MyComponent read(Node node) {
        MyComponent component = new MyComponent();
        ArrayList<MyComponent> childrenComponent = new ArrayList();
        if (node.hasChildNodes()) {
            NodeList childrenNode = node.getChildNodes();
            for (int i = 0; i < childrenNode.getLength(); i++) {
                if (childrenNode.item(i).getNodeName().equals("#text")) continue;
                childrenComponent.add(read(childrenNode.item(i)));
            }
        }
        component.setTagName(node.getNodeName());
        component.setAttributes(getAttributes(node));
        component.setChildren(childrenComponent);
        return component;
    }
    
    public MyComponent read() {
        return read(initDocument().getFirstChild());
    }
}
