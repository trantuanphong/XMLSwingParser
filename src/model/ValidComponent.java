/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Anh Hao
 */
public class ValidComponent {

    private String name;
    private List<String> listRequired;
    private List<String> listNoRequired;

    public ValidComponent() {
    }

    public ValidComponent(String name, List<String> listRequired, List<String> listNoRequired) {
        this.name = name;
        this.listRequired = listRequired;
        this.listNoRequired = listNoRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getListRequired() {
        return listRequired;
    }

    public void setListRequired(List<String> listRequired) {
        this.listRequired = listRequired;
    }

    public List<String> getListNoRequired() {
        return listNoRequired;
    }

    public void setListNoRequired(List<String> listNoRequired) {
        this.listNoRequired = listNoRequired;
    }

}
