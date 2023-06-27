package com.microsoft.azure.samples;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named("indexcontroller")
@ViewScoped
public class IndexController implements Serializable{

    private static final long serialVersionUID = 8485377386286855408L;

    @Setter @Getter
    private String inputValue;

    private int counter;

    public void submitButtonAction(){
        inputValue = inputValue + " : " + counter;
        counter++;
    }
}