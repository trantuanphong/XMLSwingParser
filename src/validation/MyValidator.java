/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import model.MyComponent;
import model.ValidComponent;
import org.w3c.dom.Document;
import parser.ValidationReader;

/**
 *
 * @author Phong
 */
public class MyValidator {

    private static MyValidator instance;
    private HashMap<String, List<String>> wellComps;

    private MyValidator() {
        wellComps = new HashMap();
        parser.ValidationReader vr = new ValidationReader();
        Document doc = vr.initDocument("validation.xml");
        for (ValidComponent wellComp : vr.getListValidation(doc)) {
            wellComps.put(wellComp.getName(), wellComp.getListRequired());
        }
    }

    public static MyValidator getInstance() {
        if (instance == null) {
            instance = new MyValidator();
        }
        return instance;
    }

    public boolean isFileExist(String filePath) {
        return new File(filePath).exists();
    }

    public boolean isCorrectFileType(String filePath, String extension) {
        return filePath.toUpperCase().endsWith(extension.toUpperCase());
    }

    public ValidationResponse isWellComponent(MyComponent comp) {
        if (!wellComps.containsKey(comp.getTagName())) {
            return new ValidationResponse(false,
                    "Invalid tag " + comp.getTagName());
        } else {
            for (String require : wellComps.get(comp.getTagName())) {
                if (!comp.getAttributes().containsKey(require)) {
                    return new ValidationResponse(false,
                            "Tag " + comp.getTagName()
                            + " does not have required attribute: " + require);
                }
            }
            for (MyComponent child : comp.getChildren()) {
                ValidationResponse validRes = isWellComponent(child);
                if (!validRes.getResult()) {
                    return validRes;
                }
            }
        }
        return new ValidationResponse(true, "Success");
    }
}
