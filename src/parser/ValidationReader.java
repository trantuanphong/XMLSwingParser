/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import model.WellComponent;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Anh Hao
 */
public class ValidationReader {

    public ValidationReader() {
    }
    
    public Document initDocument(String file) {
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
    
    public List<WellComponent> getListValidation(Document doc){
        List<WellComponent> listValidation = new ArrayList<>();
        
        NodeList components = doc.getElementsByTagName("component");
        for (int i = 0; i < components.getLength(); i++) {
            Node component = components.item(i);
            NamedNodeMap attributes = component.getAttributes();
            Node attr = attributes.getNamedItem("name");
                
            String name = attr.getNodeValue();
            List<String> listRequired = new ArrayList<>();
            List<String> listNoRequired = new ArrayList<>();    
                
            NodeList childs = component.getChildNodes();
            for (int j = 0; j < childs.getLength(); j++) {
                Node node = childs.item(j);
                if (node.getNodeName().equals("required")) {
                    listRequired.add(node.getTextContent());
                }
                if (node.getNodeName().equals("no-required")) {
                    listNoRequired.add(node.getTextContent());
                }
                if (j==(childs.getLength()-1)){
                    listValidation.add(new WellComponent(name, listRequired, listNoRequired));
                }
            }
        }
        return listValidation;   
    }
    
}
